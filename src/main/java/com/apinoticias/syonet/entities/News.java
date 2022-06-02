package com.apinoticias.syonet.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_news")
public class News {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
     private String title;
     private String description;
     private String link;
     
     public News() {}
	
     public News(Long id, String title, String description, String link) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.link = link;
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
