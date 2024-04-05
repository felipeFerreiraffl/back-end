package br.edu.senaisp.model;

import java.util.List;

public class Estado {
	private int id;
	private String uf;
	private String nome;
	private List<Cidade> cidades;
	
	public Estado(String uf, String nome) {
		this.uf = uf;
		this.nome = nome;
	}	
	
	public Estado(int id, String uf, String nome) {
		this.id = id;
		this.uf = uf;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	
	
}
