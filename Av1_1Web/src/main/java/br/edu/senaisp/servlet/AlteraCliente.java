package br.edu.senaisp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import br.edu.senaisp.dao.ClienteDAO;
import br.edu.senaisp.model.Cliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/alteraCliente")
public class AlteraCliente extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		ClienteDAO dao = new ClienteDAO();
		Cliente cli = dao.buscaPorId(id);
		
		StringBuffer html = new StringBuffer();
		html.append("<!DOCTYPE html>");
		html.append("<html>");
		html.append("<head>");
		html.append("<meta charset='UTF-8'>");
		html.append("<title>Cadastro</title>");
		html.append("</head>");
		html.append("<body>");
		html.append("<form action='/Av1_1Web/alteraCliente' method='POST'>");
		html.append("<h1>Cadastro de clientes</h1>");
		
		html.append("<input type='hidden' name='id' value='" + cli.getId() + "'>");
		html.append("<br>");
		
		html.append("<label for='nome'>Nome:</label>");
		html.append("<input type='text' name='nome' value='" + cli.getNome() + "'>");
		html.append("<br>");
				
		html.append("<label for=\"telefone\">Telefone:</label>");
		html.append("<input type='text' name='telefone' value='" + cli.getTelefone() + "'>");
		html.append("<br>");
				
		html.append("<label for=\"rua\">Rua:</label>");
		html.append("<input type='text' name='rua' value='" + cli.getRua() + "'>");
		html.append("<br>");

		html.append("<label for=\"nr\">Número:</label>");
		html.append("<input type='number' name='nr' value='" + cli.getNr() + "'>");
		html.append("<br>");

		html.append("<label for=\"bairro\">Bairro:</label>");
		html.append("<input type='text' name='bairro' value='" + cli.getBairro() + "'>");
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
		String tel  = req.getParameter("telefone");
		String rua = req.getParameter("rua");
		int num = Integer.parseInt(req.getParameter("nr"));
		String bairro = req.getParameter("bairro");
		int id = Integer.parseInt(req.getParameter("id"));
		
		// Criação do objeto Cliente
		Cliente c = new Cliente();
		c.setId(id);
		c.setNome(nome);
		c.setTelefone(tel);
		c.setRua(rua);
		c.setNr(num);
		c.setBairro(bairro);
		
		// Criação do DAO
		ClienteDAO dao = new ClienteDAO();
		dao.atualizar(c);
		
		resp.sendRedirect("/Av1_1Web/listaCliente");
	}
}
