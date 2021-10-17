package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.GeneroDto;
import com.example.demo.model.Genero;

public interface GeneroService {

	public List<Genero> mostrarTodasGenero();

	public Genero nuevaGenero(GeneroDto generoDto);

	public Genero reemplazarGenero(Long id, GeneroDto generoDto);

	public void borrarGenero(Long id);
}
