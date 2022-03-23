package com.example.servingwebcontent.repos;

import com.example.servingwebcontent.domain.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepo extends CrudRepository<Film, Long> {
    List<Film> findByName(String name);
    Film findByNameAndDirector(String name, String director);
}
