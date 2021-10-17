package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.GeneroDto;
import com.example.demo.model.Genero;
import com.example.demo.service.GeneroService;

@RestController
@RequestMapping("/generos")
@CrossOrigin("*")
public class GeneroController {

	@Autowired
	private GeneroService generoService;

	@GetMapping
	public ResponseEntity<?> mostrarGeneros() {
		try {
			return new ResponseEntity<>(generoService.mostrarTodasGenero(), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> actualizarGenero(@PathVariable Long id, @RequestBody GeneroDto generoDto) {
		try {
			return new ResponseEntity<>(generoService.reemplazarGenero(id, generoDto), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<?> guardarGenero(@RequestBody GeneroDto generoDto) {
		try {
			Genero genero = generoService.nuevaGenero(generoDto);
			return new ResponseEntity<>(genero, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> borrarGenero(@PathVariable Long id) {
		try {
			generoService.borrarGenero(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
