package com.apinoticias.syonet.dto;

import java.io.Serializable;

import com.apinoticias.syonet.entities.News;

public class NewsDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String title;
	private String description;
	private String link;
	
	public NewsDTO() {}

	public NewsDTO(Long id, String title, String description, String link) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.link = link;
	}
	
	public NewsDTO(News entity) {
		this.id = entity.getId();
		this.description = entity.getDescription();
		this.link = entity.getLink();
		this.title = entity.getTitle();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	

}
