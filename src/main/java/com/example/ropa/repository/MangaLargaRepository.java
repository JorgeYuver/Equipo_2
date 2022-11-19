package com.example.ropa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.ropa.model.MangaLarga;

@Repository
public interface MangaLargaRepository extends MongoRepository<MangaLarga, Long> {

}
