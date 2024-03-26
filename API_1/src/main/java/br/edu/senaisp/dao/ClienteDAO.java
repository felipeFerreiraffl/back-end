package br.edu.senaisp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.senaisp.model.Cliente;
import br.edu.senaisp.model.Sabor;

public class ClienteDAO {
		// Variável que guarda a inserção dos valores
		private final String MYSQLINSERT = "INSERT INTO cliente (nome, telefone, rua, nr, bairro)\r\n"
				+ "	VALUES (?, ?, ?, ?, ?);";
		
		// Variável para selecionar os valores
		private final String MYSQLSELECT = "SELECT id, nome, telefone, rua, nr, bairro FROM cliente;";
		
		// Variável para selecionar os valores pelo ID
		private final String MYSQLSELECT_ID = "SELECT id, nome, telefone, rua, nr, bairro FROM cliente WHERE id = ?";
		
		// Variável para deletar os valores
		private final String MYSQLDELETE = "DELETE FROM cliente\r\n"
				+ "	WHERE id = ?;";
		
		// Variável para atualizar os valores
		private final String MYSQLUPDATE = "UPDATE cliente\r\n"
				+ " SET nome = ?, telefone = ?, rua = ?, nr = ?, bairro = ? WHERE id = ?";
		
		public void novo(Cliente cli) {
			try {
				Connection con = DAO.conexao();
				
				if (!con.isClosed()) {
					// Bibloteca para conseguir ir até o banco de dados
					PreparedStatement ps = con.prepareStatement(MYSQLINSERT);
					// Coloca os parâmetros baseados na página de cadastro
					ps.setString(1, cli.getNome());
					ps.setString(2, cli.getTelefone());
					ps.setString(3, cli.getRua());
					ps.setInt(4, cli.getNr());
					ps.setString(5, cli.getBairro());
					
					ps.execute();
					
				}
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				
			}
		}
		
		public List<Cliente> lista() {
			// Criação de lista para printar na tela
			List<Cliente> clientes = new ArrayList<Cliente>();
			
			try {
				Connection con = DAO.conexao();
				
				if (!con.isClosed()) {
					PreparedStatement ps = con.prepareStatement(MYSQLSELECT);
					
					// Transforma os objetos em tabela
					ResultSet rs = ps.executeQuery(); // Executa com id igual
					
					
					
					// Memória nula temporária
					Cliente tmp = null;
					// Loop para ver a próxima linha, enquanto ela existir
					while (rs.next()) {
						tmp = new Cliente();
						tmp.setId(rs.getInt("id"));
						tmp.setNome(rs.getString("nome"));
						tmp.setTelefone(rs.getString("telefone"));
						tmp.setRua(rs.getString("rua"));
						tmp.setNr(rs.getInt("nr"));
						tmp.setBairro(rs.getString("bairro"));
						
						// Adiciona na lista
						clientes.add(tmp);
					}
					
					// Fecha a conexão
					con.close();
					
				}
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				
			}
			
			return clientes;
			
		}
		
		public Cliente buscaPorId(int id) {
			Cliente cli = null; 
			
			try {
				Connection con = DAO.conexao();
				
	            if (!con.isClosed()) {
	            	PreparedStatement ps = con.prepareStatement(MYSQLSELECT_ID);
	            	ps.setInt(1, id);
	            	
	            	ResultSet rs = ps.executeQuery();
	            	
	            	if (rs.next()) {
	            		
	            		cli = new Cliente();
	            		cli.setId( rs.getInt("id"));
	            		cli.setNome(rs.getString("nome"));
	            		cli.setTelefone(rs.getString("telefone"));
	            		cli.setRua(rs.getString("rua"));
	            		cli.setNr(rs.getInt("nr"));
	            		cli.setBairro(rs.getString("bairro"));
	               	}
	            	
	            	con.close();
	            	
	            }
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			return cli;
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
		
		public void atualizar(Cliente cli) {
			try {
				Connection con = DAO.conexao();
				
				if (!con.isClosed()) {
					PreparedStatement ps = con.prepareStatement(MYSQLUPDATE);
					ps.setString(1, cli.getNome());
					ps.setString(2, cli.getTelefone());
					ps.setString(3, cli.getRua());
					ps.setInt(4, cli.getNr());
					ps.setString(5, cli.getBairro());
					
					ps.setInt(6, cli.getId());
					
					ps.execute();
					
					System.out.println("Item atualizado com sucesso!");
					
					con.close();
					
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				
			}
		}
}
