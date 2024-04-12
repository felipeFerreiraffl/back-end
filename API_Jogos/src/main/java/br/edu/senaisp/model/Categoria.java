package br.edu.senaisp.model;

import java.util.List;

public class Categoria {
	private Integer id;
	private String nome;
	private List<Jogo> jogos;
	
	public Categoria(String nome) {
		this.nome = nome;
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
	public List<Jogo> getJogos() {
		return jogos;
	}
	public void setJogos(List<Jogo> jogo) {
		this.jogos = jogo;
	}
	
}
