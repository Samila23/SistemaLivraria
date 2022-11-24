package com.f1rst.sistemaLivraria.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.f1rst.sistemaLivraria.dtos.ProdutosDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="PRODUTOS") 
@Entity
public class ProdutosEntity {
	@Id					
	private Integer idProduto;
	private String nome;
	private Double preco;
	private Integer quantidadeProduto;
	private String descricaoProduto;
	
	//Produto e Venda
	@JsonIgnore
	@OneToMany(mappedBy = "produtos") 
	List<VendasEntity> vendas;

	public ProdutosDto toDto() {
		ModelMapper mapper = new ModelMapper();
		ProdutosDto dto = mapper.map(this, ProdutosDto.class);
		return dto;
	}
}
