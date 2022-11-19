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

import com.example.ropa.model.Categoria;
import com.example.ropa.services.CategoriaServices;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaServices servicio;
	
	@GetMapping
	public ResponseEntity<?> consultarTodos(){
		return ResponseEntity.status(HttpStatus.OK).body(servicio.consultarTodos());
			
	}
	
	@GetMapping("/i/{id}")
	public ResponseEntity<?> consultarPorId(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(servicio.consultarCategoria(id, null));
		
	}
	
	@GetMapping("/n/{nombre}")
	public ResponseEntity<?> consultarPorNombre(@PathVariable String nombre){
		return ResponseEntity.status(HttpStatus.OK).body(servicio.consultarCategoria(null, nombre));
		
	}
	
	@GetMapping("/in/{id}/{nombre}")
	public ResponseEntity<?> consultarPorIdNombre(@PathVariable Long id, String nombre){
		return ResponseEntity.status(HttpStatus.OK).body(servicio.consultarCategoria(id, nombre));
		
	}
	
	@PostMapping
	public ResponseEntity<?> crearCategoria(@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(servicio.crearCategoria(categoria));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.OK).body(servicio.actualizarCategoria(categoria));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarCategoria(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.eliminarCategoria(id));
	}

}
