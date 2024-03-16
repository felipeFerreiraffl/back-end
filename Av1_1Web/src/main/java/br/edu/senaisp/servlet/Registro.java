package br.edu.senaisp.servlet;

import java.io.IOException;

import br.edu.senaisp.dao.SaborDAO;
import br.edu.senaisp.model.Sabor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/inicio")
public class Registro extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		
		resp.getWriter().print("<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<meta charset='UTF-8'>"
				+ "<title>Início</title>"
				+ "<html>"
				+ "<h1>Nome: " + nome + "</h1>"
				+ "<h1>Descrição: " + desc + "</h1>"
				+ "<h1>Preço: R$" + preco + "</h1></html>");
	}
}
