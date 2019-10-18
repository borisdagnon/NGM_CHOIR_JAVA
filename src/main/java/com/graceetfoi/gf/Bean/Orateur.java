//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.graceetfoi.gf.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
        name = "orateur"
)
public class Orateur {
    @Id
    @GeneratedValue
    @Column(
            name = "id"
    )
    private int id;
    @Column(
            name = "nom"
    )
    private String nom;
    @Column(
            name = "prenom"
    )
    private String prenom;
    @Column(
            name = "aka"
    )
    private String aka;
    @Column(
            name = "datenaissance"
    )
    private String datenaissance;
    @Column(
            name = "biographie"
    )
    private String biographie;
    @Column(
            name = "appele"
    )
    private String appele;

    public Orateur() {
    }

    public Orateur(String nom, String prenom, String datenaissance, String aka) {
        this.nom = nom;
        this.prenom = prenom;
        this.aka = aka;
        this.datenaissance = datenaissance;
    }

    public int getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAka() {
        return this.aka;
    }

    public void setAka(String aka) {
        this.aka = aka;
    }

    public String getDatenaissance() {
        return this.datenaissance;
    }

    public void setDatenaissance(String datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getBiographie() {
        return this.biographie;
    }

    public void setBiographie(String biographie) {
        this.biographie = biographie;
    }

    public String getAppele() {
        return this.appele;
    }

    public void setAppele(String appele) {
        this.appele = appele;
    }
}
