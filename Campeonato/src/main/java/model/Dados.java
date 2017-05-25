/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author deinfo
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

    private void analisa(Jogo jg) {
        Time posTimeA, posTimeB;

        posTimeA = achaTime(jg.getTimeA());
        posTimeB = achaTime(jg.getTimeB());
        

        if (jg.getGolA() > jg.getGolB()) { // A ganhou
            posTimeA.addVit();
            posTimeB.addDer();
        } else if (jg.getGolA() < jg.getGolB()) {
            posTimeB.addVit();
            posTimeA.addDer();
        } else {
            posTimeA.addEmp();
            posTimeB.addEmp();
        }
        posTimeA.addGolP(jg.getGolA());
        posTimeA.addGolN(jg.getGolB());
        posTimeB.addGolP(jg.getGolB());
        posTimeB.addGolN(jg.getGolA());
    }

    public List<Time> ler() {
        String linha;
        try {
            br = new BufferedReader(new FileReader(nomeArq));
            while ((linha = br.readLine()) != null) {

                jgLinha = new Jogo(linha);

                analisa(jgLinha);
            }
            
            Time aux = new Time();
            for (Time t : lstTimes) {                
                if (t.getPontos() > aux.getPontos())
                    aux = t;
            }
            System.out.println("Campeão: " + aux);

        } catch (Exception e) {
            //System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());           
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
