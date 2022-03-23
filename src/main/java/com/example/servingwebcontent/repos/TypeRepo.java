package com.example.servingwebcontent.repos;

import com.example.servingwebcontent.domain.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepo extends CrudRepository<Type, Long> {
}
