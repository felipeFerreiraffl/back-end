package br.edu.senaisp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Anotação: separação do arquivo
@WebServlet(urlPatterns = "/olamundo")
public class OlaMundo extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter html = res.getWriter();
		html.println("<html>");
		html.println("<body>");
		html.println("<h1> Olá mundo</h1>");
		html.println("</body>");
		html.println("</html>");
		
	}
}
