package br.edu.senaisp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	protected static Connection conexao() throws SQLException, ClassNotFoundException {
		String dbDriver = "com.mysql.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/";

		String dbName = "locadora_jogos";
		String dbUsername = "root";
		String dbPassword = "root";

		Class.forName(dbDriver);
		Connection con = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
		return con;
	}
}
