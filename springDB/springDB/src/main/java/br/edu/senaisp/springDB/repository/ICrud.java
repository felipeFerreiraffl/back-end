package br.edu.senaisp.springDB.repository;

import java.util.List;

import br.edu.senaisp.springDB.model.Banda;

public interface ICrud {
	public List<Banda> lista();
	public Banda buscaPorId(int id);
	public Integer altera(Banda banda, int id);
	public Integer insere(Banda banda);
	public boolean exclui(int id);
	
}
