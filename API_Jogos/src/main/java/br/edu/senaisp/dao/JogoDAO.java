package br.edu.senaisp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZoneId;

import br.edu.senaisp.model.Jogo;

public class JogoDAO {
	private final String SQLINSERT = "INSERT INTO jogo (nome, plataforma, data_criacao, id_categoria) VALUES (?, ?, ?, ?)";
	
	public int novo(Jogo jogo, Connection con) throws SQLException {
		int id = -1;
			if (!con.isClosed()) {
				PreparedStatement ps = con.prepareStatement(SQLINSERT, Statement.RETURN_GENERATED_KEYS);
				
				ps.setString(1, jogo.getNome());
				ps.setString(2, jogo.getPlataforma());
				ps.setDate(3, jogo.getDataDeCriacao());
				ps.setInt(4, jogo.getCategoria().getId());

				ps.execute();

				ResultSet rs = ps.getGeneratedKeys();
				rs.next();
				id = rs.getInt(1);
			}

		return id;
		
	}
}
