package com.example.ropa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.ropa.model.Polos;

@Repository
public interface PolosRepository extends MongoRepository<Polos, Long> {

}
