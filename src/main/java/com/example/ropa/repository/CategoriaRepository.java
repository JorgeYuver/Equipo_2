package com.example.ropa.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ropa.model.Categoria;

@Repository
public interface CategoriaRepository extends MongoRepository<Categoria, Long> {

	@Query("{nombre:'?0'}")
	public List<Categoria> findByNombre(String nombre);
	
	@Query("{id:'?0',nombre'?1'}")
	public List<Categoria> findByIdNombre(Long id, String nombre);
	
	
	
	
}
