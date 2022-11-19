package com.example.ropa.services;

import java.util.List;
import java.util.Optional;

import com.example.ropa.model.Pantalones;

public interface PantalonesServices {

	public Pantalones crearPantalones(Pantalones pantalones);
	
	public Pantalones actualizarPantalones(Pantalones pantalones);
	
	public String EliminarPantalones(Long id);
	
	public Optional<Pantalones> consultarPantalonesId(Long id);
	
	public List<Pantalones> consultarTodosPantalones();
}
