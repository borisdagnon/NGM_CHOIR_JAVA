//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.graceetfoi.gf.data;

import com.graceetfoi.gf.Bean.Audio;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoAudio extends CrudRepository<Audio, Integer> {
    List<Audio> findAll();

    List<Audio> findByTitreContaining(String var1);

    @Query(
            value = "SELECT id,titre,lien,annee FROM audio a INNER JOIN video_audio v on a.id = v.audio_id WHERE v.video_id=:identifiant",
            nativeQuery = true
    )
    Audio callAudio(@Param("identifiant") int var1);
}
