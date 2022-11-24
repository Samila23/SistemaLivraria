package com.f1rst.sistemaLivraria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.f1rst.sistemaLivraria.entities.ClientesEntity;

@Repository
public interface ClientesRepository extends JpaRepository<ClientesEntity, Integer>{

}