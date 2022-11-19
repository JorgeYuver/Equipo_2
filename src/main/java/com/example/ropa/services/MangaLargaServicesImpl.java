package com.example.ropa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.ropa.model.MangaLarga;
import com.example.ropa.repository.MangaLargaRepository;




@Service
public class MangaLargaServicesImpl implements MangaLargaServices {

	@Autowired
	private MangaLargaRepository repositorio;
	
	@Override
	public MangaLarga crearMangaLarga(MangaLarga mangalarga) {
		if(mangalarga==null) {
			return null;
		}
		if(mangalarga.getId()==null) {
			return null;
		}
		Optional<MangaLarga> mLargaExiste=repositorio.findById(mangalarga.getId());
		if(mLargaExiste.isPresent()) {
			return mLargaExiste.get();
		}else {
			return repositorio.insert(mangalarga);
		}
		
	}

	@Override
	public MangaLarga actualizarMangaLarga(MangaLarga mangalarga) {
		if(mangalarga==null) {
			return null;
		}
		if(mangalarga.getId()==null) {
			return null;
		}
		Optional<MangaLarga> mLargaExiste=repositorio.findById(mangalarga.getId());
		if(mLargaExiste.isPresent()) {
			return repositorio.save(mangalarga);
		}else {
			return null;
		}
	}

	@Override
	public String EliminarMangaLarga(Long id) {
		if(id==null) {
			return "El codigo no puede ser nulo";
		}
		Optional<MangaLarga> mLargaExiste=repositorio.findById(id);
		if(mLargaExiste.isPresent()) {
			repositorio.delete(mLargaExiste.get());
			return "La camiseta Manga Larga fue eliminada";
		}
		return "La camiseta Manga Larga no existe";
	}

	@Override
	public Optional<MangaLarga> consultarMangaLargaId(Long id) {
		return repositorio.findById(id);
	}

	@Override
	public List<MangaLarga> consultarTodasMangaLarga() {
		return repositorio.findAll();
	}

}
