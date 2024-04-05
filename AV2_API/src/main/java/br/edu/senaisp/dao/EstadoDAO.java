package br.edu.senaisp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

				ps.setString(1, estado.getNome());
				ps.setString(2, estado.getUf());

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
		try {
			Connection con = DAO.conexao();

			if (!con.isClosed()) {
				PreparedStatement ps = con.prepareStatement(SQLINSERT, Statement.RETURN_GENERATED_KEYS);

				ps.setString(1, estado.getNome());
				ps.setString(2, estado.getUf());

				ps.execute();

				ResultSet rs = ps.getGeneratedKeys();
				rs.next();
				id = rs.getInt(1);
				
				id = estado.getId();
				
				CidadeDAO cDAO = new CidadeDAO();
				for (Cidade cidade : estado.getCidades()) {
					estado = cidade.getEstado();
					cDAO.novo(cidade);
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return id;
		
	}
}
