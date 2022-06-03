package com.apinoticias.syonet.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;

import com.apinoticias.syonet.entities.Client;

public class ClientDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@Column(unique = true)
	private String email;
	private String name;
	private LocalDate birthDate;
	
	public ClientDTO() {}

	public ClientDTO(Long id, String email, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.birthDate = birthDate;
	}

	
	public ClientDTO(Client entity) {
		this.id = entity.getId();
		this.email = entity.getEmail();
		this.birthDate = entity.getBirthDate();
		this.name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	
}

