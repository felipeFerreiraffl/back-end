package br.edu.senaisp.servlet;

import java.io.IOException;

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
		
		resp.getWriter().print("<html><h1>Nome: " + nome + "</h1>"
				+ "<h1>Descrição: " + desc + "</h1>"
						+ "<h1>Preço: R$" + preco + "</h1></html>");
	}
}
