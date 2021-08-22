package com.phinzin.demo.anime.service;

import com.phinzin.demo.anime.domain.Anime;
import com.phinzin.demo.exception.domain.AnimeServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AnimeService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    private List<Anime> allAnime;

    public AnimeService(){
        allAnime = new ArrayList<>();
        allAnime.add(new Anime(1,"Đấu Phá Thương Khung",new Date(),22,55,"hoạt hình kiếm hiệp","Sun"));
    }
    @Cacheable(value = "listAnimes")
    public List<Anime> getAnimes() {
        return this.allAnime;
    }

    public String addAnime(Anime anime) {
        try {
            anime.setId(this.allAnime.size()+1);
            this.allAnime.add(anime);
            return "{\"result\":\"success\"}";
        }catch (Exception e){
            logger.error("Retarus - RetarusSmsErrorException: {}", e.getMessage(), e);
        }
        throw new AnimeServiceException("anime.exception","Anime Service Error");
    }
}
