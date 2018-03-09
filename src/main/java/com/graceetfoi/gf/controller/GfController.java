package com.graceetfoi.gf.controller;



import com.google.gson.Gson;
import com.graceetfoi.gf.service.AudioService;
import com.graceetfoi.gf.service.ProductService;
import com.graceetfoi.gf.service.SearchService;
import com.graceetfoi.gf.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/")
public class GfController {

    @Autowired
    private VideoService videoService;
    @Autowired
    private AudioService audioService;
    @Autowired
    private ProductService productService;
    @Autowired
    private SearchService searchService;




    @RequestMapping(value = "")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "messages")
    public String messages(HashMap<Object,Object> model){
        model.put("listeVideos",videoService.listeVideos());
        model.put("listeAnnees",videoService.listeAnnees());
        model.put("titre","Messages");
        return "messages";
    }

    @RequestMapping(value = "temoignages")
    public String temoignages(HashMap<Object,Object> model){
        model.put("listeAudios",audioService.listeAudios());
        return "temoignages";
    }

    @RequestMapping(value = "louanges")
    public String louanges(HashMap<Object,Object> model){
model.put("listeLouanges",audioService.listeLouanges());

        return "louanges";
    }


    @PostMapping("ajax")
    public void ajax(HttpServletResponse response) throws IOException {

        Map<String,Object> map =new HashMap<>();

        map.put("listeRechercheVideo",searchService.listeRechercheVideos());
        map.put("listeRechercheAudio",searchService.listeRechercheAudio());
        map.put("listeRechercheLouange",searchService.listeRechercheLouange());

 write(response,map);

    }

    private void write(HttpServletResponse response, Map<String, Object> m) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter p= response.getWriter();
        p.write(new Gson().toJson(m));
    }


    @RequestMapping(value = "search")
    public String searchName(  HashMap<Object,Object> model, HttpServletRequest request) throws IOException {

   String name= ! request.getParameter("q").isEmpty()?request.getParameter("q"):"";

   model.put("Achercher",name);
        model.put("SearchAudios",searchService.SearchAudios(name));
        model.put("SearchVideos",searchService.SearchVideos(name));
        model.put("SearchLouanges",searchService.SearchLouanges(name));
        System.out.println(name);

return "search";
    }


}
