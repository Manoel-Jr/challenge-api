package br.com.challenge.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.challenge.api.model.Cliente;
import br.com.challenge.api.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService servico;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listaTodosCliente() {
       List<Cliente> clienteList = servico.listarTodosClientes();
       return ResponseEntity.ok(clienteList);
	}
	
	@PostMapping
	public ResponseEntity<Cliente> salva(@Valid @RequestBody Cliente cliente){
		Cliente cli = servico.salvarCliente(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(cli);
	}
	
}