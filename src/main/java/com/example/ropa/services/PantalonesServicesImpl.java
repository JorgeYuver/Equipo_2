package com.example.ropa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ropa.model.Pantalones;
import com.example.ropa.repository.PantalonesRepository;

@Service
public class PantalonesServicesImpl implements PantalonesServices {

	@Autowired
	private PantalonesRepository repositorio;
	
	@Override
	public Pantalones crearPantalones(Pantalones pantalones) {
		if(pantalones==null) {
			return null;
		}
		if(pantalones.getId()==null) {
			return null;
		}
		Optional<Pantalones> panExiste=repositorio.findById(pantalones.getId());
		if(panExiste.isPresent()) {
			return panExiste.get();
		}else {
			return repositorio.insert(pantalones);
		}
	}

	@Override
	public Pantalones actualizarPantalones(Pantalones pantalones) {
		if(pantalones==null) {
			return null;
		}
		if(pantalones.getId()==null) {
			return null;
		}
		Optional<Pantalones> panExiste=repositorio.findById(pantalones.getId());
		if(panExiste.isPresent()) {
			return repositorio.save(pantalones);
		}else {
			return null;
		}
	}

	@Override
	public String EliminarPantalones(Long id) {
		if(id==null) {
			return "El codigo no puede ser nulo";
		}
		Optional<Pantalones> panmExiste=repositorio.findById(id);
		if(panmExiste.isPresent()) {
			repositorio.delete(panmExiste.get());
			return "El Pantalon fue eliminado";
		}
		return "El Pantalon no existe";
	}

	@Override
	public Optional<Pantalones> consultarPantalonesId(Long id) {
		return repositorio.findById(id);
	}

	@Override
	public List<Pantalones> consultarTodosPantalones() {
		return repositorio.findAll();
	}

}
