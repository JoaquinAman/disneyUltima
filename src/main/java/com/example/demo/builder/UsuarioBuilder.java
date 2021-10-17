package com.example.demo.builder;

import com.example.demo.dto.UsuarioDto;
import com.example.demo.model.Usuario;

public class UsuarioBuilder {
	private String name;
	private String lastname;
	private String mail;
	private String username;
	private String password;

	public UsuarioBuilder withUsuarioDto(UsuarioDto usuarioDto) {
		this.name = usuarioDto.getName();
		this.lastname = usuarioDto.getLastName();
		this.mail = usuarioDto.getMail();
		this.username = usuarioDto.getUsername();
		this.password = usuarioDto.getPassword();
		return this;
	}

	public Usuario build() {
		return new Usuario(this.name, this.lastname, this.mail, this.username, this.password);
	}
}
