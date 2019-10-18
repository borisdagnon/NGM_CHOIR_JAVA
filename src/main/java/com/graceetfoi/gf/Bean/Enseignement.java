//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.graceetfoi.gf.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
        name = "enseignement"
)
public class Enseignement {
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
            name = "nomphoto"
    )
    private String nomphoto;
    @Column(
            name = "resume"
    )
    private String resume;
    @Column(
            name = "annee"
    )
    private Date annee;
    private String contenu;



    @Column(name = "lienaudio")
    private String lienaudio;

    public Enseignement() {
    }

    public Enseignement(String titre, Date annee, String nomphoto, String resume, String contenu,String lienaudio) {
        this.titre = titre;
        this.nomphoto = nomphoto;
        this.resume = resume;
        this.annee = annee;
        this.contenu = contenu;
        this.lienaudio=lienaudio;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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
        if(!nomphoto.equals("")){
            this.nomphoto = nomphoto;
        }

    }

    public String getResume() {
        return this.resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Date getAnnee() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.format(this.annee);
        return this.annee;
    }

    public void setAnnee(Date annee) {
        this.annee = annee;
    }

    public String getContenu() {
        return this.contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getLienaudio() {
        return lienaudio;
    }

    public void setLienaudio(String lienaudio) {
        this.lienaudio = lienaudio;
    }
}
