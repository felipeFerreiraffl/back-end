package br.edu.senaisp.servlet;

import java.io.IOException;

import br.edu.senaisp.dao.ClienteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/deletaCliente")
public class DeletaCliente extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		ClienteDAO dao = new ClienteDAO();
		dao.deletar(id);
		
		resp.sendRedirect("/Av1_1Web/listaCliente");
	}
}
