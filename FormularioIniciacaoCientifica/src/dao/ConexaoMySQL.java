package dao;

import java.sql.Connection;
import java.sql.DriverManager;

import dao.ConexaoMySQL;

public class ConexaoMySQL {
	
	private static Connection con;
	private static String status;
	
	public ConexaoMySQL() {
		
	}
	
	public static void abrirConexao() {
		
		String serverName = "localhost";
		String database = "meubanco";
		String url = "jdbc:mysql://" + serverName + ":3306/" + database + "?useTimezone=true&serverTimezone=UTC";
		String userName = "teste";
		String password = "root";
		
		try {
			con = DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		if(con != null) {
			status = "STATUS -----> Conectado com sucesso!";
		} else {
			status = "STATUS -----> N�o foi poss�vel realizar a conex�o";
		}
		
	}
	
	public static boolean fecharConexao() {
		
		try {
			con.close();
			System.out.println("Conex�o encerrada!");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

	}
	
	public static void obterStatusConexao() {
		System.out.println(status);
	}
	
	public static Connection getCon() {
		return con;
	}

	public static void setCon(Connection con) {
		ConexaoMySQL.con = con;
	}

	public static void main(String[] args) {
		
		ConexaoMySQL.abrirConexao();
		ConexaoMySQL.obterStatusConexao();
		ConexaoMySQL.fecharConexao();
		
	}

}
