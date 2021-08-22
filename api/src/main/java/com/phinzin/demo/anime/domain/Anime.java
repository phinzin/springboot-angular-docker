package com.phinzin.demo.anime.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Anime {
    private long id;
    private String name;
    private Date date;
    private int currentEpisode;
    private int lastEpisode;
    private String description;
    private String schedule;
//
//    public Anime(long id, String name, Date date, int currentEpisode, int lastEpisode, String description, String schedule) {
//        this.id = id;
//        this.name = name;
//        this.date = date;
//        this.currentEpisode = currentEpisode;
//        this.lastEpisode = lastEpisode;
//        this.description = description;
//        this.schedule = schedule;
//    }
//    public Anime(Anime anime){
//        this.id = anime.id;
//        this.name = anime.name;
//        this.date = anime.date;
//        this.currentEpisode = anime.currentEpisode;
//        this.lastEpisode = anime.lastEpisode;
//        this.description = anime.description;
//        this.schedule = anime.schedule;
//    }
//
//    public Anime(String name, Date date, int currentEpisode, int lastEpisode, String description, String schedule) {
//        this.name = name;
//        this.date = date;
//        this.currentEpisode = currentEpisode;
//        this.lastEpisode = lastEpisode;
//        this.description = description;
//        this.schedule = schedule;
//    }
}
