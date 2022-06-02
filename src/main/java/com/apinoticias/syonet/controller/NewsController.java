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

import com.apinoticias.syonet.dto.NewsDTO;
import com.apinoticias.syonet.services.NewsService;

@RestController
@RequestMapping("/news")
public class NewsController {

	@Autowired
	private NewsService service;

	@PostMapping("/register")
	public ResponseEntity<NewsDTO> createNews(@RequestBody NewsDTO dto) {
		dto = service.register(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<NewsDTO> updateNews(@PathVariable Long id, @RequestBody NewsDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<NewsDTO> deleteNews(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();

	}
	@GetMapping("/fetchNews/{id}")
	public ResponseEntity<NewsDTO> fetchNews(@PathVariable Long id) {
		NewsDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
		
	}
}
