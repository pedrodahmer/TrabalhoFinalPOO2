package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Usuario;

public class UsuarioDAO {
	
	private Connection con = null;
	
	public UsuarioDAO() {}
	
	//Verifica se os dados informados pelo usuário são válidos, estando presentes no banco de dados 
	public boolean autenticaUsuario(Usuario u) {
		
		String nome = null;
		
		ConexaoMySQL.abrirConexao();
		con = ConexaoMySQL.getCon();
		
		String sql = "SELECT * FROM usuario WHERE senha = ?";
		
		PreparedStatement prepStmt = null;
		
		try {
			
			prepStmt = con.prepareStatement(sql);
			prepStmt.setString(1, u.getSenha());
			ResultSet res = prepStmt.executeQuery();
			
			while(res.next()) {
				nome = res.getString(1);
			}
			
			// Em caso de não encontrar o registro com a senha informada
			if(nome == null) {
				con.close();
				return false;
			}
				
			con.close();
				
			return true; 
			
		} catch (Exception e2) {
			// TODO: handle exception
			try {
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e2.printStackTrace();
			return false;
		}
		
	}
	
	//Inclui os dados informados pelo usuário no banco de dados, na forma de um novo usuário na tabela
	public boolean cadastraUsuario(Usuario u) {
		
		ConexaoMySQL.abrirConexao();
		con = ConexaoMySQL.getCon();
		
		if(con != null) {
			
			String sql = "INSERT INTO usuario (nome, senha) VALUES (?, ?)";
			
			PreparedStatement prepStmt = null;
			
			try {
				prepStmt = con.prepareStatement(sql);
				
				prepStmt.setString(1, u.getNome());
				prepStmt.setString(2, u.getSenha());
				
				int res = prepStmt.executeUpdate();
				
				if(res == 1) {
					ConexaoMySQL.fecharConexao();
					return true;
				} else {
					ConexaoMySQL.fecharConexao();
					return false;
				}
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
				return false;
			}
		}
		
		return false;
	}

	//Realiza o UPDATE do campo senha da table aluno
	public boolean atualizarSenha(String novaSenha, String nomeUsuario) {
		
		ConexaoMySQL.abrirConexao();
		con = ConexaoMySQL.getCon();
		
		if(con != null) {
			PreparedStatement prepStmt = null;
			
			String sql = "UPDATE usuario SET senha = ? WHERE nome LIKE ?";
			
			try {
				prepStmt = con.prepareStatement(sql);
				
				prepStmt.setString(1, novaSenha);
				prepStmt.setString(2, nomeUsuario);
				
				int result = prepStmt.executeUpdate();
				
				if(result == 1) {
					ConexaoMySQL.fecharConexao();
					return true;
				} else {
					ConexaoMySQL.fecharConexao();
					return false;
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
				return false;
			}
		}
		
		return false;
	}
	
}
