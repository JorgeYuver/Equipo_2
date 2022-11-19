package com.example.ropa.services;

import java.util.List;
import java.util.Optional;

import com.example.ropa.model.Categoria;

public interface CategoriaServices {

	public Categoria crearCategoria(Categoria categoria);
	
	public Categoria actualizarCategoria(Categoria categoria);
	
	public String eliminarCategoria(Long id);
	
	public Optional<Categoria> consultarCategoria(Long id, String nombre);
	
	public List<Categoria> consultarTodos();
	
	
	
}
