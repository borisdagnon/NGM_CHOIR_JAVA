//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.graceetfoi.gf.service;

import com.graceetfoi.gf.Bean.Enseignement;
import com.graceetfoi.gf.data.DaoEnseignement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnseignementService {
    @Autowired
    private DaoEnseignement daoEnseignement;

    public EnseignementService() {
    }

    public int nombreEnseignement() {
        return this.daoEnseignement.nombreEnseignement();
    }

    public int nombreEnseignement(String combo, String annee, String theme) {
        int retour = 0;
        if (combo.equals("anneeOuiThemeNon")) {
            if (annee.equals("Toutes")) {
                retour = this.daoEnseignement.nombreEnseignement();
            } else {
                retour = this.daoEnseignement.nombreEnseignementParAnnee(annee);
            }
        } else if (combo.equals("anneeNonThemeOui")) {
            if (theme.equals("Tous")) {
                retour = this.daoEnseignement.nombreEnseignementParThemeTous();
            } else {
                retour = this.daoEnseignement.nombreEnseignementParTheme(theme);
            }
        } else if (combo.equals("anneeOuiThemeOui")) {
            if (theme.equals("Tous") && annee.equals("Toutes")) {
                retour = this.daoEnseignement.nombreEnseignement();
            } else if (!theme.equals("Tous") && annee.equals("Toutes")) {
                retour = this.daoEnseignement.nombreEnseignementParTheme(theme);
            } else if (theme.equals("Tous") && !annee.equals("Toutes")) {
                retour = this.daoEnseignement.nombreEnseignementParAnnee(annee);
            } else if (!theme.equals("Tous") && !annee.equals("Toutes")) {
                retour = this.daoEnseignement.nombreEnseignementParAnneeEtTheme(annee, theme);
            } else if (!theme.equals("") && !annee.equals("")) {
                retour = this.daoEnseignement.nombreEnseignement();
            }
        }

        return retour;
    }

    public List<Enseignement> dispatch(String combo, String annee, String theme, int off) {
        List<Enseignement> EnseignementList = new ArrayList();
        off = 9 * (off - 1) < 0 ? 0 : 9 * (off - 1);
        if (combo.equals("anneeNonThemeOui")) {
            if (theme.equals("Tous")) {
                System.out.println("anneeNonThemeOuiTous" + off);
                EnseignementList = this.daoEnseignement.anneeNonThemeOuiTous(off);
            } else {
                System.out.println("anneeNonThemeOui" + off);
                EnseignementList = this.daoEnseignement.anneeNonThemeOui(theme, off);
            }
        } else if (combo.equals("anneeOuiThemeNon")) {
            if (annee.equals("Toutes")) {
                System.out.println("anneeOuiThemeNonToutes" + off);
                EnseignementList = this.daoEnseignement.anneeOuiThemeNonToutes(off);
            } else {
                System.out.println("anneeOuiThemeNon" + off);
                EnseignementList = this.daoEnseignement.anneeOuiThemeNon(annee, off);
            }
        } else if (combo.equals("anneeOuiThemeOui")) {
            if (annee.equals("Toutes") && theme.equals("Tous")) {
                System.out.println("anneeOuiThemeOuiToutesEtTous" + off);
                EnseignementList = this.daoEnseignement.anneeOuiThemeOuiToutesEtTous(off);
            } else if (!annee.equals("Toutes") && theme.equals("Tous")) {
                System.out.println("anneeOuiThemeNon" + off);
                EnseignementList = this.daoEnseignement.anneeOuiThemeNon(annee, off);
            } else if (annee.equals("Toutes") && !theme.equals("Tous")) {
                System.out.println("anneeNonThemeOui" + off);
                EnseignementList = this.daoEnseignement.anneeNonThemeOui(theme, off);
            } else if (!annee.equals("Toutes") && !theme.equals("Tous")) {
                System.out.println("anneeOuiThemeOui" + off);
                EnseignementList = this.daoEnseignement.anneeOuiThemeOui(annee, theme, off);
            }
        } else if (combo.equals("anneeNonThemeNon")) {
            System.out.println("anneeNonThemeNon" + off);
            EnseignementList = this.daoEnseignement.anneeOuiThemeOuiToutesEtTous(off);
        }

        return (List)EnseignementList;
    }

    public List<Enseignement> lesEnseignements() {
        return this.daoEnseignement.lesEnseignements();
    }

    public Enseignement unEnseignement(int read) {
        return this.daoEnseignement.unEnseignement(read);
    }

    public void insertEnseignement(String titre, String nomphoto, String resume, String contenu) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        formatter.format(date);
        Enseignement enseignement = new Enseignement();
        enseignement.setTitre(titre);
        enseignement.setResume(resume);
        enseignement.setNomphoto(nomphoto);
        enseignement.setAnnee(date);
        enseignement.setContenu(contenu);
        this.daoEnseignement.save(enseignement);
    }

    public void updateEnseignement(Integer id, String titre, String nomphoto, String resume, String contenu) {
        Enseignement enseignement = this.daoEnseignement.findById(id);
        enseignement.setTitre(titre);
        enseignement.setResume(resume);
        enseignement.setNomphoto(nomphoto);
        enseignement.setContenu(contenu);
        this.daoEnseignement.save(enseignement);
    }
}
