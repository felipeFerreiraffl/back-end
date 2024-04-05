package br.edu.senaisp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import br.edu.senaisp.model.Cidade;

public class CidadeDAO {
	private final String SQLINSERT = "INSERT INTO cidade (nome, id_estado) VALUES(?, ?)";

	public int novo(Cidade cidade) {
		int id = 0;
		try {
			Connection con = DAO.conexao();

			if (!con.isClosed()) {
				PreparedStatement ps = con.prepareStatement(SQLINSERT, Statement.RETURN_GENERATED_KEYS);

				ps.setString(1, cidade.getNome());
				ps.setInt(1, cidade.getEstado().getId());

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
}
