package com.example.servingwebcontent.domain;

import javax.persistence.*;

@Entity
@Table(name = "balance")
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double bonuses;

    @OneToOne(mappedBy = "balance")
    private User user;

    public Balance() {}

    public Balance(double bonuses) {
        this.bonuses = bonuses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getBonuses() {
        return bonuses;
    }

    public void setBonuses(double bonuses) {
        this.bonuses = bonuses;
    }
}
