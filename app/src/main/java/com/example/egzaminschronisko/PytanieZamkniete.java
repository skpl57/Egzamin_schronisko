package com.example.egzaminschronisko;
public class PytanieZamkniete extends Pytanie{
    private String trescA;
    private String trescB;
    private String trescC;
    private char poprawnaOdp;

    public PytanieZamkniete(String trescPytania, int nazwaPliku, String trescA, String trescB, String trescC, char poprawnaOdp) {
        super(trescPytania, nazwaPliku);
        this.trescA = trescA;
        this.trescB = trescB;
        this.trescC = trescC;
        this.poprawnaOdp = poprawnaOdp;
    }

    @Override
    boolean sprawdzOdpowiedz(char znak) {
        return poprawnaOdp == znak;
    }

    public String getTrescA() {
        return trescA;
    }

    public String getTrescB() {
        return trescB;
    }

    public String getTrescC() {
        return trescC;
    }
}
