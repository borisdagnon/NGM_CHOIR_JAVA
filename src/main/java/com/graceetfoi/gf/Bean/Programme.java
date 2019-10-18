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
        name = "programme"
)
public class Programme {
    @Id
    @GeneratedValue
    @Column(
            name = "id"
    )
    private Integer id;
    @Column(
            name = "titre"
    )
    private String titre;
    @Column(
            name = "nomphoto"
    )
    private String nomphoto;
    @Column(
            name = "contenu"
    )
    private String contenu;
    @Column(
            name = "resume"
    )
    private String resume;
    @Column(
            name = "jour"
    )
    private String jour;

    public Programme() {
    }

    public Programme(String titre, String nomphoto, String contenu, String resume, String jour) {
        this.titre = titre;
        this.nomphoto = nomphoto;
        this.contenu = contenu;
        this.resume = resume;
        this.jour = jour;
    }

    public Integer getId() {
        return this.id;
    }

    public String getTitre() {
        return this.titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getNomphoto() {
        return this.nomphoto;
    }

    public void setNomphoto(String nomphoto) {
        this.nomphoto = nomphoto;
    }

    public String getContenu() {
        return this.contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getResume() {
        return this.resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getJour() {
        return this.jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }
}
