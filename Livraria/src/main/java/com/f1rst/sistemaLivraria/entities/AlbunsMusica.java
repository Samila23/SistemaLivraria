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
public class AlbunsMusica {
	private String musicoBanda;
	private String generoMusica;
	private String selos;
}
