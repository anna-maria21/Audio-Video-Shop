package com.example.servingwebcontent.repos;

import com.example.servingwebcontent.domain.MusicCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicCategoryRepo extends CrudRepository<MusicCategory, Long> {
}
