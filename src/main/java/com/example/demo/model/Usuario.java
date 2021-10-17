package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "mail")
	private String mail;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	public Usuario() {
	}

	public Usuario(String name, String lastName, String mail, String username, String password) {

		this.name = name;
		this.lastName = lastName;
		this.mail = mail;
		this.username = username;
		this.password = password;
	}
}
