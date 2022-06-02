package com.apinoticias.syonet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apinoticias.syonet.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
