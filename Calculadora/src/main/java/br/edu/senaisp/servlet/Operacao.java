package br.edu.senaisp.servlet;

import java.io.IOException;

import br.edu.senaisp.util.Eoperacao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/calc")
public class Operacao extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String opera = req.getParameter("opera");
		int v1 = Integer.parseInt(req.getParameter("v1"));
		int v2 = Integer.parseInt(req.getParameter("v2"));
		
		int resul = 0;
		
		if (opera.equalsIgnoreCase(Eoperacao.soma.toString())) {
			resul = v1 + v2;
		} else {
			resul = v1 - v2;
		}
		
		resp.getWriter().print("<html><h1>Resultado: " + resul + "</h1></html>");
		
		
	}
}
