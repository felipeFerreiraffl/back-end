package br.edu.senaisp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import br.edu.senaisp.dao.SaborDAO;
import br.edu.senaisp.model.Sabor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/alteraSabor")
public class Altera extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
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
		html.append("<form action='/Av1_1Web/alteraSabor' method='POST'>");
		html.append("<h1>Cadastro de sabores</h1>");
		
		html.append("<input type='hidden' name='id' value='" + sab.getId() + "'>");
		html.append("<br>");
		
		html.append("<label for='nome'>Nome:</label>");
		html.append("<input type='text' name='nome' value='" + sab.getNome() + "'>");
		html.append("<br>");
				
		html.append("<label for='descricao'>Descrição:</label>");
		html.append("<input type='text' name='descricao' value='" + sab.getDescricao() + "'>");
		html.append("<br>");
				
		html.append("<label for='preco'>Preço:</label>");
		html.append("<input type='number' name='preco'> value='" + sab.getPreco() + "'>");
		html.append("<br>");
						
		html.append("<button type='submit'>Gravar</button>");
		html.append("</form>");
		html.append("</head>");
		html.append("<body>");
		
		PrintWriter pw = resp.getWriter();
		pw.print(html.toString());
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String desc  = req.getParameter("descricao");
		float preco = Float.parseFloat(req.getParameter("preco"));
		int id = Integer.parseInt(req.getParameter("id"));
		
		// Criação do objeto Sabor
		Sabor sab = new Sabor();
		sab.setId(id);
		sab.setNome(nome);
		sab.setDescricao(desc);
		sab.setPreco(preco);
		
		// Criação do DAO
		SaborDAO dao = new SaborDAO();
		dao.atualizar(sab);
		
		// Redirecionamento de página
		resp.sendRedirect("/Av1_1Web/lista");
	}
}
