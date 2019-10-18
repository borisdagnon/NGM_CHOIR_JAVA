//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.graceetfoi.gf.Bean;

import javax.persistence.*;

@Entity
@Table(
        name = "audio"
)
public class Audio {
    @Id
    @GeneratedValue
    @Column(
            name = "id"
    )
    private int id;
    @Column(
            name = "titre"
    )
    private String titre;
    @Column(
            name = "lien"
    )
    private String lien;
    @Column(
            name = "annee"
    )
    private String annee;



    public Audio() {
    }

    public Audio(String titre, String lien, String annee) {
        this.titre = titre;
        this.lien = lien;
        this.annee = annee;
    }

    public int getIdAudio() {
        return this.id;
    }

    public String getTitre() {
        return this.titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getLien() {
        return this.lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public String getAnnee() {
        return this.annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

}
