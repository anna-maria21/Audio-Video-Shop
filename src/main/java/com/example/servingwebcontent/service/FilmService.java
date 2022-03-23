package com.example.servingwebcontent.service;

import com.example.servingwebcontent.DTO.FilmDTO;
import com.example.servingwebcontent.domain.*;
import com.example.servingwebcontent.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmService {

    @Autowired
    FilmRepo filmRepo;

    @Autowired
    FilmCategoryRepo filmCategoryRepo;

    @Autowired
    TypeRepo typeRepo;

    public Iterable<Film> find(String filter) {
        Iterable<Film> films;

        if (filter != null && !filter.isEmpty()) {
            films = filmRepo.findByName(filter);
        } else {
            films = filmRepo.findAll();
        }

        return films;
    }

    public Film findById(Long id) {
        return filmRepo.findById(id).get();
    }

    public Iterable<Film> findAll() {
        return filmRepo.findAll();
    }

    public Iterable<FilmCategory> getCategories() {
        return filmCategoryRepo.findAll();
    }

    public Iterable<Type> getTypes() {
        return typeRepo.findAll();
    }

    public boolean isUnique(FilmDTO filmDTO) {
        Film film = filmRepo.findByNameAndDirector(filmDTO.getName(), filmDTO.getDirector());
        return film == null || film.getId().equals(filmDTO.getId());
    }

    public Film save(FilmDTO filmDTO) {
        return filmRepo.save(new Film(filmDTO.getName(),filmDTO.getDirector(), filmDTO.getDescription(), String.valueOf(filmDTO.getYear()),
                filmDTO.getRating(), filmDTO.getPrice(),
                filmCategoryRepo.findById(filmDTO.getIdFilmCategory()).get(),
                typeRepo.findById(filmDTO.getIdType()).get(), filmDTO.getUser()));
    }

    public void delete(Long id) {
        filmRepo.deleteById(id);
    }

    public Film edit(FilmDTO filmDTO) {

        Film film = findById(filmDTO.getId());
        film.setName(filmDTO.getName());
        film.setDirector(filmDTO.getDirector());
        film.setDescription(filmDTO.getDescription());
        film.setYear(String.valueOf(filmDTO.getYear()));
        film.setRating(filmDTO.getRating());
        film.setPrice(filmDTO.getPrice());
        film.setFilmCategory(filmCategoryRepo.findById(filmDTO.getIdFilmCategory()).get());
        film.setType(typeRepo.findById(filmDTO.getIdType()).get());
        filmRepo.save(film);

        return film;
    }

    public Film findExists(FilmDTO filmDTO) {
        return filmRepo.findByNameAndDirector(filmDTO.getName(), filmDTO.getDirector());
    }
}
