package br.edu.senaisp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.senaisp.model.Categoria;
import br.edu.senaisp.model.Jogo;

public class CategoriaDAO {
	private final String SQLINSERT = "INSERT INTO categoria (nome) VALUES (?)";
	
	public int novo(Categoria cat) {
		int id = -1;
		
		Connection con = null;
		try {
			con = DAO.conexao();
			
			con.setAutoCommit(false);
			if (!con.isClosed()) {
				PreparedStatement ps = con.prepareStatement(SQLINSERT, Statement.RETURN_GENERATED_KEYS);

				ps.setString(1, cat.getNome());

				ps.execute();

				ResultSet rs = ps.getGeneratedKeys();
				rs.next();
				id = rs.getInt(1);
				
				cat.setId(id);
				
				// Criação de cidades a partir do estado
				JogoDAO jDao = new JogoDAO();
				for (Jogo j : cat.getJogos()) {
					j.setCategoria(cat);
					jDao.novo(j, con);
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
