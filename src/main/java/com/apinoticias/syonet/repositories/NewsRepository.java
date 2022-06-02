package com.apinoticias.syonet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apinoticias.syonet.entities.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Long>{

}
