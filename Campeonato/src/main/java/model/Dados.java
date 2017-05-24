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
   
   public Dados (String nomeArq) {
       this.nomeArq = nomeArq;
   }
   
   private Time achaTime (String nomeBusca) {
       for (Time t : lstTimes) {
           if (t.getNome().equals(nomeBusca)) {
               return t;
           }
       }
       Time novoTime = new Time();
       return novoTime;
   }
   
   private void analisa (Jogo jg) {
       Time posTimeA, posTimeB;
       
       posTimeA = achaTime(jg.getTimeA());
       posTimeB = achaTime(jg.getTimeB());
       
   }
   
   public List<Time> ler() {
       String linha;
       try {
           br = new BufferedReader (new FileReader(nomeArq));
           while ((linha = br.readLine()) != null) {
               jgLinha = new Jogo(linha);
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
