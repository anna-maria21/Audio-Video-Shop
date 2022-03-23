package com.example.servingwebcontent.repos;

import org.springframework.stereotype.Repository;

@Repository
public interface EntityRepo {
    String getName();
    Integer getCounter();
    Double getPrice();
    Double getSum();
    String getFullName();
    Integer getYear();
    String getNameFC();
    String getNameMC();
    Integer getRating();
    String getPerformer();
}
