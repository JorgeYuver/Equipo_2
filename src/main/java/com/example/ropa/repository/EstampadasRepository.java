package com.example.ropa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.ropa.model.Estampadas;

@Repository
public interface EstampadasRepository extends MongoRepository<Estampadas, Long> {

}
