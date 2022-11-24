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

import com.f1rst.sistemaLivraria.dtos.EstoqueDto;
import com.f1rst.sistemaLivraria.services.EstoqueService;

@RequestMapping("estoque")
@RestController
public class EstoqueController {

	@Autowired
	EstoqueService estoqueService;
	
	@GetMapping("")
	public ResponseEntity<List<EstoqueDto>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(estoqueService.getAll());
	}

}
