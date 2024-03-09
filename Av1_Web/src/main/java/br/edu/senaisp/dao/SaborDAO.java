package br.edu.senaisp.dao;

import java.sql.Connection;

import br.edu.senaisp.model.Sabor;

public class SaborDAO {
	public void novo(Sabor sab) {
		try {
			Connection con = DAO.conexao();
			
			// Verifica se está fechado ou não
			System.out.println(con.isClosed());
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}
