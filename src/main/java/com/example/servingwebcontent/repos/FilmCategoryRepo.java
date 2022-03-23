package com.example.servingwebcontent.repos;

import com.example.servingwebcontent.domain.FilmCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmCategoryRepo extends CrudRepository<FilmCategory, Long> {
}
