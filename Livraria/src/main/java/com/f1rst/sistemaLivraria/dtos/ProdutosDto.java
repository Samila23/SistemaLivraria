package com.f1rst.sistemaLivraria.dtos;

import org.modelmapper.ModelMapper;

import com.f1rst.sistemaLivraria.entities.ProdutosEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutosDto {
	
	private Integer idProduto;
	private String nome;
	private Double preco;
	private Integer quantidadeProduto;
	private String descricaoProduto;
	
	public ProdutosEntity toEntity() {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, ProdutosEntity.class);
	}
}
