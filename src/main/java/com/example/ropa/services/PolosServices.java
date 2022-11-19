package com.example.ropa.services;

import java.util.List;
import java.util.Optional;

import com.example.ropa.model.Polos;

public interface PolosServices {

	public Polos crearPolos(Polos polos);
	
	public Polos actualizarPolos(Polos polos);
	
	public String EliminarPolos(Long id);
	
	public Optional<Polos> consultarPolosId(Long id);
	
	public List<Polos> consultarTodosPolos();
	
}
