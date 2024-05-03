package br.edu.senaisp.springDB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.senaisp.springDB.model.Banda;
import br.edu.senaisp.springDB.repository.BandaRepository;

// Criação de classe Rest
@RestController
@RequestMapping("/banda")
public class BandaController {
	
	@Autowired
	BandaRepository rep;
	
	@GetMapping
	public String listaBandas() {		
		String tmp = "";
		for (Banda banda : rep.lista()) {
			tmp += banda.getNome();
		}
		
		return tmp;

	}
	
	@GetMapping("/{id}")
	public String buscaPorId(@PathVariable int id) {
		return rep.buscaPorId(id).getNome();
	}
	
	@PutMapping("/{id}")
	public String alteraBanda(@RequestBody Banda banda ,@PathVariable int id) {
		return String.valueOf(rep.altera(banda, id));
	}
	
	@PostMapping
	public String insereBanda(@RequestBody Banda banda) {
		return String.valueOf(rep.insere(banda));
	}
	
	@DeleteMapping("/{id}")
	public String deletaBanda(@PathVariable int id) {
		return String.valueOf(rep.exclui(id));
	}
	
}
