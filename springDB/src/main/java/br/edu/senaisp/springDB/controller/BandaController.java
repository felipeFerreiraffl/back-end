package br.edu.senaisp.springDB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.senaisp.springDB.repository.BandaRepository;

// Criação de classe Rest
@RestController
@RequestMapping("/banda")
public class BandaController {
	
	@Autowired
	BandaRepository rep;
	
	@GetMapping("/lista")
	public String listaBandas() {				
		return rep.lista().get(0).getNome();

	}
	
}
