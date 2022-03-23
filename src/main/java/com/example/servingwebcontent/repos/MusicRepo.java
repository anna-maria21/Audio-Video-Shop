package com.example.servingwebcontent.repos;

import com.example.servingwebcontent.domain.Music;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepo extends CrudRepository<Music, Long> {
    List<Music> findByName(String name);
    Music findByNameAndPerformer(String name, String performer);

}
