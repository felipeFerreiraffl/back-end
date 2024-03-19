package br.edu.senaisp.servlet;

import java.io.IOException;

import br.edu.senaisp.dao.SaborDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/del-sabor")
public class Deleta extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer i = Integer.parseInt(req.getParameter("idDel"));
		
		SaborDAO dao = new SaborDAO();
		dao.deletar(i);
	}

}
