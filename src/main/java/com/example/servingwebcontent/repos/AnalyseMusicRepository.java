package com.example.servingwebcontent.repos;

import com.example.servingwebcontent.domain.Music;
import com.example.servingwebcontent.domain.MusicCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnalyseMusicRepository extends JpaRepository<Music, Long> {

    @Query(value = "select m.name as name, m.performer as performer, m.price as price, mc.name as nameMC, m.rating as rating\n" +
            "from music as m\n" +
            "left join music_category as mc\n" +
            "on m.id_music_category = mc.id\n" +
            "order by m.rating DESC", nativeQuery = true)
    List<EntityRepo> musicRating();

    @Query(value = "select m.name as name, m.performer as performer, m.price as price, mc.name as nameMC, m.rating as rating\n" +
            "from music as m\n" +
            "left join music_category as mc\n" +
            "on m.id_music_category = mc.id\n" +
            "where m.id_music_category = ?1\n" +
            "order by m.rating DESC", nativeQuery = true)
    List<EntityRepo> musicRatingCategory(Long idCategory);
}
