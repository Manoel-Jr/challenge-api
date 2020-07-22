package br.com.challenge.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.challenge.api.exception.ClienteNotExistException;
import br.com.challenge.api.model.Cliente;
import br.com.challenge.api.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Override
	public Cliente buscarPorId(Long id) {
		Optional<Cliente> cli = repository.findById(id);
		if(cli == null  || !cli.isPresent()) {
			throw new ClienteNotExistException("Cliente não Encontrado!");
		}
		return cli.get();
	}

	@Override
	public void deletar(Long id) {
	
		if(id == null) {
			throw new  EmptyResultDataAccessException(1);
		}
		repository.deleteById(id);
	}

	@Override
	public List<Cliente> listarTodosClientes() {
		List<Cliente> clientes = this.repository.findAll();
		if(clientes.isEmpty()) {
			throw new ClienteNotExistException("Não existe nenhum cliente cadastrado.");
		}
		return clientes;
	}

	@Override
	public Cliente salvarCliente(Cliente cliente) {
		Cliente novoCliente = repository.save(cliente);
		return novoCliente;
	}

	@Override
	public Cliente atualizarCliente(Cliente cliente, Long id) {
		cliente.setId(id);
		Cliente clienteAtualizado = repository.save(cliente);
		return clienteAtualizado;
	}

}
