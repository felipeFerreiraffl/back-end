package br.edu.senaisp.servlet;

import java.io.IOException;

import br.edu.senaisp.dao.SaborDAO;
import br.edu.senaisp.model.Sabor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/saborAlt")
public class Altera extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		
		SaborDAO dao = new SaborDAO();
		Sabor sab = dao.buscaPorId(id);
		StringBuffer html = new StringBuffer();
		
		html.append("<!DOCTYPE html>");
		html.append("<html>");
		html.append("<head>");
		html.append("<meta charset='UTF-8'>");
		html.append("<title>Cadastro</title>");
		html.append("</head>");
		html.append("<body>");
		html.append("<form action='/Av1_1Web/saborAlt' method='POST'>");
		html.append("<h1>Cadastro</h1>");
				
		html.append("<label for='idnome'>Nome:</label>");
		html.append("<input type='text' id='idnome' name='nome' value='" + sab.getNome() + "'>");
		html.append("<br>");
				
		html.append("<label for='iddescricao'>Descrição:</label>");
		html.append("<input type='text' id='iddescricao' name='descricao' value='" + sab.getDescricao() + "'>");
		html.append("<br>");
				
		html.append("<label for='idpreco'>Preço:</label>");
		html.append("<input type='number' id='idpreco' name='preco'> value='" + sab.getPreco() + "'>");
		html.append("<br>");
						
		html.append("<button type='submit'>Gravar</button>");
		html.append("</form>");
		html.append("</head>");
		html.append("<body>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String desc  = req.getParameter("descricao");
		float preco = Float.parseFloat(req.getParameter("preco"));
		
		// Criação do objeto Sabor
		Sabor sab = new Sabor();
		sab.setNome(nome);
		sab.setDescricao(desc);
		sab.setPreco(preco);
		
		// Criação do DAO
		SaborDAO dao = new SaborDAO();
		dao.novo(sab);
		
		// Redirecionamento de página
		resp.sendRedirect("/Av1_1Web/lista");
	}
}
