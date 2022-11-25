package com.f1rst.sistemaLivraria.dtos;

import org.modelmapper.ModelMapper;

import com.f1rst.sistemaLivraria.entities.ClientesEntity;
import com.f1rst.sistemaLivraria.entities.ProdutosEntity;
import com.f1rst.sistemaLivraria.entities.VendasEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VendasDto {
	
	private int idVenda;
	
	private ClientesEntity clientes;
	private ProdutosEntity produtos;

	public VendasEntity toEntity() {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, VendasEntity.class);
	}
}
