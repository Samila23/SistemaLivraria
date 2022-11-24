package com.f1rst.sistemaLivraria.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.f1rst.sistemaLivraria.dtos.VendasDto;
import com.f1rst.sistemaLivraria.services.VendasService;

@RequestMapping("vendas")
@RestController
public class VendasController {
	@Autowired
	private VendasService vendasService;
	
	@GetMapping("")
	public ResponseEntity<List<VendasDto>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(vendasService.getAll());
	} 
	
	@PostMapping("")
	public ResponseEntity<VendasDto> save(@Valid @RequestBody VendasDto clientes) {
		return ResponseEntity.status(HttpStatus.OK).body(vendasService.save(clientes.toEntity()));
	}

}
