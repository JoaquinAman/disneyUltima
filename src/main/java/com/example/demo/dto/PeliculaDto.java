package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PeliculaDto {
	private String imagen;
	private String titulo;
	private int calificacion;
	private Long idPersonaje;

}
