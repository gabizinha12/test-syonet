package com.apinoticias.syonet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apinoticias.syonet.dto.NewsDTO;
import com.apinoticias.syonet.entities.News;
import com.apinoticias.syonet.repositories.NewsRepository;

@Service
public class NewsService {

	@Autowired
	private final NewsRepository newsRepository;

	public NewsService(NewsRepository newsRepository) {
		this.newsRepository = newsRepository;
	}
	
	@Transactional
	public NewsDTO register(NewsDTO dto) {
		News news = new News();
		copyDtoToEntity(dto, news);
		news = newsRepository.save(news);
		return new NewsDTO(news);
	}
	
	@Transactional
	public NewsDTO update(Long id, NewsDTO dto) {
		News news = newsRepository.findById(id).get();
		copyDtoToEntity(dto, news);
		news = newsRepository.save(news);
		return new NewsDTO(news);
	}
	
	@Transactional(readOnly = true)
	public NewsDTO findById(Long id) {
		News news = newsRepository.findById(id).get();
		return new NewsDTO(news);
	}
	
	public void delete(Long id) {
		newsRepository.deleteById(id);
	}
	
	
	public void copyDtoToEntity(NewsDTO dto, News entity) {
		entity.setDescription(dto.getDescription());
		entity.setLink(dto.getLink());
		entity.setTitle(dto.getTitle());
	}

}
