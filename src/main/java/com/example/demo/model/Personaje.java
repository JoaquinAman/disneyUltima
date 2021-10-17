package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Null;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Personaje {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String imagen;
	private String nombre;
	private int edad;
	private int peso;
	private String historia;

	@Null
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.PERSIST }, targetEntity = Pelicula.class)
	@JoinTable(name = "personaje_peliculas", inverseJoinColumns = @JoinColumn(name = "pelicula_id", nullable = false, updatable = false), joinColumns = @JoinColumn(name = "personaje_id", nullable = false, updatable = false), foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT), inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
	@JsonManagedReference
	private List<Pelicula> peliculas;

	public Personaje(String url, String nombre, int edad, int peso, String historia) {
		this.imagen = imagen;
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.historia = historia;
		// this.peliculas = new ArrayList<>();
	}

//	 public void setPeli(Pelicula pelicula){
//	        peliculas.add(pelicula);
//	    }
}
