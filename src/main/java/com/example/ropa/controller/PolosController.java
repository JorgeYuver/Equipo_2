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

import com.example.ropa.model.Polos;
import com.example.ropa.services.PolosServices;

@RestController
@RequestMapping("/api/polos")
public class PolosController {

	@Autowired
	private PolosServices servicio;
	
	@GetMapping
	public ResponseEntity<?> consultarTodosPolos(){
		return ResponseEntity.status(HttpStatus.OK).body(servicio.consultarTodosPolos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> consultarPolosId(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(servicio.consultarPolosId(id));
	}
	
	@PostMapping
	public ResponseEntity<?> crearPolos(@RequestBody Polos polos){
		return ResponseEntity.status(HttpStatus.CREATED).body(servicio.crearPolos(polos));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> actualizarPolos(@PathVariable Long id, @RequestBody Polos polos){
		return ResponseEntity.status(HttpStatus.OK).body(servicio.actualizarPolos(polos));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> EliminarPolos(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.EliminarPolos(id));
	}
	
}
