package com.f1rst.sistemaLivraria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.f1rst.sistemaLivraria.dtos.ClientesDto;
import com.f1rst.sistemaLivraria.services.ClientesService;

@RequestMapping("clientes")
@RestController
public class ClientesController {

	@Autowired
	private ClientesService clientesService;
	
	@GetMapping("")
	public ResponseEntity<List<ClientesDto>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(clientesService.getAll());
	} 

}