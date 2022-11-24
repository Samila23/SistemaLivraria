package com.f1rst.sistemaLivraria.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.modelmapper.ModelMapper;

import com.f1rst.sistemaLivraria.dtos.EstoqueDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EstoqueEntity {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) 	
		private Integer id;
		private Integer idProduto;
		private String nomeProduto;
		private int quantidade = 0;
		private String tipoMovientacao;
		private int quantidadeTotal;

		
	public void contadorTotalProd(int quantidade, int tipoTransacao) {
		if(tipoTransacao == 1) {
			this.quantidadeTotal = quantidadeTotal + quantidade; 
		}
		else this.quantidadeTotal = quantidadeTotal - quantidade; 
	}
	
	public EstoqueDto toDto() {
		ModelMapper mapper = new ModelMapper();
		EstoqueDto dto = mapper.map(this, EstoqueDto.class);
		return dto;
	}
	
}
