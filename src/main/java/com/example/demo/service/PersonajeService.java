package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.PersonajeDto;
import com.example.demo.model.Personaje;

public interface PersonajeService {

	List<String> showNombresAndImagen();

	List<Personaje> mostrarPeliculasPorId(Long id);

	List<Personaje> buscarPorNombre(String nombre);

	List<Personaje> buscarPorEdad(int edad);

	List<Personaje> buscarPorPeso(int peso);

	List<Personaje> showAll();

	Personaje newPersonaje(PersonajeDto personajeDto);

	Personaje replacePersonaje(Long id, PersonajeDto personajeDto);

	void deletePersonaje(Long id);
}
