package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.repos.AnalyseFilmRepository;
import com.example.servingwebcontent.repos.AnalyseMusicRepository;
import com.example.servingwebcontent.repos.FilmCategoryRepo;
import com.example.servingwebcontent.repos.MusicCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AnalyseFilmController {

    @Autowired
    AnalyseFilmRepository analyseFilmRepository;

    @Autowired
    AnalyseMusicRepository analyseMusicRepository;

    @Autowired
    FilmCategoryRepo filmCategoryRepo;

    @Autowired
    MusicCategoryRepo musicCategoryRepo;

    @GetMapping("/analyse")
    public String getFilmAnalyse(Model model) {
        model.addAttribute("ratingFilm", analyseFilmRepository.filmRating())
            .addAttribute("ratingMusic", analyseMusicRepository.musicRating())
            .addAttribute("filmCategories", filmCategoryRepo.findAll())
            .addAttribute("musicCategories", musicCategoryRepo.findAll());
        return "analyse";
    }

    @GetMapping("/analyse/film/category")
    public String getFilmCategoryAnalyse(@RequestParam Long idCategory, Model model) {
        model.addAttribute("ratingFilm", analyseFilmRepository.filmRatingCategory(idCategory))
                .addAttribute("ratingMusic", analyseMusicRepository.musicRating())
                .addAttribute("filmCategories", filmCategoryRepo.findAll())
                .addAttribute("musicCategories", musicCategoryRepo.findAll())
                .addAttribute("selectedFilm", filmCategoryRepo.findById(idCategory));
        return "analyse";
    }

    @GetMapping("/analyse/music/category")
    public String getMusicCategoryAnalyse(@RequestParam Long idCategory, Model model) {
        model.addAttribute("ratingMusic", analyseMusicRepository.musicRatingCategory(idCategory))
                .addAttribute("ratingFilm", analyseFilmRepository.filmRating())
                .addAttribute("filmCategories", filmCategoryRepo.findAll())
                .addAttribute("musicCategories", musicCategoryRepo.findAll())
                .addAttribute("selectedMusic", musicCategoryRepo.findById(idCategory));
        return "analyse";
    }
}
