//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.graceetfoi.gf.Bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(
        name = "video"
)
public class Video {
    @Id
    @GeneratedValue
    @Column(
            name = "id"
    )
    private int id;
    private String lien;
    private String an;
    private String titre;
    private String formatdate;

    @OneToOne(
            cascade = {CascadeType.ALL}
    )
    @JoinTable(
            name = "video_orateur",
            joinColumns = {@JoinColumn(
                    name = "video_id"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "orateur_id"
            )}
    )
    private Orateur orateur;



    /*@Column(
            name = "id_tab"
    )
    private int table;*/

    public Video() {
    }

    public Video(String titre, String lien, String an, /*int table,*/ Orateur orateur) {
        this.titre = titre;
        this.lien = lien;
        this.an = an;
        //this.table = table;
        this.orateur = orateur;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLien() {
        return this.lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public String getAn() {
        return this.an;
    }

    public void setAn(String an) {
        this.an = an;
    }

    public String getTitre() {
        return this.titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getFormatdate() {
        return this.formatdate;
    }

    public void setFormatdate(String formatdate) {
        this.formatdate = formatdate;
    }

   /* public int getTable() {
        return this.table;
    }*/

    public Orateur getOrateur() {
        return this.orateur;
    }

    public void setOrateur(Orateur orateur) {
        this.orateur = orateur;
    }



}
