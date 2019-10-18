//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.graceetfoi.gf.data;

import com.graceetfoi.gf.Bean.Evenement;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoEvenement extends CrudRepository<Evenement, Integer> {
    @Query(
            value = "SELECT * FROM evenement ORDER BY id DESC",
            nativeQuery = true
    )
    List<Evenement> findAll();
}
