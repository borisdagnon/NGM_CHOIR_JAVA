//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.graceetfoi.gf.data;

import com.graceetfoi.gf.Bean.Programme;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoProgramme extends CrudRepository<Programme, Integer> {
    @Query(
            value = "SELECT id,titre,nomphoto,resume,contenu,jour FROM programme",
            nativeQuery = true
    )
    List<Programme> listeProgrammes();
}
