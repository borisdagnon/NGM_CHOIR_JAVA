//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.graceetfoi.gf.data;

import com.graceetfoi.gf.Bean.Louange;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoLouange extends CrudRepository<Louange, Integer> {
    @Query(
            value = "SELECT * FROM louange LIMIT 4 OFFSET :off",
            nativeQuery = true
    )
    List<Louange> findAll(@Param("off") int var1);

    List<Louange> findAll();

    @Query(
            value = "SELECT COUNT(id) FROM louange ",
            nativeQuery = true
    )
    int nombreLouange();

    List<Louange> findByNomContaining(String var1);

    @Query(
            value = "SELECT * FROM louange WHERE id=:idLouange",
            nativeQuery = true
    )
    List<Louange> pdf(@Param("idLouange") int var1);
}
