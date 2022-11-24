package com.f1rst.sistemaLivraria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.f1rst.sistemaLivraria.entities.ClientesEntity;
import com.f1rst.sistemaLivraria.entities.EstoqueEntity;
import com.f1rst.sistemaLivraria.entities.ProdutosEntity;
import com.f1rst.sistemaLivraria.entities.VendasEntity;
import com.f1rst.sistemaLivraria.repositories.ClientesRepository;
import com.f1rst.sistemaLivraria.repositories.ProdutosRepository;
import com.f1rst.sistemaLivraria.repositories.VendasRepository;
import com.f1rst.sistemaLivraria.services.EstoqueService;

@SpringBootApplication
public class SistemaLivrariaApplication implements CommandLineRunner{
	@Autowired
	ClientesRepository clientesRepository;
	
	@Autowired
	ProdutosRepository produtosRepository; 
	
	@Autowired
	EstoqueService estoqueService;
	
	@Autowired
	VendasRepository vendasRepository; 
	
	public static void main(String[] args) {
		SpringApplication.run(SistemaLivrariaApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
	ClientesEntity 	clientesEntity = new ClientesEntity();
	clientesEntity.setIdCliente(1);
	clientesEntity.setNome("Samila");
	clientesEntity.setRg("0000-1X");
	clientesEntity.setCpf("000.000.000-00");
	clientesEntity.setIdade(18);
	clientesRepository.save(clientesEntity);
	
	ClientesEntity 	clientesEntity2 = new ClientesEntity();
	clientesEntity2.setIdCliente(2);
	clientesEntity2.setNome("Lucas");
	clientesEntity2.setRg("0000-1X");
	clientesEntity2.setCpf("000.000.000-00");
	clientesEntity2.setIdade(30);
	clientesRepository.save(clientesEntity2);
	
	ClientesEntity 	clientesEntity3 = new ClientesEntity();
	clientesEntity3.setIdCliente(3);
	clientesEntity3.setNome("Camila");
	clientesEntity3.setRg("0000-1X");
	clientesEntity3.setCpf("000.000.000-00");
	clientesEntity3.setIdade(25);
	clientesRepository.save(clientesEntity3);
	
	
//	ProdutosEntity produtosEntity = new ProdutosEntity();
//	produtosEntity.setIdProduto(1);
//	produtosEntity.setNome("Brinquedo");
//	produtosEntity.setPreco(9.99);
//	produtosEntity.setQuantidadeProduto(10);
//	produtosEntity.setDescricaoProduto("Carrinho");
//	produtosRepository.save(produtosEntity);
//	estoqueService.gerenciamentoEstoque(produtosEntity.getIdProduto(), 1);
//	
////	
//	ProdutosEntity produtosEntity2 = new ProdutosEntity();
//	produtosEntity2.setIdProduto(2);
//	produtosEntity2.setNome("Album Musica");
//	produtosEntity2.setPreco(9.99);
//	produtosEntity2.setQuantidadeProduto(10);
//	produtosEntity2.setDescricaoProduto("Branca de Neve");
//	produtosRepository.save(produtosEntity2);
//	estoqueService.gerenciamentoEstoque(produtosEntity.getIdProduto(), 1);
	
	
	}
}
