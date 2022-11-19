package com.example.ropa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ropa.model.Categoria;
import com.example.ropa.repository.CategoriaRepository;

@Service
public class CategoriaServicesImpl implements CategoriaServices {

	@Autowired
	private CategoriaRepository repositorio;
	
	@Override
	public Categoria crearCategoria(Categoria categoria) {
		if(categoria==null) {
			return null;
		}
		if(categoria.getId()==null) {
			return null;
		}
		Optional<Categoria> catExiste=repositorio.findById(categoria.getId());
		if(catExiste.isPresent()) {
			return catExiste.get();
		}else {
			return repositorio.insert(categoria);
		}
	}

	@Override
	public Categoria actualizarCategoria(Categoria categoria) {
		if(categoria==null) {
			return null;
		}
		if(categoria.getId()==null) {
			return null;
		}
		Optional<Categoria> catExiste=repositorio.findById(categoria.getId());
		if(catExiste.isPresent()) {
			return repositorio.save(categoria);
		}else {
			return null;
		}	
	}

	@Override
	public String eliminarCategoria(Long id) {
		if(id==null) {
			return "El codigo no puede ser nulo";
		}
		Optional<Categoria> catExiste=repositorio.findById(id);
		if(catExiste.isPresent()) {
			repositorio.delete(catExiste.get());
			return "La categoria fue eliminada";
		}
		return "La categoria no existe";
	}

	@Override
	public Optional<Categoria> consultarCategoria(Long id, String nombre) {
		if(id==null && nombre==null) {
			return Optional.empty();
		}
		if(id==null) {
			List<Categoria> categorias=repositorio.findByNombre(nombre);
			if(categorias.isEmpty()) {
				return Optional.empty();
			}else {
				return Optional.of(categorias.get(0));
			}
		}
		if(nombre==null) {
			return repositorio.findById(id);
		}
		List<Categoria> catBuscadas=repositorio.findByIdNombre(id, nombre);
		if(catBuscadas.isEmpty()) {
			return Optional.empty();
		}else {
			return Optional.of(catBuscadas.get(0));
		}
	}

	@Override
	public List<Categoria> consultarTodos() {
		return repositorio.findAll();
	}

}
