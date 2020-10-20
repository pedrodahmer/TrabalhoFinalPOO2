package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.Orientador;
import modelo.Projeto;

public class OrientadorDAO {
	
	private Connection con = null;
	
	public OrientadorDAO() {}
	
	public boolean cadastrarOrientador(Orientador o, InscricaoDAO i) {
		
		ConexaoMySQL.abrirConexao();
		con = ConexaoMySQL.getCon();
		
		if(con != null) {
			
			String sql = "INSERT INTO orientador (nome, departamento, email, ramal, celular) "
					+ "VALUES (?, ?, ?, ?, ?)";
			
			PreparedStatement prepStmt = null;
			
			try {
				prepStmt = con.prepareStatement(sql);
				
				prepStmt.setString(1, o.getNome());
				prepStmt.setString(2, o.getDepartamento());
				prepStmt.setString(3, o.getEmail());
				prepStmt.setInt(4, o.getRamal());
				prepStmt.setString(5, o.getTelefoneCelular());
				
				int res = prepStmt.executeUpdate();
				
				if(res == 1) {
					
					int lastInsertedId = i.obterUltimoIdInserido();
					
					String sql2 = "UPDATE inscricao_ic SET id_orientador_fk = LAST_INSERT_ID()"
							+ "WHERE id_inscricao_ic = " + lastInsertedId;
					
					PreparedStatement prepStmt2 = con.prepareStatement(sql2);
					
					prepStmt2.executeUpdate();
					
//					int lastInsertedId = obterUltimoIdInserido();
//					
//					boolean resultado = inscreverOrientador(lastInsertedId);
//					
//					if(resultado) {
//						ConexaoMySQL.fecharConexao();
//						return true;
//					} else {
//						ConexaoMySQL.fecharConexao();
//						return false;
//					}
					
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
	
	private int obterUltimoIdInserido() {
		
		int lastInsertedId = 0;
		
		String sql = "SELECT * FROM inscricao_ic WHERE id_inscricao_ic ="
				+ "(SELECT max(id_inscricao_ic) FROM inscricao_ic)";
		
		try {
			
			PreparedStatement prepStmt = con.prepareStatement(sql);
			
			ResultSet rs = prepStmt.executeQuery();
			
			if(rs.next()) {
				lastInsertedId = rs.getInt("id_inscricao_ic");
				/*i.setId_aluno(lastInsertedId);
				resultId = i.getId_aluno();*/
			}
			
			return lastInsertedId;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return lastInsertedId;
	}
	
	private boolean inscreverOrientador(int lastInsertedId) {
		
		String sql = "INSERT INTO inscricao_ic (id_orientador_fk) VALUES (?)";
		
		try {
			
			PreparedStatement prepStmt = con.prepareStatement(sql);
			
			prepStmt.setInt(1, lastInsertedId);
			
			prepStmt.executeUpdate();
			
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return false;
	}

}
