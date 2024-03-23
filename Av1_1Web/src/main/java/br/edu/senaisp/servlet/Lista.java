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

@WebServlet(urlPatterns = "/lista")
public class Lista extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuilder html = new StringBuilder();
		SaborDAO dao = new SaborDAO();
		
		html.append("<!DOCTYPE html>");
		html.append("<html>");
		html.append("<head>");
		html.append("<meta charset='UTF-8'>");
		html.append("<title>Lista de sabores</title>");
		html.append("</head>");
		html.append("<body>");
		html.append("<a href=\"http://localhost:8080/Av1_1Web/cadastro.html\"><button>Novo sabor</button></a>");
		
		for (Sabor s : dao.lista()) {
			html.append("<h2> Nome: ").append(s.getNome()).append("</h2>");
			html.append("<h2>Descrição: ").append(s.getDescricao()).append("</h2>");
			html.append("<h2>Preço: R$").append(s.getPreco()).append("</h2>");
			html.append("<br>");
			
			html.append("<a href='/Av1_1Web/deletaSabor?id=" + s.getId() + "'>");
			html.append("<button>Excluir</button>");
			html.append("</a>");
			
			html.append("<a href='/Av1_1Web/alteraSabor?id=" + s.getId() + "'>");
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
