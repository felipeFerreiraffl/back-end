package br.edu.senaisp.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

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
public class ClienteControl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ClienteDAO dao = new ClienteDAO();
		List<Cliente> cliente = dao.lista();
		
		// Arquivo formatado e transforma objeto em texto e vice-versa
		String json = "";
		try {
			// Biblioteca JSON do google
			Gson gson = new Gson();
			// Trazendo o conteúdo json para texto
			json = gson.toJson(cliente);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		resp.getWriter().append("Tá na mão, patrão \n" + json);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ClienteDAO dao = new ClienteDAO();
		
		BufferedReader br = req.getReader();
		
		String json = "";
		String linha = "";
		
		// Loop para ler as linhas do código
		while ((linha = br.readLine()) != null) {
			json += linha;
		}
		
		// Inserção de novos itens
		Gson gson = new Gson();
		Cliente cliente = gson.fromJson(json, Cliente.class);
		dao.novo(cliente);
		
		resp.getWriter().append("Funcionou, bebê!");
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ClienteDAO dao = new ClienteDAO();
		
		String idCli = req.getParameter("id");
		int id = Integer.parseInt(idCli);
		
		BufferedReader br = req.getReader();
		
		String json = "";
		String linha = "";
		
		// Loop para ler as linhas do código
		while ((linha = br.readLine()) != null) {
			json += linha;
		}
		
		// Inserção de novos itens
		Gson gson = new Gson();
		Cliente cliente = gson.fromJson(json, Cliente.class);
		cliente.setId(id);
		dao.atualizar(cliente);
		
		resp.getWriter().append("Funcionou, bebê!");
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ClienteDAO dao = new ClienteDAO();
		
		String idCli = req.getParameter("id");
		int id = Integer.parseInt(idCli);
		
		dao.deletar(id);
		
		resp.getWriter().append("Deletado, man");
	}
}
