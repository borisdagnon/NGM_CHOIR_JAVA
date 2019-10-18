//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.graceetfoi.gf.controller;

import com.google.gson.Gson;
import com.graceetfoi.gf.service.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping({"/"})
public class GfController {
    @Autowired
    private VideoService videoService;
    @Autowired
    private AudioService audioService;
    @Autowired
    private SearchService searchService;
    @Autowired
    private EvenementService evenementService;
    @Autowired
    private ThemeService themeService;
    @Autowired
    private ProgrammeService programmeService;
    @Autowired
    private EnseignementService enseignementService;



    public GfController() {
    }


    @RequestMapping({""})
    public String index(HashMap<Object, Object> model) {
        model.put("titre", "Centre de Grâce et Foi | église annoncant l'evangile, est une assemblée angers");
        return "index";
    }

    @RequestMapping({"programmes"})
    public String programmes(HashMap<Object, Object> model, HttpServletRequest request) {
        model.put("listeProgrammes", this.programmeService.listeProgrammes());
        model.put("titre", "Centre de Grâce et Foi | Programmes");
        return "programmes";
    }

    @RequestMapping({"mandat"})
    public String mandat(HashMap<Object, Object> model, HttpServletRequest request) {
        model.put("titre", "Centre de Grâce et Foi | Mandat");
        return "mandat";
    }

    @RequestMapping({"contact"})
    public String contact(){
        return "contact";
    }

    @RequestMapping({"des_le_commencement"})
    public String des_le_commencement(HashMap<Object, Object> model, HttpServletRequest request) {
        model.put("lesEnseignements", this.enseignementService.lesEnseignements());
        model.put("titre", "Centre de Grâce et Foi | Dès le Commancement");
        return "des_le_commencement";
    }

    @RequestMapping({"des_le_commencement/article/{id}"})
    public String des_le_commencement_article(@PathVariable("id") int id, HashMap<Object, Object> model, HttpServletRequest request) {
        model.put("unEnseignement", this.enseignementService.unEnseignement(id));
        model.put("titre", "Centre de Grâce et Foi | Dès le Commancement - Article");
        return "des_le_commencement_article";
    }

    @RequestMapping({"media_de_siloe"})
    public String media_de_siloe(HashMap<Object, Object> model, HttpServletRequest request) {
        model.put("listeVideos", this.videoService.listeVideoAvecSonAudio());
        model.put("videoLaPlusRecente", this.videoService.videoLaPlusRecente());
        model.put("titre", "Centre de Grâce et Foi | Média de Siloé");
        return "media_de_siloe";
    }

    @RequestMapping({"callVideo"})
    public void callVideo(HttpServletResponse response, HashMap<String, Object> model, HttpServletRequest request) throws IOException {
        int identifiant = Integer.parseInt(request.getParameter("identifiant"));
        model.put("uneVideo", this.videoService.uneVideo(identifiant));
        this.write(response, model);
    }

    @RequestMapping({"callAudio"})
    public void callAudio(HttpServletResponse response, HashMap<String, Object> model, HttpServletRequest request) throws IOException {
        int identifiant = Integer.parseInt(request.getParameter("identifiant"));
        model.put("unAudio", this.audioService.unAudio(identifiant));
        this.write(response, model);
    }

    @RequestMapping({"redacteur"})
    public String read(HashMap<Object, Object> model, HttpServletRequest request) {
        return "redacteur";
    }

    @RequestMapping({"modifier/{id}"})
    public String modifier(@PathVariable("id") int id, HashMap<Object, Object> model) {
        model.put("unEnseignement", this.enseignementService.unEnseignement(id));
        return "modifier";
    }

    @PostMapping({"enregistrer_article"})
    public void enregistrer_article(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Map<String, Object> model = new HashMap();
        String titre = request.getParameter("titre_article");
        String nomphoto = request.getParameter("nomphoto");
        String resume = request.getParameter("resume");
        String contenu = request.getParameter("contenu");
        if (request.getParameter("action").equals("insert")) {
            this.enseignementService.insertEnseignement(titre, nomphoto, resume, contenu);
        } else {
            int id = Integer.parseInt(request.getParameter("id"));
            this.enseignementService.updateEnseignement(id, titre, nomphoto, resume, contenu);
        }

        this.write(response, model);
    }

    @RequestMapping({"temoignages"})
    public String temoignages(HashMap<Object, Object> model) {
        model.put("listeAudios", this.audioService.listeAudios());
        model.put("titre", "Centre de Grâce et Foi | Témoignages");
        return "temoignages";
    }

    @RequestMapping({"reccueil_chants"})
    public String reccueil_chants(HashMap<Object, Object> model, HttpServletRequest request) {
        String page = request.getParameter("page");
        int result = 0;

        try {
             result = Integer.parseInt(page);
            model.put("listeLouanges", this.audioService.listeLouanges(result));
            model.put("nombreLouange", this.audioService.nombreLouange());
        } catch (Exception var6) {
            System.out.println(var6.getMessage());
            model.put("listeLouanges", this.audioService.listeLouanges(result));
            model.put("nombreLouange", this.audioService.nombreLouange());
            model.put("titre", "Louanges");
            return "reccueil_chants";
        }

        model.put("titre", "Centre de Grâce et Foi | Louanges");
        return "reccueil_chants";
    }

