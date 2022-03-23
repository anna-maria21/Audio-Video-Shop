package com.example.servingwebcontent.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "type")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "type")
    @ElementCollection(targetClass = Music.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "type_music", joinColumns = @JoinColumn(name = "id_type"))
    @Enumerated(EnumType.STRING)
    private Set<Music> musics;

    @OneToMany(mappedBy = "type")
    @ElementCollection(targetClass = Film.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "type_film", joinColumns = @JoinColumn(name = "id_type"))
    @Enumerated(EnumType.STRING)
    private Set<Film> films;

    public Type() {}

    public Type(String name) {
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
