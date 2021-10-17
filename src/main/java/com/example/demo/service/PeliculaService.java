package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.PeliculaDto;
import com.example.demo.model.Pelicula;

public interface PeliculaService {

	public List<Pelicula> mostrarTodasPeliculas();

	public Pelicula buscarPorTitulo(String titulo);

	public List<Pelicula> buscarPorCreacionAscendente();

	public List<Pelicula> buscarPorCreacionDescendente();

	public Pelicula nuevaPelicula(PeliculaDto peliculaDto);

	public Pelicula reemplazarPelicula(Long id, PeliculaDto peliculaDto);

	public List<Pelicula> buscarTodasPelisPorGeneroId(Long id);

	public void borrarPelicula(Long id);
}
