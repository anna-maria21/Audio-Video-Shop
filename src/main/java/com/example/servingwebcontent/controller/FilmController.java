package com.example.servingwebcontent.controller;


import com.example.servingwebcontent.DTO.FilmDTO;
import com.example.servingwebcontent.DTO.MusicDTO;
import com.example.servingwebcontent.domain.Film;
import com.example.servingwebcontent.domain.Music;
import com.example.servingwebcontent.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.stream.StreamSupport;

@Controller
public class FilmController {

    @Autowired
    FilmService filmService;

    @GetMapping("/films")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {

        Iterable<Film> films = filmService.find(filter);
        if (StreamSupport.stream(films.spliterator(), false).count() == 0) {
            model.addAttribute("emptyMessage", true);
        }

        model.addAttribute("films", films)
                .addAttribute("filter", filter)
                .addAttribute("categories", filmService.getCategories())
                .addAttribute("types", filmService.getTypes());
        return "films";
    }


    @PostMapping("/films")
    public String add(FilmDTO filmDTO, @RequestParam(value = "id", required = false) Music music, Model model) {
            if (filmService.isUnique(filmDTO)) {
                filmService.save(filmDTO);
                return "redirect:/films";
            } else {
                model.addAttribute("message", true)
                        .addAttribute("categories", filmService.getCategories())
                        .addAttribute("films", filmService.findAll())
                        .addAttribute("types", filmService.getTypes())
                        .addAttribute("tempFilm", filmDTO);
                return "films";
            }
    }

    @PostMapping("/films/delete")
    public String delete(@RequestParam Long id){
        filmService.delete(id);
        return "redirect:/films";
    }

    @GetMapping("films/edit/{id}")
    public String getEditPage(@PathVariable Long id, Model model) {
        model.addAttribute("films", filmService.findById(id))
                .addAttribute("categories", filmService.getCategories())
                .addAttribute("types", filmService.getTypes());
        return "filmEdit";
    }

    @PostMapping("films/edit")
    public String musicsEdit(FilmDTO filmDTO, Model model) {
        if (filmService.isUnique(filmDTO)) {
            filmService.edit(filmDTO);
            return "redirect:/films";
        } else {
            Film film = filmService.findExists(filmDTO);
            model.addAttribute("films", film)
                    .addAttribute("categories", filmService.getCategories())
                    .addAttribute("types", filmService.getTypes())
                    .addAttribute("message", true);
            return "filmEdit";
        }
    }
}
