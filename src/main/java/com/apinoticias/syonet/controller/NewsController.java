package com.apinoticias.syonet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apinoticias.syonet.services.NewsService;

@RestController
@RequestMapping("/news")
public class NewsController {

	

	@Autowired
	private NewsService service;
}
