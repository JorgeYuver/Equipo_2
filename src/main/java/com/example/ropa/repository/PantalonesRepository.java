package com.example.ropa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.ropa.model.Pantalones;

@Repository
public interface PantalonesRepository extends MongoRepository<Pantalones, Long> {

}
