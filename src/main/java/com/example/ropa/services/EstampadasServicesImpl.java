package com.example.ropa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ropa.model.Estampadas;
import com.example.ropa.repository.EstampadasRepository;

@Service
public class EstampadasServicesImpl implements EstampadasServices {

	@Autowired
	private EstampadasRepository repositorio;
	
	@Override
	public Estampadas crearEstampadas(Estampadas estampadas) {
		if(estampadas==null) {
			return null;
		}
		if(estampadas.getId()==null) {
			return null;
		}
		Optional<Estampadas> estamExiste=repositorio.findById(estampadas.getId());
		if(estamExiste.isPresent()) {
			return estamExiste.get();
		}else {
			return repositorio.insert(estampadas);
		}
		
	}

	@Override
	public Estampadas actualizarEstampadas(Estampadas estampadas) {
		if(estampadas==null) {
			return null;
		}
		if(estampadas.getId()==null) {
			return null;
		}
		Optional<Estampadas> estamExiste=repositorio.findById(estampadas.getId());
		if(estamExiste.isPresent()) {
			return repositorio.save(estampadas);
		}else {
			return null;
		}
	}

	@Override
	public String EliminarEstampadas(Long id) {
		if(id==null) {
			return "El codigo no puede ser nulo";
		}
		Optional<Estampadas> estamExiste=repositorio.findById(id);
		if(estamExiste.isPresent()) {
			repositorio.delete(estamExiste.get());
			return "La camiseta estampada fue eliminada";
		}
		return "La camiseta estampada no existe";
	}

	@Override
	public Optional<Estampadas> consultarEstampadasId(Long id) {
		return repositorio.findById(id);
	}

	@Override
	public List<Estampadas> consultarTodasEstampadas() {
		return repositorio.findAll();
	}

}
