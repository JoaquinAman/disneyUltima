package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.builder.GeneroBuilder;
import com.example.demo.dto.GeneroDto;
import com.example.demo.excepciones.BussinesException;
import com.example.demo.excepciones.ResourceNotFoundException;
import com.example.demo.model.Genero;
import com.example.demo.repository.GeneroRepository;
import com.example.demo.repository.PeliculaRepository;
import com.example.demo.service.GeneroService;

@Service
public class GeneroServiceImpl implements GeneroService {
	@Autowired
	private GeneroRepository generoRepository;

	@Autowired
	private PeliculaRepository peliculaRepository;

	@Override
	public List<Genero> mostrarTodasGenero() {
		try {
			return generoRepository.findAll();
		} catch (Exception e) {
			throw new BussinesException("Error al mostrar la entidad");
		}
	}

	@Override
	public Genero nuevaGenero(GeneroDto generoDto) {
		try {
			Genero nuevoGenero = new GeneroBuilder().withGeneroDto(generoDto).build();
			return generoRepository.save(nuevoGenero);
		} catch (Exception e) {
			throw new BussinesException("imposible generar nueva entidad");
		}
	}

	@Override
	public Genero reemplazarGenero(Long id, GeneroDto generoDto) {
		try {
			Genero nuevoGenero = generoRepository.findById(id).get();
			nuevoGenero = new GeneroBuilder().withGeneroDto(generoDto).edit(nuevoGenero);
			// nuevoGenero.setPeli(peliculaRepository.findById(generoDto.getIdPelicula()).get());
			nuevoGenero.getPeliculas().add(peliculaRepository.findById(generoDto.getIdPelicula()).get());
			return generoRepository.save(nuevoGenero);

		} catch (Exception e) {
			throw new ResourceNotFoundException("no se encontro el id de la entidad");
		}
	}

	@Override
	public void borrarGenero(Long id) {
		try {
			generoRepository.deleteById(id);
		} catch (Exception e) {
			throw new ResourceNotFoundException("no se encontro el id de la entidad");
		}
	}
}
