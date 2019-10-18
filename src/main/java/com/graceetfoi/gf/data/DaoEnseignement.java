//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.graceetfoi.gf.data;

import com.graceetfoi.gf.Bean.Enseignement;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DaoEnseignement extends CrudRepository<Enseignement, Integer> {
    @Query(
            value = "SELECT e.id,titre,nomphoto,resume,contenu, DATE_FORMAT(annee,'%d-%m-%Y') AS formatdate,YEAR(annee) AS an FROM enseignement e INNER JOIN enseignement_theme et ON et.id_enseignement=e.id INNER JOIN theme t ON t.id=et.id_theme  ORDER BY annee DESC LIMIT 9 OFFSET :off",
            nativeQuery = true
    )
    List<Enseignement> anneeNonThemeOuiTous(@Param("off") int var1);

    @Query(
            value = "SELECT e.id,titre,nomphoto,resume,contenu, DATE_FORMAT(annee,'%d-%m-%Y') AS formatdate,YEAR(annee) AS an FROM enseignement e INNER JOIN enseignement_theme et ON et.id_enseignement=e.id INNER JOIN theme t ON t.id=et.id_theme  WHERE nom=:theme  ORDER BY annee DESC LIMIT 9 OFFSET :off",
            nativeQuery = true
    )
    List<Enseignement> anneeNonThemeOui(@Param("theme") String var1, @Param("off") int var2);

    @Query(
            value = "SELECT e.id,titre,nomphoto,resume,contenu, DATE_FORMAT(annee,'%d-%m-%Y') AS formatdate,YEAR(annee) AS an FROM enseignement e  ORDER BY annee DESC LIMIT 9 OFFSET :off",
            nativeQuery = true
    )
    List<Enseignement> anneeOuiThemeNonToutes(@Param("off") int var1);

    @Query(
            value = "SELECT e.id,titre,nomphoto,resume,contenu, DATE_FORMAT(annee,'%d-%m-%Y') AS formatdate,YEAR(annee) AS an FROM enseignement e  WHERE YEAR(annee)=:annee ORDER BY annee DESC LIMIT 9 OFFSET :off",
            nativeQuery = true
    )
    List<Enseignement> anneeOuiThemeNon(@Param("annee") String var1, @Param("off") int var2);

    @Query(
            value = "SELECT e.id,titre,nomphoto,resume,contenu, DATE_FORMAT(annee,'%d-%m-%Y') AS formatdate,YEAR(annee) AS an FROM enseignement e INNER JOIN enseignement_theme et ON et.id_enseignement=e.id INNER JOIN theme t ON t.id=et.id_theme  ORDER BY annee DESC LIMIT 9 OFFSET :off",
            nativeQuery = true
    )
    List<Enseignement> anneeOuiThemeOuiToutesEtTous(@Param("off") int var1);

    @Query(
            value = "SELECT e.id,titre,nomphoto,resume,contenu, DATE_FORMAT(annee,'%d-%m-%Y') AS formatdate,YEAR(annee) AS an FROM enseignement e INNER JOIN enseignement_theme et ON et.id_enseignement=e.id INNER JOIN theme t ON t.id=et.id_theme WHERE YEAR(annee)=:annee AND t.nom=:theme ORDER BY annee DESC LIMIT 9 OFFSET :off",
            nativeQuery = true
    )
    List<Enseignement> anneeOuiThemeOui(@Param("annee") String var1, @Param("theme") String var2, @Param("off") int var3);

    @Query(
            value = "SELECT COUNT(id) FROM enseignement",
            nativeQuery = true
    )
    int nombreEnseignement();

    @Query(
            value = "SELECT COUNT(id) FROM enseignement WHERE YEAR(annee)=:annee",
            nativeQuery = true
    )
    int nombreEnseignementParAnnee(@Param("annee") String var1);

    @Query(
            value = "SELECT COUNT(e.id) FROM enseignement e INNER JOIN enseignement_theme et ON et.id_enseignement=e.id INNER JOIN theme t ON t.id=et.id_theme WHERE nom=:theme",
            nativeQuery = true
    )
    int nombreEnseignementParTheme(@Param("theme") String var1);

    @Query(
            value = "SELECT COUNT(e.id) FROM enseignement e INNER JOIN enseignement_theme et ON et.id_enseignement=e.id INNER JOIN theme t ON t.id=et.id_theme WHERE nom=:theme AND YEAR(annee)=:annee",
            nativeQuery = true
    )
    int nombreEnseignementParAnneeEtTheme(@Param("annee") String var1, @Param("theme") String var2);

    @Query(
            value = "SELECT COUNT(e.id) FROM enseignement e INNER JOIN enseignement_theme et ON et.id_enseignement=e.id INNER JOIN theme t ON t.id=et.id_theme",
            nativeQuery = true
    )
    int nombreEnseignementParThemeTous();

    @Query(
            value = "SELECT YEAR(annee) FROM enseignement GROUP BY YEAR(annee)",
            nativeQuery = true
    )
    List<String> listeAnnees();

    @Query(
            value = "SELECT id,titre,nomphoto,resume,contenu, DATE_FORMAT(annee,'%d-%m-%Y') AS formatdate,YEAR(annee) AS an FROM enseignement e WHERE titre LIKE %:nom% ORDER BY annee DESC",
            nativeQuery = true
    )
    List<Enseignement> titreContient(@Param("nom") String var1);

    @Query(
            value = "SELECT id,titre,nomphoto,resume,contenu, annee,lienaudio,DATE_FORMAT(annee,'%d-%m-%Y') AS formatdate,YEAR(annee) AS an FROM enseignement e ORDER BY annee DESC",
            nativeQuery = true
    )
    List<Enseignement> lesEnseignements();

    @Query(
            value = "SELECT id,titre,nomphoto,resume,contenu,annee,lienaudio,DATE_FORMAT(annee,'%d-%m-%Y') AS formatdate,YEAR(annee) AS an FROM enseignement WHERE id=:read",
            nativeQuery = true
    )
    Enseignement unEnseignement(@Param("read") int var1);

    Enseignement save(Enseignement var1);

    Enseignement findById(int var1);
}
