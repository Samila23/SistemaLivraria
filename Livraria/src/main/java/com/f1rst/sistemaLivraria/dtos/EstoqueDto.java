package com.f1rst.sistemaLivraria.dtos;

import org.modelmapper.ModelMapper;

import com.f1rst.sistemaLivraria.entities.EstoqueEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstoqueDto {
	private Integer idProduto;
	private String nomeProduto;
	private int quantidade = 0;
	private String tipoMovientacao;
	private int quantidadeTotal;
	
	public EstoqueEntity toEntity() {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, EstoqueEntity.class);
	}
}
