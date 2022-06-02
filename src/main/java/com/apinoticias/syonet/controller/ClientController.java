package com.apinoticias.syonet.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.apinoticias.syonet.dto.ClientDTO;
import com.apinoticias.syonet.services.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {

	

	@Autowired
	private ClientService service;
	
	
	
	@PostMapping("/register")
	public ResponseEntity<ClientDTO> insert(@RequestBody ClientDTO dto) {
		dto = service.register(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@GetMapping("/fetchClient/{id}")
	public ResponseEntity<ClientDTO> findClient(@PathVariable Long id) {
		ClientDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PutMapping("/updateClient/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable Long id, @RequestBody ClientDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}	
	
	@DeleteMapping("/deleteClient/{id}")
	public ResponseEntity<ClientDTO> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
