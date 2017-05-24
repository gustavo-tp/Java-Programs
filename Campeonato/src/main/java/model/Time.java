/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Gusta
 */
public class Time {
    String nome;
    Integer vit = 0, der = 0, emp = 0;
    Integer golP = 0, golN = 0;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        if(vit > 0)
            this.vit = vit;
    }

    public int getDer() {
        return der;
    }

    public void setDer(int der) {
        if(der > 0)
            this.der = der;
    }

    public int getEmp() {
        return emp;
    }

    public void setEmp(int emp) {
        if(emp > 0)
            this.emp = emp;
    }

    public int getGolP() {
        return golP;
    }

    public void setGolP(int golP) {
        if(golP > 0)
            this.golP = golP;
    }

    public int getGolN() {
        return golN;
    }

    public void setGolN(int golN) {
        if(golN > 0)
            this.golN = golN;
    }
    
    int saldoGols() {
        return golP - golN;
    }
    
    int pontos() {
        return (vit*3) + emp;
    }
    
    int partidas() {
        return vit + der + emp;
    }
    
    void addVit() {
        this.vit++;        
    }
    
    void addEmp() {
        this.emp++;        
    }
    
    void addDer() {
        this.der++;
    }
    
    void addGolP(byte gols) {
        this.golP += gols;
    }
    
    void addGolN(byte gols) {
        this.golN += gols;
    }

    public Time() {
    }

    public Time(String nome) {
        this.nome = nome;
    }
  
       
    @Override
    public String toString() {
        return "Time{" + "nome=" + nome + '}';
    }  
}
