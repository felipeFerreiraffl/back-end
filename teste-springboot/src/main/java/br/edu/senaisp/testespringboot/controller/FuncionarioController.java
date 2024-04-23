package br.edu.senaisp.testespringboot.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.senaisp.testespringboot.model.Funcionario;

@RestController // Indicação de uma classe API Rest
@RequestMapping("/funcionario") // Processamento da urlPattern
// A classe main, com o Maven, se torna nessa estrutura
public class FuncionarioController {
	
	// POST
	@PostMapping
	public String insere(@RequestBody Funcionario f) {
		return "POST";
	}
	
	// GET
	@GetMapping("/busca/{id}") // Declaração do ID na URL
	public String buscaPorId(@PathVariable Integer id) {
		return "GET";
	}
	
	// PUT
	@PutMapping("/altera/{id}")
	public String altera(@RequestBody Funcionario f, @PathVariable Integer id) {
		return "PUT";
	}
	
	// DELETE
	@DeleteMapping("/deleta/{id}")
	public String deleta(@PathVariable Integer id) {
		return "DELETE";
	}
	
}
