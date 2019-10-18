//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.graceetfoi.gf.service;

import com.graceetfoi.gf.Bean.Audio;
import com.graceetfoi.gf.Bean.Louange;
import com.graceetfoi.gf.data.DaoAudio;
import com.graceetfoi.gf.data.DaoLouange;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AudioService {
    @Autowired
    private DaoAudio daoAudio;
    @Autowired
    private DaoLouange daoLouange;

    public AudioService() {
    }

    public List<Audio> listeAudios() {
        return this.daoAudio.findAll();
    }

    public int nombreLouange() {
        return this.daoLouange.nombreLouange();
    }

    public List<Louange> listeLouanges(int off) {
        off = 4 * (off - 1) < 0 ? 0 : 4 * (off - 1);
        return this.daoLouange.findAll(off);
    }

    public List<Louange> pdf(String id) {
        int identifiant = Integer.parseInt(id);
        return this.daoLouange.pdf(identifiant);
    }

    public Audio unAudio(int identifiant) {
        return this.daoAudio.callAudio(identifiant);
    }
}
