package com.example.ropa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ropa.model.Polos;
import com.example.ropa.repository.PolosRepository;

@Service
public class PolosServicesImpl implements PolosServices {

	@Autowired
	private PolosRepository repositorio;
	
	@Override
	public Polos crearPolos(Polos polos) {
		if(polos==null) {
			return null;
		}
		if(polos.getId()==null) {
			return null;
		}
		Optional<Polos> PolosExiste=repositorio.findById(polos.getId());
		if(PolosExiste.isPresent()) {
			return PolosExiste.get();
		}else {
			return repositorio.insert(polos);
		}
	}

	@Override
	public Polos actualizarPolos(Polos polos) {
		if(polos==null) {
			return null;
		}
		if(polos.getId()==null) {
			return null;
		}
		Optional<Polos> PolosExiste=repositorio.findById(polos.getId());
		if(PolosExiste.isPresent()) {
			return repositorio.save(polos);
		}else {
			return null;
		}
	}

	@Override
	public String EliminarPolos(Long id) {
		if(id==null) {
			return "El codigo no puede ser nulo";
		}
		Optional<Polos> PolosExiste=repositorio.findById(id);
		if(PolosExiste.isPresent()) {
			repositorio.delete(PolosExiste.get());
			return "El Polo fue eliminado";
		}
		return "El Polo no existe";
	}

	@Override
	public Optional<Polos> consultarPolosId(Long id) {
		return repositorio.findById(id);
	}

	@Override
	public List<Polos> consultarTodosPolos() {
		return repositorio.findAll();
	}

}
