package com.phinzin.demo.anime.web;

import com.phinzin.demo.anime.domain.Anime;
import com.phinzin.demo.anime.service.AnimeService;
import com.phinzin.demo.exception.domain.AnimeServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/anime")
public class AnimeController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AnimeService service;

    @GetMapping("/get-all")
    public List<Anime> getAnimes(){
        logger.info("get all animes");
        return service.getAnimes();
    }
    @PostMapping("/add")
    public String addAnime(@RequestBody Anime anime){
        logger.info("add new anime [{}]",anime);
        return service.addAnime(anime);
    }
}
