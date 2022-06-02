package com.apinoticias.syonet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public NewsDTO register(NewsDTO dto) {
		News object = new News();
		copyDTOToEntity(dto, object);
		object = newsRepository.save(object);
		return new NewsDTO(object);
	}
	
	public NewsDTO update(Long id, NewsDTO dto) {
		News news = newsRepository.findById(id).get();
		copyDTOToEntity(dto, news);
		news = newsRepository.save(news);
		return new NewsDTO(news);
		
	}
	
	public NewsDTO findById(Long id) {
		News existingNews = newsRepository.findById(id).get();
		return new NewsDTO(existingNews);
	}
	public void delete(Long id) {
		newsRepository.deleteById(id);
	}
	
	public void copyDTOToEntity(NewsDTO dto, News entity) {
		entity.setDescription(dto.getDescription());
		entity.setLink(dto.getLink());
		entity.setTitle(dto.getTitle());
	}
}
