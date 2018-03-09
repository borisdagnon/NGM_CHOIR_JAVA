package com.graceetfoi.gf.service;

import com.graceetfoi.gf.Bean.Video;
import com.graceetfoi.gf.data.DaoVideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {

    @Autowired
    private DaoVideo daoVideo;


    public List<Video> listeVideos(){
      return daoVideo.listeVideos();
}

    public List<String> listeAnnees(){
        return  daoVideo.listeAnnees();
    }

}
