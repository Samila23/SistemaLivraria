package com.f1rst.sistemaLivraria.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.f1rst.sistemaLivraria.dtos.VendasDto;
import com.f1rst.sistemaLivraria.entities.VendasEntity;
import com.f1rst.sistemaLivraria.repositories.ClientesRepository;
import com.f1rst.sistemaLivraria.repositories.ProdutosRepository;
import com.f1rst.sistemaLivraria.repositories.VendasRepository;


@Service
public class VendasService {
	@Autowired
	private VendasRepository vendasRepository;

	@Autowired
	private ClientesRepository clientesRepository;
	
	@Autowired
	private ProdutosRepository produtosRepository;

	
	@Autowired
	private EstoqueService estoqueService;
	public List<VendasDto> getAll() {
		List<VendasEntity> lista = vendasRepository.findAll();
		List<VendasDto> listaDto = new ArrayList<>();

		for (VendasEntity vendasEntity : lista) {
			listaDto.add(vendasEntity.toDto());
		}
		return listaDto;
	}

	public VendasDto getOne(int id) {
		Optional<VendasEntity> optional = vendasRepository.findById(id);
		VendasEntity vendas = optional.orElse(new VendasEntity());
		return vendas.toDto();
	}

	public VendasDto save(VendasEntity vendas) {
		clientesRepository.save(vendas.getClientes()).toDto();
		produtosRepository.save(vendas.getProdutos()).toDto();
		estoqueService.gerenciamentoEstoque(vendas.getProdutos().getIdProduto(), 2);
		return vendasRepository.save(vendas).toDto();
	}

	public VendasDto update(int id, VendasEntity novaVendas) {
		Optional<VendasEntity> optional = vendasRepository.findById(id);
		
		if (optional.isPresent()) {
			VendasEntity vendasBD = optional.get();
			vendasBD.setIdVenda(novaVendas.getIdVenda());
			return vendasRepository.save(vendasBD).toDto();

		} else {
			return new VendasEntity().toDto();
		}
	}

	public void delete(int id) {
		vendasRepository.deleteById(id);
	}
}
