package com.example.servingwebcontent.repos;

import com.example.servingwebcontent.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnalyseFilmRepository extends JpaRepository<Film, Long> {

    @Query(value = "select f.name as name, f.year as year, f.price as price, fc.name as nameFC, f.rating as rating\n" +
            "from film as f\n" +
            "left join film_category as fc\n" +
            "on f.id_film_category = fc.id\n" +
            "order by f.rating DESC", nativeQuery = true)
    List<EntityRepo> filmRating();

    @Query(value = "select f.name as name, f.year as year, f.price as price, fc.name as nameFC, f.rating as rating\n" +
            "from film as f\n" +
            "left join film_category as fc\n" +
            "on f.id_film_category = fc.id\n" +
            "where f.id_film_category = ?1\n" +
            "order by f.rating DESC", nativeQuery = true)
    List<EntityRepo> filmRatingCategory(Long idCategory);
}
