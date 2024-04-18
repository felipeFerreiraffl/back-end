package br.edu.senaisp.model;

import java.sql.Date;

public class Jogo {
	private Integer id;
	private String nome;
	private String plataforma;
	private Date dataDeCriacao;
	private Categoria categoria;
	
	public Jogo(String nome, String plataforma, Date dataDeCriacao) {
		this.nome = nome;
		this.plataforma = plataforma;
		this.dataDeCriacao = dataDeCriacao;
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
	public String getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	public Date getDataDeCriacao() {
		return dataDeCriacao;
	}
	public void setDataDeCriacao(Date dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}
