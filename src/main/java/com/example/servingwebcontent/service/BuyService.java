package com.example.servingwebcontent.service;

import com.example.servingwebcontent.domain.Film;
import com.example.servingwebcontent.domain.Music;
import com.example.servingwebcontent.domain.User;
import com.example.servingwebcontent.repos.FilmRepo;
import com.example.servingwebcontent.repos.MusicRepo;
import com.example.servingwebcontent.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyService {
    @Autowired
    FilmRepo filmRepo;

    @Autowired
    MusicRepo musicRepo;

    @Autowired
    UserRepo userRepo;

    public Film watchFilm(Film film, User user, boolean useBonus) {
        film.setRating(String.valueOf(film.getRating()+1));
        if (useBonus) {
            if (user.getBalance().getBonuses() > film.getPrice()) {
                user.getBalance().setBonuses(user.getBalance().getBonuses() - film.getPrice() + 1);
            } else {
                user.setMoney(user.getMoney() - film.getPrice() + user.getBalance().getBonuses());
                user.getBalance().setBonuses(1);
            }
        } else {
            user.setMoney(user.getMoney() - film.getPrice());
            user.getBalance().setBonuses(user.getBalance().getBonuses() + 1);
        }
        userRepo.save(user);
        filmRepo.save(film);
        return film;
    }

    public Music listenToMusic(Music music, User user, boolean useBonus) {
        music.setRating(String.valueOf(music.getRating()+1));

        if (useBonus) {
            if (user.getBalance().getBonuses() > music.getPrice()) {
                user.getBalance().setBonuses(user.getBalance().getBonuses() - music.getPrice() + 1);
            } else {
                user.setMoney(user.getMoney() - music.getPrice() + user.getBalance().getBonuses());
                user.getBalance().setBonuses(1);
            }
        } else {
            user.setMoney(user.getMoney() - music.getPrice());
            user.getBalance().setBonuses(user.getBalance().getBonuses() + 1);
        }
        userRepo.save(user);
        musicRepo.save(music);
        return music;
    }
}
