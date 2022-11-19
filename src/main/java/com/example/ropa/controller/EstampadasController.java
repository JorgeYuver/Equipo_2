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

import com.example.ropa.model.Estampadas;
import com.example.ropa.services.EstampadasServices;

@RestController
@RequestMapping("/api/estampadas")
public class EstampadasController {
	
	@Autowired
	private EstampadasServices servicio;
	
	@GetMapping
	public ResponseEntity<?> consultarTodasEstampadas(){
		return ResponseEntity.status(HttpStatus.OK).body(servicio.consultarTodasEstampadas());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> consultarEstampadasId(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(servicio.consultarEstampadasId(id));
	}
	
	@PostMapping
	public ResponseEntity<?> crearEstampadas(@RequestBody Estampadas estampadas){
		return ResponseEntity.status(HttpStatus.CREATED).body(servicio.crearEstampadas(estampadas));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> actualizarEstampadas(@PathVariable Long id, @RequestBody Estampadas estampadas){
		return ResponseEntity.status(HttpStatus.OK).body(servicio.actualizarEstampadas(estampadas));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> EliminarEstampadas(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.EliminarEstampadas(id));
	}
}
