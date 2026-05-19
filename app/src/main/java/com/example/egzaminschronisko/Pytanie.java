package com.example.egzaminschronisko;
public abstract class Pytanie {
    protected String trescPytania;
    protected int nazwaPliku;
    protected boolean czyPoprawna;

    public Pytanie(String trescPytania, int nazwaPliku) {
        this.trescPytania = trescPytania;
        this.nazwaPliku = nazwaPliku;
        czyPoprawna = false;
    }
    abstract boolean sprawdzOdpowiedz(char znak);
}
