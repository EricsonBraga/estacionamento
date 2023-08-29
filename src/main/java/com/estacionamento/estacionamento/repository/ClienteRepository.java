package com.estacionamento.estacionamento.repository;

import com.estacionamento.estacionamento.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

List<Cliente> findByNome(String nome);

List<Cliente> findByPlacaCarro(String placaCarro);

List<Cliente> findByNomeStartingWith(String nome);

}


