package br.edu.senaisp.springDB.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.edu.senaisp.springDB.model.Banda;

@Repository
public class BandaRepository implements ICrud {
	private final String SQLSELECT = "SELECT id, nome, ano_lancamento FROM banda";
	private final String SQLINSERT = "INSERT INTO banda (nome, ano_lancamento) VALUES (?, ?)";
	private final String SQLUPDATE = "INSERT INTO banda (nome, ano_lancamento) VALUES (?, ?)";
	private final String SQLDELETE = "INSERT INTO banda (nome, ano_lancamento) VALUES (?, ?)";
	
	// Gerenciador de conexões
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Banda> lista() {
		// (ResultSet, rs.next()) -> {}: lambda
		return jdbcTemplate.query(SQLSELECT, (rs, rowNum) -> {
			return new Banda(rs.getInt("id"), rs.getString("nome"), rs.getInt("ano_lancamento"));
		});
		
	}

	@Override
	public Banda buscaPorId(int id) {
		return null;
	}

	@Override
	public Banda altera(Banda banda, int id) {
		return null;
	}

	@Override
	public Banda insere(Banda banda) {
		int b = jdbcTemplate.update(SQLINSERT, banda.getNome(), banda.getAnoLancamento());
		
		if (b > 0) {
			return banda;			
		} else {
			return null;
		}

	}

	@Override
	public boolean exclui(int id) {
		return false;
	}

}
