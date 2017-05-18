/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author deinfo
 */
public class Jogo extends Time {
    String timeA, timeB;
    byte golA, golB;

    public String getTimeA() {
        return timeA;
    }

    public void setTimeA(String timeA) {
        this.timeA = timeA;
    }

    public String getTimeB() {
        return timeB;
    }

    public void setTimeB(String timeB) {
        this.timeB = timeB;
    }

    public byte getGolA() {
        return golA;
    }

    public void setGolA(byte golA) {
        this.golA = golA;
    }

    public byte getGolB() {
        return golB;
    }

    public void setGolB(byte golB) {
        this.golB = golB;
    }

    public Jogo() {
        
    }
    
    public Jogo(String timeA, String golA, String timeB, String golB) {
        this.timeA = timeA.toUpperCase();
        this.timeB = timeB.toUpperCase();
        this.golA = Byte.parseByte(golA);
        this.golB = Byte.parseByte(golB);
    }     
    
}
