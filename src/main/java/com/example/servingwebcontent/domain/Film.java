package com.example.servingwebcontent.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String director;
    private String description;
    private int year;
    private int rating;
    private double price;

    @ManyToOne
    @JoinColumn(name = "id_film_category")
    private FilmCategory filmCategory;

    @ManyToOne
    @JoinColumn(name = "id_type")
    private Type type;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "person_film",
            joinColumns = @JoinColumn(name = "id_film"),
            inverseJoinColumns = @JoinColumn(name = "id_person"))
    private Set<User> users;

    public Film() {}

    public Film(String name, String director, String description, String year, String rating, String price, FilmCategory filmCategory, Type type, User author) {
        this.name = name;
        this.director = director;
        this.description = description;
        this.year = Integer.parseInt(year);
        this.rating = Integer.parseInt(rating);
        this.price = Integer.parseInt(price);
        this.filmCategory = filmCategory;
        this.type = type;
        this.author = author;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = Integer.parseInt(year);
    }

    public int getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = Integer.parseInt(rating);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = Integer.parseInt(price);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public FilmCategory getFilmCategory() {
        return filmCategory;
    }

    public void setFilmCategory(FilmCategory filmCategory) {
        this.filmCategory = filmCategory;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
