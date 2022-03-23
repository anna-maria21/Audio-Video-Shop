package com.example.servingwebcontent.service;

import com.example.servingwebcontent.DTO.FilmDTO;
import com.example.servingwebcontent.DTO.MusicDTO;
import com.example.servingwebcontent.domain.Film;
import com.example.servingwebcontent.domain.Music;
import com.example.servingwebcontent.domain.MusicCategory;
import com.example.servingwebcontent.domain.Type;
import com.example.servingwebcontent.repos.MusicCategoryRepo;
import com.example.servingwebcontent.repos.MusicRepo;
import com.example.servingwebcontent.repos.TypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicService {

    @Autowired
    MusicRepo musicRepo;

    @Autowired
    MusicCategoryRepo musicCategoryRepo;

    @Autowired
    TypeRepo typeRepo;

    public Iterable<Music> find(String filter) {
        Iterable<Music> musics;

        if (filter != null && !filter.isEmpty()) {
            musics = musicRepo.findByName(filter);
        } else {
            musics = musicRepo.findAll();
        }

        return musics;
    }

    public Music findById(Long id) {
        return musicRepo.findById(id).get();
    }

    public Iterable<Music> findAll() {
        return musicRepo.findAll();
    }

    public Iterable<MusicCategory> getCategories() {
        return musicCategoryRepo.findAll();
    }

    public Iterable<Type> getTypes() {
        return typeRepo.findAll();
    }

    public boolean isUnique(MusicDTO musicDTO) {
        Music music = musicRepo.findByNameAndPerformer(musicDTO.getName(), musicDTO.getPerformer());
        return music == null || !music.getId().equals(musicDTO.getId());
    }

    public Music save(MusicDTO musicDTO) {
        return musicRepo.save(new Music(musicDTO.getName(), musicDTO.getPerformer(), String.valueOf(musicDTO.getYear()),
                musicDTO.getRating(), musicDTO.getPrice(),
                musicCategoryRepo.findById(musicDTO.getIdMusicCategory()).get(),
                typeRepo.findById(musicDTO.getIdType()).get(), musicDTO.getUser()));
    }

    public void delete(Long id) {
        musicRepo.deleteById(id);
    }

    public Music edit(MusicDTO musicDTO) {

        Music music = findById(musicDTO.getId());
        music.setName(musicDTO.getName());
        music.setPerformer(musicDTO.getPerformer());
        music.setYear(String.valueOf(musicDTO.getYear()));
        music.setRating(musicDTO.getRating());
        music.setPrice(musicDTO.getPrice());
        music.setMusicCategory(musicCategoryRepo.findById(musicDTO.getIdMusicCategory()).get());
        music.setType(typeRepo.findById(musicDTO.getIdType()).get());
        musicRepo.save(music);

        return music;
    }

    public Music findExists(MusicDTO musicDTO) {
        return musicRepo.findByNameAndPerformer(musicDTO.getName(), musicDTO.getPerformer());
    }
}
