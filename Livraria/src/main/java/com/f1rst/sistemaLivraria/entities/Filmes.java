package com.f1rst.sistemaLivraria.entities;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Filmes {

	private String estudio;
	private String diretores;
	private String genero;
	private String produtores;
	
}
