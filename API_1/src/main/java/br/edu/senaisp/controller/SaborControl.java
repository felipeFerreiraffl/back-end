package br.edu.senaisp.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.sound.midi.SysexMessage;

import com.google.gson.Gson;

import br.edu.senaisp.dao.SaborDAO;
import br.edu.senaisp.model.Sabor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/sabor")
public class SaborControl extends HttpServlet {
	// API Rest - Verbo http
		/* 
		 * GET: listar
		 * POST: inserir
		 * PUT: alterar
		 * DELETE: excluir
		 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SaborDAO dao = new SaborDAO();
		List<Sabor> sabores = dao.lista();
		
		String json = "";
		try {
			// Biblioteca JSON do google
			Gson gson = new Gson();
			
			// Trazendo o conteúdo json para texto
			json = gson.toJson(sabores);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		resp.getWriter().append(json);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader br = req.getReader();
		
		String json = "";
		String linha = "";
		
		// Loop para ler as linhas do código
		while ((linha = br.readLine()) != null) {
			json += linha;
		}
		
		// Inserção de novos itens
		Gson gson = new Gson();
		Sabor sabor = gson.fromJson(json, Sabor.class);
		SaborDAO dao = new SaborDAO();
		dao.novo(sabor);
		
		resp.getWriter().append("Item inserido com sucesso!");
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().append("PUT");
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().append("DELETE");
	}
}
