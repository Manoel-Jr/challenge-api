package br.com.challenge.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.challenge.api.model.Cliente;
import br.com.challenge.api.service.ClienteService;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService servico;
	
	@ApiOperation(value = "Retorna uma lista de Cliente")
	@GetMapping
	public ResponseEntity<List<Cliente>> listaTodosCliente() {
       List<Cliente> clienteList = servico.listarTodosClientes();
       return ResponseEntity.ok(clienteList);
	}
	
	@ApiOperation(value = "Salva um Cliente")
	@PostMapping
	public ResponseEntity<Cliente> salva(@Valid @RequestBody Cliente cliente){
		Cliente cli = servico.salvarCliente(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(cli);
	}
	
	@ApiOperation(value = "Deleta um cliente pelo ID")
	@DeleteMapping(path = {"/{id}"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleterCliente(@PathVariable Long id) {
		servico.deletar(id);
	}
	
	@ApiOperation(value = "Atualiza dados de um cliente pelo id")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Cliente> atualizarCliente(@PathVariable ("id") Long id, @RequestBody Cliente NovoCliente){
		Cliente clienteAtualizado = servico.atualizarCliente(NovoCliente, id);
		return ResponseEntity.ok().body(clienteAtualizado);
				
	}
	
	public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id) {
		Cliente cl = servico.buscarPorId(id);
		return ResponseEntity.ok(cl);
	}
}