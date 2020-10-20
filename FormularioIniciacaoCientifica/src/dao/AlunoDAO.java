package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Aluno;
import modelo.Inscricao;

public class AlunoDAO {
	
	private Connection con = null;
	
	public AlunoDAO() {}
	
	public boolean cadastrarAluno(Aluno a, InscricaoDAO i) {
		
		ConexaoMySQL.abrirConexao();
		con = ConexaoMySQL.getCon();
		
		if(con != null) {
			
			String sql = "INSERT INTO aluno(nome, email, cpf, rg, curso, instituicao, serie,"
					+ "horas_semanas, plano_trabalho, copia_rg_cpf) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement prepStmt = null;
			
			try {
				prepStmt = con.prepareStatement(sql);
				
				prepStmt.setString(1, a.getNome());
				prepStmt.setString(2, a.getEmail());
				prepStmt.setString(3, a.getCpf());
				prepStmt.setString(4, a.getRg());
				prepStmt.setString(5, a.getCurso());
				prepStmt.setString(6, a.getInstituicao());
				prepStmt.setString(7, a.getSerie());
				prepStmt.setInt(8, a.getHorasSemanais());
				prepStmt.setString(9, a.getPlanoTrabalho());
				prepStmt.setString(10, a.getCopiaDocumento());
				
				int res = prepStmt.executeUpdate();
				
				if(res == 1) {
					
//					int lastInsertedId = obterUltimoIdInserido();
//					
//					boolean resultado = inscreverAluno(lastInsertedId);
//					
//					if(resultado) {
//						ConexaoMySQL.fecharConexao();
//						return true;
//					} else {
//						ConexaoMySQL.fecharConexao();
//						return false;
//					}
					
					String sql2 = "INSERT INTO inscricao_ic (id_aluno_fk) VALUES (LAST_INSERT_ID())";
					
					PreparedStatement prepStmt2 = con.prepareStatement(sql2);
					
					prepStmt2.executeUpdate();
					
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
		
		String sql = "SELECT * FROM aluno WHERE id_aluno ="
				+ "(SELECT max(id_aluno) FROM aluno)";
		
		try {
			
			PreparedStatement prepStmt = con.prepareStatement(sql);
			
			ResultSet rs = prepStmt.executeQuery();
			
			if(rs.next()) {
				lastInsertedId = rs.getInt("id_aluno");
				/*i.setId_aluno(lastInsertedId);
				resultId = i.getId_aluno();*/
			}
			
			return lastInsertedId;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return lastInsertedId;
	}
	
	private boolean inscreverAluno(int lastInsertedId) {
		
		String sql = "INSERT INTO inscricao_ic (id_aluno_fk) VALUES (?)";
		
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