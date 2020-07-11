package br.com.challenge.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.challenge.api.model.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
