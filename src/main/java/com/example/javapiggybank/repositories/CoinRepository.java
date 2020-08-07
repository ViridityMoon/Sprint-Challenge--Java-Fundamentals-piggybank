package com.example.javapiggybank.repositories;

import com.example.javapiggybank.models.Coin;
import org.springframework.data.repository.CrudRepository;

public interface CoinRepository extends CrudRepository<Coin, Long>
{
}
