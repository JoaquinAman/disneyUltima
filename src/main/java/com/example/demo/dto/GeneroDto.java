package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GeneroDto {
	private String nombre;
	private String imagen;
	private Long idPelicula;
}
