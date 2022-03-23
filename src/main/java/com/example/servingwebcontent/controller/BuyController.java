package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.DTO.FilmDTO;
import com.example.servingwebcontent.DTO.MusicDTO;
import com.example.servingwebcontent.domain.Film;
import com.example.servingwebcontent.domain.Music;
import com.example.servingwebcontent.domain.User;
import com.example.servingwebcontent.service.BuyService;
import com.example.servingwebcontent.service.FilmService;
import com.example.servingwebcontent.service.MusicService;
import com.example.servingwebcontent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BuyController {

    @Autowired
    BuyService buyService;

    @Autowired
    MusicService musicService;

    @Autowired
    FilmService filmService;

    @Autowired
    UserService userService;

    @GetMapping("/buy/film")
    public String buyFilm(FilmDTO filmDTO, @RequestParam Long idUser, Model model, boolean bonus) {
        model.addAttribute("musics", musicService.find(null));
        model.addAttribute("films", filmService.find(null));
        User user = userService.findById(idUser);
        Film film = filmService.findById(filmDTO.getId());
        if (bonus) {
            if (user.getBalance().getBonuses()-film.getPrice() < 0) {
                model.addAttribute("noBonusMessage", true);
                return "home";
            } else {
                buyService.watchFilm(film, user, true);
            }
        } else {
            if (user.getMoney() < film.getPrice()) {
                model.addAttribute("noMoneyMessage", true);
                return "home";
            } else {
                buyService.watchFilm(film, user, false);
            }
        }
        return "redirect:/";
    }

    @GetMapping("/buy/music")
    public String buyMusic(MusicDTO musicDTO, @RequestParam Long idUser, Model model, boolean bonus) {
        model.addAttribute("musics", musicService.find(null));
        model.addAttribute("films", filmService.find(null));
        Music music = musicService.findById(musicDTO.getId());
        User user = userService.findById(idUser);
        if (bonus) {
            if (user.getBalance().getBonuses()-music.getPrice() < 0) {
                model.addAttribute("noBonusMessage", true);
                return "home";
            } else {
                buyService.listenToMusic(music, user, true);
            }
        } else {
            if (user.getMoney() < music.getPrice()) {
                model.addAttribute("noMoneyMessage", true);
                return "home";
            } else {
                buyService.listenToMusic(music, user, false);
            }
        }
        return "redirect:/";
    }
}
