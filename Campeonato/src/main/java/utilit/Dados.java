/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Jogo;
import model.Time;

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
    
    private Time achaTime(String nomeBusca){
        for (Time t : lstTimes) {
            if (t.getNome().equals(nomeBusca)) {
                return t;
            }
        }
        Time novoTime = new Time(nomeBusca);
        lstTimes.add(novoTime);
        
        return novoTime;
    }
    
    private void analisa (Jogo jg) {
        Time posTimeA, posTimeB;
        
        posTimeA = achaTime(jg.getTimeA());
        posTimeB = achaTime(jg.getTimeB());
        
        
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
            while ((j > 0) && ((lstTimes.get(j - 1).getPontos() < lstTimes.get(j).getPontos()) ||
                              ((lstTimes.get(j - 1).getPontos() == lstTimes.get(j).getPontos()) &&
                              (lstTimes.get(j - 1).getVitorias() < lstTimes.get(j).getVitorias())) ||
                              ((lstTimes.get(j - 1).getVitorias() == lstTimes.get(j).getVitorias()) &&
                              (lstTimes.get(j - 1).getSaldo()< lstTimes.get(j).getSaldo()))))                 
            {
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
