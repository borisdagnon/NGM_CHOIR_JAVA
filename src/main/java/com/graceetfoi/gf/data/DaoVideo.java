//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.graceetfoi.gf.data;

import com.graceetfoi.gf.Bean.Video;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoVideo extends CrudRepository<Video, Integer> {
    @Query(
            value = "SELECT v.id,titre,lien, DATE_FORMAT(annee,'%d-%m-%Y') AS formatdate,YEAR(annee) AS an FROM video v INNER JOIN video_theme vt ON vt.id_video=v.id INNER JOIN theme t ON t.id=vt.id_theme  ORDER BY annee DESC LIMIT 9 OFFSET :off",
            nativeQuery = true
    )
    List<Video> anneeNonThemeOuiTous(@Param("off") int var1);

    @Query(
            value = "SELECT v.id,titre,lien, DATE_FORMAT(annee,'%d-%m-%Y') AS formatdate,YEAR(annee) AS an FROM video v INNER JOIN video_theme vt ON vt.id_video=v.id INNER JOIN theme t ON t.id=vt.id_theme WHERE nom=:theme  ORDER BY annee DESC LIMIT 9 OFFSET :off",
            nativeQuery = true
    )
    List<Video> anneeNonThemeOui(@Param("theme") String var1, @Param("off") int var2);

    @Query(
            value = "SELECT id,titre,lien,DATE_FORMAT(annee,'%d-%m-%Y') AS formatdate,YEAR(annee) AS an FROM video  ORDER BY annee DESC LIMIT 9 OFFSET :off",
            nativeQuery = true
    )
    List<Video> anneeOuiThemeNonToutes(@Param("off") int var1);

    @Query(
            value = "SELECT id,titre,lien, DATE_FORMAT(annee,'%d-%m-%Y') AS formatdate,YEAR(annee) AS an FROM video  WHERE YEAR(annee)=:annee ORDER BY annee DESC LIMIT 9 OFFSET :off",
            nativeQuery = true
    )
    List<Video> anneeOuiThemeNon(@Param("annee") String var1, @Param("off") int var2);

    @Query(
            value = "SELECT v.id,titre,lien, DATE_FORMAT(annee,'%d-%m-%Y') AS formatdate,YEAR(annee) AS an FROM video v INNER JOIN video_theme vt ON vt.id_video=v.id INNER JOIN theme t ON t.id=vt.id_theme  ORDER BY annee DESC LIMIT 9 OFFSET :off",
            nativeQuery = true
    )
    List<Video> anneeOuiThemeOuiToutesEtTous(@Param("off") int var1);

    @Query(
            value = "SELECT v.id,titre,lien, DATE_FORMAT(annee,'%d-%m-%Y') AS formatdate,YEAR(annee) AS an FROM video v INNER JOIN video_theme vt ON vt.id_video=v.id INNER JOIN theme t ON t.id=vt.id_theme WHERE YEAR(annee)=:annee AND t.nom=:theme ORDER BY annee DESC LIMIT 9 OFFSET :off",
            nativeQuery = true
    )
    List<Video> anneeOuiThemeOui(@Param("annee") String var1, @Param("theme") String var2, @Param("off") int var3);

    @Query(
            value = "SELECT id,titre,lien, DATE_FORMAT(annee,'%d-%m-%Y') AS formatdate,YEAR(annee) AS an FROM video  ORDER BY annee DESC",
            nativeQuery = true
    )
    List<Video> listeVideos();

    @Query(
            value = "SELECT COUNT(id) FROM video",
            nativeQuery = true
    )
    int nombreVideo();

    @Query(
            value = "SELECT COUNT(id) FROM video WHERE YEAR(annee)=:annee",
            nativeQuery = true
    )
    int nombreVideoParAnnee(@Param("annee") String var1);

    @Query(
            value = "SELECT COUNT(v.id) FROM video v INNER JOIN video_theme vt ON vt.id_video=v.id INNER JOIN theme t ON t.id=vt.id_theme WHERE nom=:theme",
            nativeQuery = true
    )
    int nombreVideoParTheme(@Param("theme") String var1);

    @Query(
            value = "SELECT COUNT(v.id) FROM video v INNER JOIN video_theme vt ON vt.id_video=v.id INNER JOIN theme t ON t.id=vt.id_theme WHERE nom=:theme AND YEAR(annee)=:annee",
            nativeQuery = true
    )
    int nombreVideoParAnneeEtTheme(@Param("annee") String var1, @Param("theme") String var2);

    @Query(
            value = "SELECT COUNT(v.id) FROM video v INNER JOIN video_theme vt ON vt.id_video=v.id INNER JOIN theme t ON t.id=vt.id_theme",
            nativeQuery = true
    )
    int nombreVideoParThemeTous();

    @Query(
            value = "SELECT YEAR(annee) FROM video GROUP BY YEAR(annee)",
            nativeQuery = true
    )
    List<String> listeAnnees();

    @Query(
            value = "SELECT id,titre,lien, DATE_FORMAT(annee,'%d-%m-%Y') AS formatdate,YEAR(annee) AS an FROM video WHERE titre LIKE %:nom% ORDER BY annee DESC",
            nativeQuery = true
    )
    List<Video> titreContient(@Param("nom") String var1);

    @Query(
            value = "SELECT v.id,v.titre,v.lien, DATE_FORMAT(annee,'%d-%m-%Y') AS formatdate,YEAR(annee) AS an, aka, orateur_id FROM video v INNER JOIN video_orateur vo ON vo.video_id=v.id INNER JOIN orateur o ON o.id=vo.orateur_id  WHERE v.id=:identifiant",
            nativeQuery = true
    )
    Video callVideo(@Param("identifiant") int var1);

    @Query(
            value = "SELECT v.id,v.titre,v.lien,DATE_FORMAT(v.annee,'%d-%m-%Y') as formatdate,orateur_id,YEAR(v.annee) AS an,a.audio_id as idaudio,aka,appele FROM video v LEFT JOIN video_audio a on v.id = a.video_id LEFT JOIN video_orateur vo ON vo.video_id=v.id LEFT JOIN orateur o ON o.id=vo.orateur_id ORDER BY v.annee DESC",
            nativeQuery = true
    )
    List<Video> listeVideoAvecSonAudio();

    @Query(
            value = "SELECT v.id,v.titre,v.lien, DATE_FORMAT(annee,'%d-%m-%Y') AS formatdate,YEAR(annee) AS an, aka, orateur_id FROM video v INNER JOIN video_orateur vo ON vo.video_id=v.id INNER JOIN orateur o ON o.id=vo.orateur_id  WHERE annee=(SELECT annee FROM video ORDER BY annee DESC LIMIT 1 OFFSET 0)",
            nativeQuery = true
    )
    Video videoLaPlusRecente();
}
