package org.example;

public class Piatto {
    int id;
    String nome;
    double prezzo;
    String descrizione;

    public Piatto(int id, String nome, double prezzo, String descrizione) {
        this.id = id;
        this.nome = nome;
        this.prezzo = prezzo;
        this.descrizione = descrizione;
    }


    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

}
