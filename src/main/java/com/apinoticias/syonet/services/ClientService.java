package com.apinoticias.syonet.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apinoticias.syonet.dto.ClientDTO;
import com.apinoticias.syonet.entities.Client;
import com.apinoticias.syonet.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private final ClientRepository clientRepository;

	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	@Transactional
	public ClientDTO register(ClientDTO dto) {
		Client object = new Client();
		copyDTOToEntity(dto, object);
		object = clientRepository.save(object);
		return new ClientDTO(object);
	}
	
	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		Optional<Client> existingId = clientRepository.findById(id);
	    Client entity =   existingId.get();
	    copyDTOToEntity(dto, entity);
	    entity = clientRepository.save(entity);
	    return new ClientDTO(entity);
	}
	
	@Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
	  Optional<Client> object = clientRepository.findById(id);
	  Client entity = object.get();
	  return new ClientDTO(entity);
  }
	
	public void delete(Long id) {
		clientRepository.deleteById(id);
	}
	
	public void copyDTOToEntity(ClientDTO dto, Client entity) {
		entity.setBirthDate(dto.getBirthDate());
		entity.setEmail(dto.getEmail());
		entity.setName(dto.getName());
	}
	
}
