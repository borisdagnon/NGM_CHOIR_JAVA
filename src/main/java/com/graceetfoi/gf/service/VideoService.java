//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.graceetfoi.gf.service;

import com.graceetfoi.gf.Bean.Video;
import com.graceetfoi.gf.data.DaoVideo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {
    @Autowired
    private DaoVideo daoVideo;

    public VideoService() {
    }

    public Video uneVideo(int identifiant) {
        return this.daoVideo.callVideo(identifiant);
    }

    public List<Video> listeVideoAvecSonAudio() {
        return this.daoVideo.listeVideoAvecSonAudio();
    }

    public Video videoLaPlusRecente() {
        return this.daoVideo.videoLaPlusRecente();
    }
}
