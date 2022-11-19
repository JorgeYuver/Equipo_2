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

import com.example.ropa.model.Pantalones;
import com.example.ropa.services.PantalonesServices;

@RestController
@RequestMapping("/api/pantalones")
public class PantalonesController {

	@Autowired
	private PantalonesServices servicio;
	
	@GetMapping
	public ResponseEntity<?> consultarTodosPantalones(){
		return ResponseEntity.status(HttpStatus.OK).body(servicio.consultarTodosPantalones());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> consultarPantalonesId(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(servicio.consultarPantalonesId(id));
	}
	
	@PostMapping
	public ResponseEntity<?> crearPantalones(@RequestBody Pantalones pantalones){
		return ResponseEntity.status(HttpStatus.CREATED).body(servicio.crearPantalones(pantalones));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizarPantalones(@PathVariable Long id, @RequestBody Pantalones pantalones){
		return ResponseEntity.status(HttpStatus.OK).body(servicio.actualizarPantalones(pantalones));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> EliminarPantalones(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.EliminarPantalones(id));
	}
	
}
	
