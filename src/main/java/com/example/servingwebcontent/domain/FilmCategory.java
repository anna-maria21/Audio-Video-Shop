package com.example.servingwebcontent.domain;

import javax.persistence.*;
import java.io.File;
import java.util.Set;

@Entity
@Table(name = "film_category")
public class FilmCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "filmCategory")
    @ElementCollection(targetClass = Film.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "film_category_film", joinColumns = @JoinColumn(name = "id_film_category"))
    @Enumerated(EnumType.STRING)
    private Set<Film> films;

    public FilmCategory() {}

    public FilmCategory(String name) {
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
