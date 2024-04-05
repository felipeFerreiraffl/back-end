package br.edu.senaisp.controller;

import java.io.IOException;

import br.edu.senaisp.dao.EstadoDAO;
import br.edu.senaisp.model.Cidade;
import br.edu.senaisp.model.Estado;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/estado")
public class EstadoController extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String uf = req.getParameter("uf");
		
		Estado estado = new Estado(-1, uf, nome);
		Cidade cidade = new Cidade("Salvador");
		Cidade cidade2 = new Cidade("Juazeiro");
		
		estado.getCidades().add(cidade);
		estado.getCidades().add(cidade2);
		
		EstadoDAO dao = new EstadoDAO();
		int id = dao.novoCompleto(estado);
		
		resp.getWriter().append(String.valueOf(id));
	}

}
