package br.edu.senaisp.springDB.model;

// Definição de classe como uma tabela no MySQL
public class Banda {
	private Integer id;
	private String nome;
	private int anoLancamento;
	
	public Banda(Integer id, String nome, int anoLancamento) {
		this.id = id;
		this.nome = nome;
		this.anoLancamento = anoLancamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	
	
}
