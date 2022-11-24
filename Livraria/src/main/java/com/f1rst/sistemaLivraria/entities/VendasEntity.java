package com.f1rst.sistemaLivraria.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.f1rst.sistemaLivraria.dtos.VendasDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="vendas") 
public class VendasEntity {
	@Id
	private int idVenda;
	private int qtdProduto;
	private float valorTotal;

	//Cliente e vendas
	@ManyToOne						 
	@JoinColumn(name = "id_clientes") 
	private ClientesEntity clientes;
	
	//Produto e vendas
	@ManyToOne						 
	@JoinColumn(name = "id_produtos") 
	private ProdutosEntity produtos;
	
	public VendasDto toDto() {
		ModelMapper mapper = new ModelMapper();
		VendasDto dto = mapper.map(this, VendasDto.class);
		return dto;
	}
}
