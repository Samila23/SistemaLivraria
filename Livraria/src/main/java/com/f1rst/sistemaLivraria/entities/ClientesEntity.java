package com.f1rst.sistemaLivraria.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.f1rst.sistemaLivraria.dtos.ClientesDto;
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
@Table(name="clientes") 
public class ClientesEntity  {
	@Id
	private int idCliente;
	private String nome;
	private String rg;
	private String cpf;
	private int idade;
	
	@JsonIgnore
	@OneToMany(mappedBy = "clientes") 			
	private List<VendasEntity> vendas;
	
	public ClientesDto toDto() {
		ModelMapper mapper = new ModelMapper();
		ClientesDto dto = mapper.map(this, ClientesDto.class);
		return dto;
	}

}
