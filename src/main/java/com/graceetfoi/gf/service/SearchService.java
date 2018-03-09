package com.graceetfoi.gf.service;

import com.graceetfoi.gf.Bean.Audio;
import com.graceetfoi.gf.Bean.Louange;
import com.graceetfoi.gf.Bean.Video;
import com.graceetfoi.gf.data.DaoAudio;
import com.graceetfoi.gf.data.DaoLouange;
import com.graceetfoi.gf.data.DaoVideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    private DaoVideo daoVideo;
    @Autowired
    DaoLouange daoLouange;
    @Autowired
    DaoAudio daoAudio;

    public List<Video> listeRechercheVideos() {

        return daoVideo.listeVideos();
    }

    public List<Audio> listeRechercheAudio() {

        return daoAudio.findAll();
    }

    public List<Louange> listeRechercheLouange() {

        return daoLouange.findAll();
    }

    public List<Audio> SearchAudios(String nom){

        return daoAudio.findByNomContaining(nom);
    }

    public List<Video> SearchVideos(String nom){

        return daoVideo.titreContient(nom);
    }

    public List<Louange> SearchLouanges(String nom){

        return daoLouange.findByNomContaining(nom);
    }


}
