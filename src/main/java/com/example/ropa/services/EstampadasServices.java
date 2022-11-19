package com.example.ropa.services;

import java.util.List;
import java.util.Optional;

import com.example.ropa.model.Estampadas;

public interface EstampadasServices {

	public Estampadas crearEstampadas(Estampadas estampadas);
	
	public Estampadas actualizarEstampadas(Estampadas estampadas);
	
	public String EliminarEstampadas(Long id);
	
	public Optional<Estampadas> consultarEstampadasId(Long id);
	
	public List<Estampadas> consultarTodasEstampadas();
	
}
