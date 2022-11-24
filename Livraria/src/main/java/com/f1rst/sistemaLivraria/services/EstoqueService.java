package com.f1rst.sistemaLivraria.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.f1rst.sistemaLivraria.dtos.EstoqueDto;
import com.f1rst.sistemaLivraria.dtos.ProdutosDto;
import com.f1rst.sistemaLivraria.entities.EstoqueEntity;
import com.f1rst.sistemaLivraria.entities.ProdutosEntity;
import com.f1rst.sistemaLivraria.repositories.EstoqueRepository;
import com.f1rst.sistemaLivraria.repositories.ProdutosRepository;

@Service
public class EstoqueService {
	@Autowired
	private EstoqueRepository estoqueRepository;
	
	@Autowired
	private ProdutosRepository produtosRepository;
	
	public List<EstoqueDto> getAll(){
		List<EstoqueEntity> lista = estoqueRepository.findAll();
		List<EstoqueDto> listaDto = new ArrayList<>();
		
		for(EstoqueEntity estoqueEntity : lista) {
			listaDto.add(estoqueEntity.toDto());
		}
		return listaDto;
	}
	
	public EstoqueDto save(EstoqueEntity estoque) {
		return estoqueRepository.save(estoque).toDto();
	}
	
	public EstoqueDto update(int id, EstoqueEntity estoque) {
		Optional<EstoqueEntity> optional = estoqueRepository.findById(id);

		if (optional.isPresent()) {
			EstoqueEntity estoqueBD = optional.get();
			
			return estoqueRepository.save(estoqueBD).toDto();
		} else {
			return new EstoqueEntity().toDto();
		}
	}
	
	public void gerenciamentoEstoque(int id, int tipoTransacao) {
		Optional<ProdutosEntity> optional = produtosRepository.findById(id);
		EstoqueEntity estoqueEntity = new EstoqueEntity();
		if(optional.isPresent()) {
			if(tipoTransacao == 1) {
				ProdutosEntity produtosBD = optional.get();
				estoqueEntity.setQuantidade(estoqueEntity.getQuantidade() + produtosBD.getQuantidadeProduto());
				estoqueEntity.setTipoMovientacao("1 - Entrada Estoque");
				List<EstoqueEntity> lista = estoqueRepository.findAll();
				for(int i = 0; i < lista.size(); i++) {
					estoqueEntity.contadorTotalProd(estoqueEntity.getQuantidade(), 1);
				}
				estoqueRepository.save(estoqueEntity).toDto();
			}
			else
				if(tipoTransacao == 2) {
					ProdutosEntity produtosBD = optional.get();
					estoqueEntity.setQuantidade(estoqueEntity.getQuantidade() - produtosBD.getQuantidadeProduto());
					estoqueEntity.setTipoMovientacao("2 - Saída Estoque");
					estoqueEntity.contadorTotalProd(estoqueEntity.getQuantidade(), 2);
					estoqueRepository.save(estoqueEntity).toDto();
				}
		}
	}
}
