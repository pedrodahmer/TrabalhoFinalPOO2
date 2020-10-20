package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.Projeto;
import modelo.Usuario;

public class ProjetoDAO {
	
	private Connection con = null;
	
	public ProjetoDAO() {};
	
	public boolean cadastrarProjeto(Projeto p, InscricaoDAO i) {
		
		ConexaoMySQL.abrirConexao();
		con = ConexaoMySQL.getCon();
		
		if(con != null) {
			
			String sql = "INSERT INTO projeto (titulo, unidade, grupopesquisa, parecer_cep_ceua, faseprojeto) "
					+ "VALUES (?, ?, ?, ?, ?)";
			
			PreparedStatement prepStmt = null;
			
			try {
				prepStmt = con.prepareStatement(sql);
				
				prepStmt.setString(1, p.getTitulo());
				prepStmt.setString(2, p.getUnidade());
				prepStmt.setString(3, p.getGrupoPesquisa());
				prepStmt.setString(4, p.getParecerCEP_CEUA());
				prepStmt.setString(5, p.getFaseProjeto());
				
				int res = prepStmt.executeUpdate();
				
				if(res == 1) {
					
					int lastInsertedId = i.obterUltimoIdInserido();
					
					String sql2 = "UPDATE inscricao_ic SET id_projeto_fk = LAST_INSERT_ID()"
							+ "WHERE id_inscricao_ic = " + lastInsertedId;
					
					PreparedStatement prepStmt2 = con.prepareStatement(sql2);
					
					prepStmt2.executeUpdate();
					
//					int lastInsertedId = obterUltimoIdInserido();
//					
//					boolean resultado = inscreverProjeto(lastInsertedId);
//					
//					if(resultado) {
//						ConexaoMySQL.fecharConexao();
//						return true;
//					} else {
//						ConexaoMySQL.fecharConexao();
//						return false;
//					}
					
					ConexaoMySQL.fecharConexao();
					return false;

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
		
		String sql = "SELECT * FROM inscricao_ic WHERE id_inscricao_ic = "
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
	
	private boolean inscreverProjeto(int lastInsertedId) {
		
		String sql = "INSERT INTO inscricao_ic (id_projeto_fk) VALUES (?)";
		
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
