package com.graceetfoi.gf.Bean;

import javax.persistence.*;

@Entity
public class Louange {


    @Id
    @Column(name = "id")
    private int idLouange;

    @Column(name = "nom")
    private String nom;

    @Column(name = "nom_Fichier")
    private String nomFichier;

    @Column(name = "lyrics")
    private String lyrics;

    @Column(name = "id_tab")
            private int table;

    Louange(){}

    public Louange(String nom,String nomFichier, String lyrics, int table){
        this.lyrics=lyrics;
        this.nom=nom;
        this.nomFichier=nomFichier;
        this.table=table;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getNomFichier() {
        return nomFichier;
    }

    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getTable() {
        return table;
    }
}
