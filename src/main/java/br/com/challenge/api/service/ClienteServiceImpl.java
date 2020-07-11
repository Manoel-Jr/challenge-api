package br.com.challenge.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
		if(cli == null) {
			throw new ClienteNotExistException("Cliente não Encontrado!");
		}
		return cli.get();
	}

	@Override
	public void deletar(Long id) {
		if(id == null) {
			throw new  ClienteNotExistException("Não foi possivel Excluir Cliente com Id: " + id);
		}
		repository.deleteById(id);
	}

	@Override
	public Cliente editar(Long id) {
		Cliente clienteSalvo = buscarPorId(id);
		return repository.save(clienteSalvo);
	}

	@Override
	public List<Cliente> listarTodosClientes() {
		List<Cliente> clientes = this.repository.findAll();
		return clientes;
	}

	@Override
	public Cliente salvarCliente(Cliente cliente) {
		Cliente novoCliente = repository.save(cliente);
		return novoCliente;
	}

}
