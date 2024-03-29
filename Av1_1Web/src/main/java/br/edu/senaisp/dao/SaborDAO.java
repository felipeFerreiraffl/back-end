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

	// Variável para selecionar os valores pelo ID
	private final String MYSQLSELECT_ID = 
	"SELECT id, nome, descricao, preco FROM sabores WHERE id = ?";		
	
	// Variável para deletar os valores
	private final String MYSQLDELETE = "DELETE FROM sabores\r\n"
			+ "	WHERE id = ?;";
	
	// Variável para atualizar os valores
	private final String MYSQLUPDATE = "UPDATE sabores\r\n"
			+ " SET nome = ?, descricao = ?, preco = ? WHERE id = ?";
	
	public void novo(Sabor sab) {
		try {
			Connection con = DAO.conexao();
			
			if (!con.isClosed()) {
				// Bibloteca para conseguir ir até o banco de dados
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
				
				// Transforma os objetos em tabela
				ResultSet rs = ps.executeQuery(); // Executa com id igual
				
				
				
				// Memória nula temporária
				Sabor tmp = null;
				// Loop para ver a próxima linha, enquanto ela existir
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
	
	public Sabor buscaPorId(int id) {
		Sabor sabor = null; 
		
		try {
			Connection con = DAO.conexao();
			
            if (!con.isClosed()) {
            	PreparedStatement ps = con.prepareStatement(MYSQLSELECT_ID);
            	ps.setInt(1, id);
            	
            	ResultSet rs = ps.executeQuery();
            	
            	if (rs.next()) {
            		
            		sabor = new Sabor();
            		sabor.setId( rs.getInt("id") );
            		sabor.setNome(rs.getString("nome") );
            		sabor.setDescricao(rs.getString("descricao"));
            		sabor.setPreco(rs.getFloat("preco"));
               	}
            	
            	con.close();
            	
            }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return sabor;
	}
	
	public void deletar(int id) {
		try {
			Connection con = DAO.conexao();
			
			if (!con.isClosed()) {
				PreparedStatement ps = con.prepareStatement(MYSQLDELETE);
				ps.setInt(1, id);
				
				ps.execute();
				
				System.out.println("Item deletado com sucesso!");
				
				con.close();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void atualizar(Sabor sab) {
		try {
			Connection con = DAO.conexao();
			
			if (!con.isClosed()) {
				PreparedStatement ps = con.prepareStatement(MYSQLUPDATE);
				ps.setString(1, sab.getNome());
				ps.setString(2, sab.getDescricao());
				ps.setFloat(3, sab.getPreco());
				
				ps.setInt(4, sab.getId());
				
				ps.execute();
				
				System.out.println("Item atualizado com sucesso!");
				
				con.close();
				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
	
}
