package com.f1rst.sistemaLivraria.dtos;

import org.modelmapper.ModelMapper;

import com.f1rst.sistemaLivraria.entities.ClientesEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientesDto {

	private int idCliente;
	private String nome;
	private String rg;
	private String cpf;
	private int idade;
	
	public ClientesEntity toEntity() {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, ClientesEntity.class);
	}
}	
