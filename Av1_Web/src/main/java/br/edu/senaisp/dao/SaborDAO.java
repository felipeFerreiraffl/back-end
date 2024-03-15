package br.edu.senaisp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.senaisp.model.Sabor;

public class SaborDAO {
	// Variável que guarda a inserção dos valores
	private final String MYSQLINSERT = "INSERT INTO sabores (nome, descricao, preco)\r\n"
			+ "	VALUES (? , ?, ?);";
	
	// Variável para selecionar os valores
	private final String MYSQLSELECT = "SELECT id, nome, descricao, preco FROM sabores;";
	
	public void novo(Sabor sab) {
		try {
			Connection con = DAO.conexao();
			
			if (!con.isClosed()) {
				// Bibloteca para ler o código de inserção
				PreparedStatement ps = con.prepareStatement(MYSQLINSERT);
				// Coloca os parâmetros baseados na página de cadastro
				ps.setString(1, sab.getNome());
				ps.setString(2, sab.getDescricao());
				ps.setFloat(3, sab.getPreco());
				
				ps.execute();
				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
	
	public List<Sabor> lista() {
		// Criação de lista para printar na tela
		List<Sabor> sabores = new ArrayList<Sabor>();
		
		try {
			Connection con = DAO.conexao();
			
			if (!con.isClosed()) {
				PreparedStatement ps = con.prepareStatement(MYSQLSELECT);
				
				// Transforma a tabela em objeto
				ResultSet rs = ps.executeQuery(); // Executa com id igual
				
				
				
				// Memória nula temporária
				Sabor tmp = null;
				// Loop para ver a próxima coluna, enquanto ela existir
				while (rs.next()) {
					tmp = new Sabor();
					tmp.setId(rs.getInt("id"));
					tmp.setNome(rs.getString("nome"));
					tmp.setDescricao(rs.getString("descricao"));
					tmp.setPreco(rs.getFloat("preco"));
					
					// Adiciona na lista
					sabores.add(tmp);
				}
				
				// Fecha a conexão
				con.close();
				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		
		return sabores;
		
	}
	
}
