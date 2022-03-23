package com.example.servingwebcontent.DTO;

import com.example.servingwebcontent.domain.User;

public class MusicDTO {
    private User user;
    private Long id;
    private String name;
    private String performer;
    private int year;
    private String rating;
    private String price;
    private Long idMusicCategory;
    private Long idType;


    public MusicDTO() {}

    public MusicDTO(User user, String name, String performer, String year, String rating, String price, Long idMusicCategory, Long idType) {
        this.user = user;
        this.name = name;
        this.performer = performer;
        this.year = Integer.parseInt(year);
        this.rating = rating;
        this.price = price;
        this.idMusicCategory = idMusicCategory;
        this.idType = idType;
    }

    public MusicDTO(Long id, String name, String performer, String year, String rating, String price, Long idMusicCategory, Long idType, User user) {
        this.id = id;
        this.name = name;
        this.performer = performer;
        this.year = Integer.parseInt(year);
        this.rating = rating;
        this.price = price;
        this.idMusicCategory = idMusicCategory;
        this.idType = idType;
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

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = Integer.parseInt(year);
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

    public Long getIdMusicCategory() {
        return idMusicCategory;
    }

    public void setIdMusicCategory(Long idMusicCategory) {
        this.idMusicCategory = idMusicCategory;
    }

    public Long getIdType() {
        return idType;
    }

    public void setIdType(Long idType) {
        this.idType = idType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "MusicDTO{" +
                "user=" + user +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", performer='" + performer + '\'' +
                ", year='" + year + '\'' +
                ", rating='" + rating + '\'' +
                ", price='" + price + '\'' +
                ", idMusicCategory=" + idMusicCategory +
                ", idType=" + idType +
                '}';
    }
}
