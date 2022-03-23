package com.example.servingwebcontent.DTO;

import com.example.servingwebcontent.domain.User;

public class FilmDTO {
    private User user;
    private Long id;
    private String name;
    private String director;
    private String description;
    private int year;
    private String rating;
    private String price;
    private Long idFilmCategory;
    private Long idType;

    public FilmDTO() {}

    public FilmDTO(User user, String name, String director, String description, int year, String rating, String price, Long idFilmCategory, Long idType) {
        this.user = user;
        this.name = name;
        this.director = director;
        this.description = description;
        this.year = year;
        this.rating = rating;
        this.price = price;
        this.idFilmCategory = idFilmCategory;
        this.idType = idType;
    }

    public FilmDTO(Long id, String name, String director, String description, int year, String rating, String price, Long idFilmCategory, Long idType, User user) {
        this.user = user;
        this.id = id;
        this.name = name;
        this.director = director;
        this.description = description;
        this.year = year;
        this.rating = rating;
        this.price = price;
        this.idFilmCategory = idFilmCategory;
        this.idType = idType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Long getIdFilmCategory() {
        return idFilmCategory;
    }

    public void setIdFilmCategory(Long idFilmCategory) {
        this.idFilmCategory = idFilmCategory;
    }

    public Long getIdType() {
        return idType;
    }

    public void setIdType(Long idType) {
        this.idType = idType;
    }

    @Override
    public String toString() {
        return "FilmDTO{" +
                "user=" + user +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", year=" + year +
                ", rating='" + rating + '\'' +
                ", price='" + price + '\'' +
                ", idFilmCategory=" + idFilmCategory +
                ", idType=" + idType +
                '}';
    }
}
