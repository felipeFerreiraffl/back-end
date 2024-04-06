package br.edu.senaisp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.senaisp.model.Cidade;
import br.edu.senaisp.model.Estado;

public class EstadoDAO {
	private final String SQLINSERT = "INSERT INTO estado (nome, uf) VALUES(?, ?)";

	public int novo(Estado estado) {
		int id = 0;
		try {
			Connection con = DAO.conexao();

			if (!con.isClosed()) {
				PreparedStatement ps = con.prepareStatement(SQLINSERT, Statement.RETURN_GENERATED_KEYS);

				ps.setString(1, estado.nome);
				ps.setString(2, estado.uf);

				ps.execute();

				ResultSet rs = ps.getGeneratedKeys();
				rs.next();
				id = rs.getInt(1);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return id;
		
	}
	
	public int novoCompleto(Estado estado) {
		int id = 0;
		Connection con = null;
		try {
			con = DAO.conexao();
			
			con.setAutoCommit(false);
			if (!con.isClosed()) {
				PreparedStatement ps = con.prepareStatement(SQLINSERT, Statement.RETURN_GENERATED_KEYS);

				ps.setString(1, estado.nome);
				ps.setString(2, estado.uf);

				ps.execute();

				ResultSet rs = ps.getGeneratedKeys();
				rs.next();
				id = rs.getInt(1);
				
				id = estado.id;
				
				// Criação de cidades a partir do estado
				CidadeDAO cDAO = new CidadeDAO();
				for (Cidade cidade : estado.cidades) {
					cidade.estado = estado; // Pegará o estado que a cidade criada é designada
					cDAO.novo(cidade, con);
				}
				
				con.commit();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return id;
		
	}
}
