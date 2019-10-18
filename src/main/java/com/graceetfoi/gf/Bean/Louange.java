//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.graceetfoi.gf.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
        name = "louange"
)
public class Louange {
    @Id
    @Column(
            name = "id"
    )
    private int idLouange;
    @Column(
            name = "nom"
    )
    private String nom;
    @Column(
            name = "lien"
    )
    private String lien;
    @Column(
            name = "id_tab"
    )
    private int table;

    Louange() {
    }

    public Louange(int idLouange, String nom, String lien, int table) {
        this.idLouange = idLouange;
        this.lien = lien;
        this.nom = nom;
        this.table = table;
    }

    public String getLien() {
        return this.lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getTable() {
        return this.table;
    }

    public int getIdLouange() {
        return this.idLouange;
    }
}
