package com.example.servingwebcontent.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "music_category")
public class MusicCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "musicCategory")
    @ElementCollection(targetClass = Music.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "music_category_music", joinColumns = @JoinColumn(name = "id_music_category"))
    @Enumerated(EnumType.STRING)
    private Set<Music> musics;

    public MusicCategory() {}

    public MusicCategory(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
