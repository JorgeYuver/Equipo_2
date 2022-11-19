package com.example.ropa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ropa.model.MangaLarga;
import com.example.ropa.services.MangaLargaServices;

@RestController
@RequestMapping("/api/mangalarga")
public class MangaLargaController {
	
	@Autowired
	private MangaLargaServices servicio;
	
	@GetMapping
	public ResponseEntity<?> consultarTodasMangaLarga(){
		return ResponseEntity.status(HttpStatus.OK).body(servicio.consultarTodasMangaLarga());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> consultarMangaLargaId(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(servicio.consultarMangaLargaId(id));
	}
	
	@PostMapping
	public ResponseEntity<?> crearMangaLarga(@RequestBody MangaLarga mangalarga){
		return ResponseEntity.status(HttpStatus.CREATED).body(servicio.crearMangaLarga(mangalarga));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> actualizarMangaLarga(@PathVariable Long id, @RequestBody MangaLarga mangalarga){
		return ResponseEntity.status(HttpStatus.OK).body(servicio.actualizarMangaLarga(mangalarga));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> EliminarMangaLarga(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.EliminarMangaLarga(id));
	}

}
