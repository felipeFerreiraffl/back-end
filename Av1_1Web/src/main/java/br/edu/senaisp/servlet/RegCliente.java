package br.edu.senaisp.servlet;

import java.io.IOException;

import br.edu.senaisp.dao.ClienteDAO;
import br.edu.senaisp.dao.SaborDAO;
import br.edu.senaisp.model.Cliente;
import br.edu.senaisp.model.Sabor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/cliente")
public class RegCliente extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nomeCliente");
		String tel  = req.getParameter("telefone");
		String rua = req.getParameter("rua");
		int num = Integer.parseInt(req.getParameter("nr"));
		String bairro = req.getParameter("bairro");
		
		// Criação do objeto Cliente
		Cliente c = new Cliente();
		c.setNome(nome);
		c.setTelefone(tel);
		c.setRua(rua);
		c.setNr(num);
		c.setBairro(bairro);
		
		// Criação do DAO
		ClienteDAO dao = new ClienteDAO();
		dao.novo(c);
		
		resp.getWriter().print("<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<meta charset='UTF-8'>"
				+ "<title>Início</title>"
				+ "<html>"
				+ "<h1>Nome: " + nome + "</h1>"
				+ "<h1>Telefone: " + tel + "</h1>"
				+ "<h1>Rua: " + rua + "</h1>"
				+ "<h1>Número: " + num + "</h1>"
				+ "<h1>Bairro: " + bairro + "</h1>"
				+ "</html>");
	}
}
