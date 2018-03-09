package com.graceetfoi.gf.data;

import com.graceetfoi.gf.Bean.Video;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface DaoVideo extends CrudRepository<Video,String>{

@Query(value = "select id,titre,lien, DATE_FORMAT(annee,'%d-%m-%Y') as format,YEAR(annee) as annee, id_tab FROM video ORDER BY annee DESC", nativeQuery = true)
    List<Video> listeVideos();

    @Query(value = "SELECT DISTINCT YEAR(annee) FROM video ORDER BY annee DESC", nativeQuery = true)
    List<String> listeAnnees();


    @Query(value = "select id,titre,lien, DATE_FORMAT(annee,'%d-%m-%Y') as format,YEAR(annee) as annee, id_tab FROM video WHERE titre LIKE %:nom% ORDER BY annee DESC", nativeQuery = true)
List<Video> titreContient(@Param("nom") String nom);

}
