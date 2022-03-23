package com.example.servingwebcontent.repos;

import com.example.servingwebcontent.domain.Balance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepo extends CrudRepository<Balance, Long> {
}
