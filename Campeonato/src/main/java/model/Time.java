/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Time {
    
    public String nome;
    int vitorias = 0;
    int derrotas = 0;
    int empates = 0;
    int golPro = 0;
    int golContra = 0;
    byte clas = 0; // de 255 até -255
    List<Jogo> jogos = new ArrayList<Jogo>();
    
    
    public Time(String nome, int vitorias, int derrotas, int empates, int golPro, int golContra) {
        this.nome = nome;
        this.vitorias = vitorias;
        this.derrotas = derrotas;
        this.empates = empates;
        this.golPro = golPro;
        this.golContra = golContra;
    }

    public Time() {
    }

    public Time(String nome) {
        this.nome = nome;
    }

    public int getSaldo() {
        return golPro - golContra;
    }
    
    public int getPontos() {
        return vitorias * 3 + empates;
    }
    
    public int getPartidas() {
        return vitorias + derrotas + empates;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVitorias() {
        return vitorias;
    }
    
    public void addGolPro(byte gols){
        this.golPro += gols;
    }

    public void addGolContra(byte gols){
        this.golContra += gols;
    }

    public byte getClas() {
        return clas;
    }

    public void setClas(byte clas) {
        this.clas = clas;
    }   

    public void setVitorias(int vitorias) {
        if (vitorias >= 0) {
            this.vitorias = vitorias;
        } else {
            this.vitorias = 0;
        }
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        if (derrotas >= 0) {
            this.derrotas = derrotas;
        } else {
            this.derrotas = 0;
        }  
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        if (derrotas >= 0) {
            this.empates = empates;
        } else {
            this.empates = 0;
        } 
    }

    public int getGolPro() {
        return golPro;
    }

    public void setGolPro(int golPro) {
        if (golPro >= 0) {
            this.golPro = golPro;
        } else {
            this.golPro = 0;
        }
    }

    public int getGolContra() {
        return golContra;
    }

    public void setGolContra(int golContra) {
        if (golContra >= 0) {
            this.golContra = golContra;
        } else {
            this.golContra = 0;
        }     
    }
    
    public void addVitoria() {
        this.vitorias += 1;
    }
    
    public void addDerrota() {
        this.derrotas += 1;
    }
    
    public void addEmpate() {
        this.empates += 1;
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    @Override
    public String toString() {
        return "Time{" + "nome=" + nome + ", ptos=" + getPontos() + '}';
    }


}