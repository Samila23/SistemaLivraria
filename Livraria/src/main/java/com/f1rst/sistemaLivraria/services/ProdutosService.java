package com.f1rst.sistemaLivraria.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.f1rst.sistemaLivraria.dtos.ProdutosDto;
import com.f1rst.sistemaLivraria.entities.EstoqueEntity;
import com.f1rst.sistemaLivraria.entities.ProdutosEntity;
import com.f1rst.sistemaLivraria.repositories.EstoqueRepository;
import com.f1rst.sistemaLivraria.repositories.ProdutosRepository;

@Service
public class ProdutosService {

	@Autowired
	private ProdutosRepository produtosRepository;
	
	@Autowired
	private EstoqueService estoqueService;
	
	@Autowired
	private EstoqueRepository estoqueRepository;
	
	public List<ProdutosDto> getAll() {
		List<ProdutosEntity> lista = produtosRepository.findAll();
		List<ProdutosDto> listaDTO = new ArrayList<>();
		for (ProdutosEntity produtosEntity : lista) {
			listaDTO.add(produtosEntity.toDto());
		}
		return listaDTO;
	}

	public ProdutosDto getOne(int id) {
		Optional<ProdutosEntity> optional = produtosRepository.findById(id);
		ProdutosEntity produtos = optional.orElse(new ProdutosEntity());
		return produtos.toDto();
	}

	public ProdutosDto update(int id, ProdutosEntity produtos) {
		Optional<ProdutosEntity> optional = produtosRepository.findById(id);

		if (optional.isPresent()) {
			ProdutosEntity produtosBD = optional.get();
			return produtosRepository.save(produtosBD).toDto();
		} else {
			return new ProdutosEntity().toDto();
		}
	}

	public ProdutosDto save(ProdutosEntity produtos) {
		produtosRepository.save(produtos).toDto();
		estoqueService.gerenciamentoEstoque(produtos.getIdProduto(), 1);
		return produtosRepository.save(produtos).toDto();
	}

	public void delete(int id) {
		produtosRepository.deleteById(id);
	}
	

}
