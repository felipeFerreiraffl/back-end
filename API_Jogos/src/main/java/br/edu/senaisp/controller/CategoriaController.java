package br.edu.senaisp.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import br.edu.senaisp.dao.CategoriaDAO;
import br.edu.senaisp.model.Categoria;
import br.edu.senaisp.model.Jogo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/categoria")
public class CategoriaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nome = req.getParameter("nome");
		
		Categoria cat = new Categoria(nome);
		cat.setJogos(new ArrayList<Jogo>());
		
		Jogo j1 = new Jogo();
		j1.setNome("GOD OF WAR 2");
		j1.setPlataforma("PC / PLAYSTATION");
		j1.setDataDeCriacao(new Date(107, 03, 17));
		
		cat.getJogos().add(j1);
		
		CategoriaDAO dao = new CategoriaDAO();
		Integer id = dao.novo(cat);
		
		resp.getWriter().append(String.valueOf(id));
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}

}
