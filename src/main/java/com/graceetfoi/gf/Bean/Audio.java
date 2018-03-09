package com.graceetfoi.gf.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Audio {


    @Id
    @GeneratedValue
    @Column(name = "id")
    private int idAudio;

    @Column(name = "nom")
    private String nom;

    @Column(name = "nom_Fichier")
    private String nomFichier;

    @Column(name = "id_tab")
    private int table;

    public Audio(){}

    public Audio(String nom,String nomFichier, int table){
        this.nom=nom;
        this.nomFichier =nomFichier;
        this.table=table;
    }

    public int getId() {
        return idAudio;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomFichier() {
        return nomFichier;
    }

    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    public int getTable() {
        return table;
    }

}
