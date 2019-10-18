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
        name = "evenement"
)
public class Evenement {
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
            name = "date_evenement"
    )
    private String date_evenement;
    @Column(
            name = "description"
    )
    private String description;
    @Column(
            name = "contenu"
    )
    private String contenu;

    public Evenement() {
    }

    public Evenement(String titre, String date_evenement, String description, String contenu) {
        this.titre = titre;
        this.date_evenement = date_evenement;
        this.description = description;
        this.contenu = contenu;
    }

    public int getId() {
        return this.id;
    }

    public String getTitre() {
        return this.titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDate_evenement() {
        return this.date_evenement;
    }

    public void setDate_evenement(String date_evenement) {
        this.date_evenement = date_evenement;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContenu() {
        return this.contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
}
