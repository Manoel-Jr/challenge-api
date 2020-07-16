package br.com.challenge.api.service;

import java.util.List;

import br.com.challenge.api.model.Cliente;


public interface ClienteService {

	List<Cliente> listarTodosClientes();
	
	Cliente buscarPorId(Long id);
	
    void  deletar(Long id);
	
	Cliente editar(Long id);
	
	Cliente salvarCliente(Cliente cliente);
	
	
	Cliente atualizarCliente(Cliente cliente, Long id);
	
}