    @PostMapping({"ajax"})
    public void ajax(HttpServletResponse response) throws IOException {
        Map<String, Object> map = new HashMap();
        map.put("listeRechercheAudio", this.searchService.listeRechercheAudio());
        map.put("listeRechercheEnseignement", this.searchService.listeRechercheAudio());
        map.put("listeRechercheLouange", this.searchService.listeRechercheLouange());
        this.write(response, map);
    }

    @PostMapping({"refreshPagination"})
    public void refreshPagination(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Map<String, Object> model = new HashMap();
        String combo = request.getParameter("combo");
        String annee = request.getParameter("annee");
        String theme = request.getParameter("theme");
        int off = Integer.parseInt(request.getParameter("off"));
        model.put("listeEnseignements", this.enseignementService.dispatch(combo, annee, theme, off));
        model.put("nombreEnseignement", this.enseignementService.nombreEnseignement(combo, annee, theme));
        this.write(response, model);
    }

    @PostMapping({"pagination_ajax"})
    public void pagination_ajax(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Map<String, Object> model = new HashMap();
        int page = Integer.parseInt(request.getParameter("page"));
        String combo = request.getParameter("combo");
        String annee = request.getParameter("annee");
        String theme = request.getParameter("theme");
        model.put("listeEnseignements", this.enseignementService.dispatch(combo, annee, theme, page));
        this.write(response, model);
    }

    @PostMapping({"louanges_pdf"})
    public void louanges_pdf(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Map<String, Object> model = new HashMap();
        String id = request.getParameter("id");
        model.put("pdf", this.audioService.pdf(id));
        this.write(response, model);
    }

    private void write(HttpServletResponse response, Map<String, Object> m) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter p = response.getWriter();
        p.write((new Gson()).toJson(m));
    }

    @RequestMapping({"search"})
    public String searchName(HashMap<Object, Object> model, HttpServletRequest request) throws IOException {
        String name = !request.getParameter("q").isEmpty() ? request.getParameter("q") : "";
        model.put("Achercher", name);
        model.put("SearchAudios", this.searchService.SearchAudios(name));
        model.put("SearchLouanges", this.searchService.SearchLouanges(name));
        System.out.println(name);
        model.put("titre", "Recherches");
        return "search";
    }

    @RequestMapping({"connexion"})
    public String connexion(HashMap<Object, Object> model, String error, String logout) {
        if (error != null) {
            model.put("errorMsg", "Your username and password are invalid.");
        }

        if (logout != null) {
            model.put("msg", "You have been logged out successfully.");
        }

        return "connexion";
    }

    @RequestMapping({"logout"})
    public String adminLogout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            (new SecurityContextLogoutHandler()).logout(request, response, auth);
        }

        return "redirect:/index";
    }

    @RequestMapping(
            value = {"/uploadFileAjax"},
            method = {RequestMethod.POST}
    )
    @ResponseBody
    public ResponseEntity<?> uploadFile(@RequestParam("uploadfile") MultipartFile uploadfile) {
        try {
            String filename = uploadfile.getOriginalFilename();
            String directory = "..\\gf\\src\\main\\webapp\\resources\\image\\des_le_commencement\\";
            String filepath = Paths.get(directory, filename).toString();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
            stream.write(uploadfile.getBytes());
            stream.close();
        } catch (Exception var6) {
            System.out.println(var6.getMessage());
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping({"deconnexion"})
    public String deconnexion(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "index";
    }


@RequestMapping(value = {"sitemap","sitemap.xml"},produces=MediaType.APPLICATION_XML_VALUE)
@ResponseBody
  public String sitemap() throws IOException {
    File file = ResourceUtils.getFile("classpath:static/sitemap.xml");

//Read File Content
    String content = new String(Files.readAllBytes(file.toPath()));
    //System.out.println(content);
    return content;
  }

    @RequestMapping(value = {"robots.txt","robot.txt"})
    @ResponseBody
    public String robots(HttpServletRequest request, HttpServletResponse response) throws IOException {
        File file = ResourceUtils.getFile("classpath:static/robots.txt");

//Read File Content
        String content = new String(Files.readAllBytes(file.toPath()));
        //System.out.println(content);
        return content;
    }

    @RequestMapping(value = {".well-known/pki-validation/"})
    @ResponseBody
    public String ssl(HttpServletRequest request, HttpServletResponse response) throws IOException {
        File file = ResourceUtils.getFile("classpath:static/1CFFDCEDB250CB0FF26008150071CFC0.txt");

//Read File Content
        String content = new String(Files.readAllBytes(file.toPath()));
        //System.out.println(content);
        return content;
    }






}
