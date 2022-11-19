package com.example.ropa.services;

import java.util.List;
import java.util.Optional;


import com.example.ropa.model.MangaLarga;

public interface MangaLargaServices {

	public MangaLarga crearMangaLarga(MangaLarga mangalarga);
	
	public MangaLarga actualizarMangaLarga(MangaLarga mangalarga);
	
	public String EliminarMangaLarga(Long id);
	
	public Optional<MangaLarga> consultarMangaLargaId(Long id);
	
	public List<MangaLarga> consultarTodasMangaLarga();
	
}
 