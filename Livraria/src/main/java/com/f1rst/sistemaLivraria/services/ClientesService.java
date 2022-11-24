package com.f1rst.sistemaLivraria.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.f1rst.sistemaLivraria.dtos.ClientesDto;
import com.f1rst.sistemaLivraria.entities.ClientesEntity;
import com.f1rst.sistemaLivraria.repositories.ClientesRepository;

@Service
public class ClientesService {

	@Autowired
	private ClientesRepository clientesRepository;
	
	public List<ClientesDto> getAll(){
		List<ClientesEntity> lista = clientesRepository.findAll();
		List<ClientesDto> listaDto = new ArrayList<>();
		
		for(ClientesEntity clientesEntity : lista) {
			listaDto.add(clientesEntity.toDto());
		}
		return listaDto;
	}
	
//	public ClientesDto getOne(int id) {
//		Optional<ClientesEntity> optional = clientesRepository.findById(id);
//		ClientesEntity clientes = optional.orElse(new ClientesEntity());
//		return clientes.toDto();
//	}
//	
	public ClientesDto save(ClientesEntity clientes) {
		return clientesRepository.save(clientes).toDto();
	}
	
	public ClientesDto update(int id, ClientesEntity clientes) {
		Optional<ClientesEntity> optional = clientesRepository.findById(id);
		
		if(optional.isPresent()) {
			ClientesEntity clientesBD = optional.get();
			clientesBD.setIdCliente(clientes.getIdCliente());
			clientesBD.setNome(clientes.getNome());
			clientesBD.setRg(clientes.getRg());
			clientesBD.setCpf(clientes.getCpf());
			clientesBD.setIdade(clientes.getIdade());
			return clientesRepository.save(clientesBD).toDto();
		}
		else {
			return new ClientesEntity().toDto();
		}
	}
	
	public void delete(int id) {
		clientesRepository.deleteById(id);
	}
}	
