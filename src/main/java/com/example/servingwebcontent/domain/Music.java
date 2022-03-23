package com.example.servingwebcontent.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "music")
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String name;
    private String performer;
    private int year;
    private int rating;
    private double price;

    @ManyToOne
    @JoinColumn(name = "id_music_category")
    private MusicCategory musicCategory;

    @ManyToOne
    @JoinColumn(name = "id_type")
    private Type type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "person_music",
            joinColumns = @JoinColumn(name = "id_music"),
            inverseJoinColumns = @JoinColumn(name = "id_person"))
    private Set<User> users;

    public Music() {}

    public Music(String name, String performer, String year, String rating, String price, MusicCategory musicCategory, Type type, User user) {
        this.name = name;
        this.performer = performer;
        this.year = Integer.parseInt(year);
        this.rating = Integer.parseInt(rating);
        this.price = Integer.parseInt(price);
        this.musicCategory = musicCategory;
        this.type = type;
        this.author = user;
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

    public MusicCategory getMusicCategory() {
        return musicCategory;
    }

    public void setMusicCategory(MusicCategory musicCategory) {
        this.musicCategory = musicCategory;
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
