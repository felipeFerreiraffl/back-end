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

@WebServlet(urlPatterns = "/listaCliente")
public class ListaCliente extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuilder html = new StringBuilder();
		ClienteDAO dao = new ClienteDAO();
		
		html.append("<!DOCTYPE html>");
		html.append("<html>");
		html.append("<head>");
		html.append("<meta charset='UTF-8'>");
		html.append("<title>Lista de clientes</title>");
		html.append("<body>");
		html.append("<head>");
		html.append("<a href=\"http://localhost:8080/Av1_1Web/listaCliente\"><button>Novo cliente</button></a>");
		
		for (Cliente c : dao.lista()) {
			html.append("<h2> Nome: ").append(c.getNome()).append("</h2>");
			html.append("<h2>Telefone: ").append(c.getTelefone()).append("</h2>");
			html.append("<h2>Rua: ").append(c.getRua()).append("</h2>");
			html.append("<h2>Número: ").append(c.getNr()).append("</h2>");
			html.append("<h2>Bairro: ").append(c.getBairro()).append("</h2>");
			
			html.append("<a href='/Av1_1Web/deletaCliente?id=" + c.getId() + "'>");
			html.append("<button>Excluir</button>");
			html.append("</a>");
			
			html.append("<a href='/Av1_1Web/alteraCliente?id=" + c.getId() + "'>");
			html.append("<button>Alterar</button>");
			html.append("</a>");
			
			html.append("<br>");
		}
		
		html.append("</body>");
		html.append("</html>");
		
		PrintWriter pw = resp.getWriter();
		pw.print(html.toString());
	}
}
