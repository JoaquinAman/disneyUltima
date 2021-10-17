package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioDto {
	private String name;
	private String lastName;
	private String mail;
	private String username;
	private String password;
}
