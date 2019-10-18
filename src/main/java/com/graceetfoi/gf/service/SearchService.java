//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.graceetfoi.gf.service;

import com.graceetfoi.gf.Bean.Audio;
import com.graceetfoi.gf.Bean.Enseignement;
import com.graceetfoi.gf.Bean.Louange;
import com.graceetfoi.gf.data.DaoAudio;
import com.graceetfoi.gf.data.DaoEnseignement;
import com.graceetfoi.gf.data.DaoLouange;
import com.graceetfoi.gf.data.DaoVideo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService {
    @Autowired
    private DaoVideo daoVideo;
    @Autowired
    private DaoLouange daoLouange;
    @Autowired
    private DaoAudio daoAudio;
    @Autowired
    private DaoEnseignement daoEnseignement;

    public SearchService() {
    }

    public List<Audio> listeRechercheAudio() {
        return this.daoAudio.findAll();
    }

    public List<Louange> listeRechercheLouange() {
        return this.daoLouange.findAll();
    }

    public List<Enseignement> listeRechercheEnseignement() {
        return this.daoEnseignement.lesEnseignements();
    }

    public List<Audio> SearchAudios(String titre) {
        return this.daoAudio.findByTitreContaining(titre);
    }

    public List<Louange> SearchLouanges(String nom) {
        return this.daoLouange.findByNomContaining(nom);
    }

    public List<Enseignement> SearchEnseignement(String nom) {
        return this.daoEnseignement.titreContient(nom);
    }
}
