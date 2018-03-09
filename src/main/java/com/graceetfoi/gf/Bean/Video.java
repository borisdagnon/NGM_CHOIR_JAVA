package com.graceetfoi.gf.Bean;

import javax.persistence.*;

@Entity
public class Video {

    @Id
    @GeneratedValue
    private String id;
    private String lien;
    private String annee;
    private String titre;
    private String format;



    @Column(name = "id_tab")
    private int table;


    public Video(){

    }

public Video(String titre,String lien,String annee,int table){
        this.titre=titre;
    this.lien=lien;
    this.annee=annee;
    this.table=table;


}
    public String getId() {
        return id;
    }


    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getTable() {
        return table;
    }
}
