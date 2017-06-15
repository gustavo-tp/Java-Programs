/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Jogo;
import model.Time;
import org.json.JSONObject;

/**
 *
 * @author idomar
 */
public class Dados {

    private BufferedReader br = null;
    private String nomeArq;
    private Jogo jgLinha;

    List<Time> lstTimes = new ArrayList<>();

    public Dados(String nomeArq) {
        this.nomeArq = nomeArq;
    }

    private Time achaTime(String nomeBusca) {
        for (Time t : lstTimes) {
            if (t.getNome().equals(nomeBusca)) {
                return t;
            }
        }
        Time novoTime = new Time(nomeBusca);
        lstTimes.add(novoTime);

        return novoTime;
    }

    public void gravaJogoTime(Time time) {
        try {
            String nomeArq = "C:\\dados\\" + time.getNome() + ".json";

            File file = new File(nomeArq);
            file.createNewFile();
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            JSONObject eJSON = new JSONObject();

            for (Jogo j : time.getJogos()) {
                eJSON.put("timeA", j.getTimeA());
                eJSON.put("golA", j.getGolA());
                eJSON.put("timeB", j.getTimeB());
                eJSON.put("golB", j.getGolB());
                bw.write(eJSON.toString() + "\n");
            }

            bw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Jogo> lerJogoTime(Time time) {
        List<Jogo> info = new ArrayList<>();
        Jogo jogoTmp;
        String linha;
        try {
            br = new BufferedReader(new FileReader("C:\\dados\\" + time.getNome() + ".json"));
            while ((linha = br.readLine()) != null) {
                JSONObject eJSON = new JSONObject(linha);
                Integer golA = eJSON.getInt("golA");
                Integer golB = eJSON.getInt("golB");
                String timeA = eJSON.getString("timeA");
                String timeB = eJSON.getString("timeB");
                jogoTmp = new Jogo(timeA, golA.byteValue(),
                                   timeB, golB.byteValue());

                info.add(jogoTmp);
            }
        } catch (Exception e) {
            System.out.println("Erro ao abrir arquivo!" + e.getMessage());
        }
        return info;
    }

    private void analisa(Jogo jg) {
        Time posTimeA, posTimeB;

        posTimeA = achaTime(jg.getTimeA());
        posTimeB = achaTime(jg.getTimeB());

        posTimeA.getJogos().add(jg);
        posTimeB.getJogos().add(jg);

        if (jg.getGolA() > jg.getGolB()) {  // A Venceu
            posTimeA.addVitoria();
            posTimeB.addDerrota();
        } else if (jg.getGolA() < jg.getGolB()) { // B Venceu
            posTimeB.addVitoria();
            posTimeA.addDerrota();
        } else {  // Empate
            posTimeA.addEmpate();
            posTimeB.addEmpate();
        }

        posTimeA.addGolPro(jg.getGolA());
        posTimeA.addGolContra(jg.getGolB());
        posTimeB.addGolPro(jg.getGolB());
        posTimeB.addGolContra(jg.getGolA());

    }

    public void ordena() {
        Time timeAux;
        int i, j;
        i = 1;
        while (i <= lstTimes.size() - 1) {
            j = i;
            while ((j > 0) && ((lstTimes.get(j - 1).getPontos() < lstTimes.get(j).getPontos())
                    || ((lstTimes.get(j - 1).getPontos() == lstTimes.get(j).getPontos())
                    && (lstTimes.get(j - 1).getVitorias() < lstTimes.get(j).getVitorias()))
                    || ((lstTimes.get(j - 1).getVitorias() == lstTimes.get(j).getVitorias())
                    && (lstTimes.get(j - 1).getSaldo() < lstTimes.get(j).getSaldo())))) {
                timeAux = lstTimes.get(j - 1);
                lstTimes.set(j - 1, lstTimes.get(j));
                lstTimes.set(j, timeAux);
                j--;
            }
            i++;
        }
    }

    public List<Time> ler() {
        String linha;
        try {
            br = new BufferedReader(new FileReader(nomeArq));
            while ((linha = br.readLine()) != null) {
                jgLinha = new Jogo(linha);
                analisa(jgLinha);
            }
            ordena();

            byte i = 1;
            for (Time t : lstTimes) {
                t.setClas(i);
                i++;
            }

        } catch (Exception e) {

        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
            }
        }
        return lstTimes;
    }

}
