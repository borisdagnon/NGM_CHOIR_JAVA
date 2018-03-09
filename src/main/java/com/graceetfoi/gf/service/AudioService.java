package com.graceetfoi.gf.service;

import com.graceetfoi.gf.Bean.Audio;
import com.graceetfoi.gf.Bean.Louange;
import com.graceetfoi.gf.data.DaoAudio;
import com.graceetfoi.gf.data.DaoLouange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AudioService {

    @Autowired
    private DaoAudio daoAudio;

    @Autowired
    private DaoLouange daoLouange;

    public List<Audio> listeAudios(){
        return  daoAudio.findAll();
    }

    public List<Louange> listeLouanges(){
        return daoLouange.findAll();
    }

}
