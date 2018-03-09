package com.graceetfoi.gf.data;

import com.graceetfoi.gf.Bean.Audio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DaoAudio extends CrudRepository<Audio,Integer> {

    List<Audio> findAll();

    List<Audio> findByNomContaining(String nom);

}

