package br.edu.senaisp.springDB.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.edu.senaisp.springDB.model.Banda;

@Repository
public class BandaRepository implements ICrud {
	private final String SQLSELECT = "SELECT id, nome, ano_lancamento FROM banda";
	private final String SQLSELECTBYID = "SELECT id, nome, ano_lancamento FROM banda WHERE id = ?";
	private final String SQLINSERT = "INSERT INTO banda (nome, ano_lancamento) VALUES (?, ?)";
	private final String SQLUPDATE = "UPDATE banda SET nome = ?, ano_lancamento = ? WHERE id = ?";
	private final String SQLDELETE = "DELETE FROM banda WHERE id = ?";
	
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
		// Criação de vetor para os valores do MySQL
		Object[] param = {id};
		
		return jdbcTemplate.queryForObject(SQLSELECTBYID, param, (rs, rowNum) -> {
			return new Banda(rs.getInt("id"), rs.getString("nome"), rs.getInt("ano_lancamento"));
		});
	}

	@Override
	public Integer altera(Banda banda, int id) {
		Object[] param = {banda.getNome(), banda.getAnoLancamento(), id};
		
		return jdbcTemplate.update(SQLUPDATE, param);
	}

	@Override
	public Integer insere(Banda banda) {
		Object[] param = {banda.getNome(), banda.getAnoLancamento()};
		
		return jdbcTemplate.update(SQLINSERT, param);
	}

	@Override
	public boolean exclui(int id) {
		Object[] param = {id};
		
		jdbcTemplate.update(SQLDELETE, param);
		
		return true;
	}

}
