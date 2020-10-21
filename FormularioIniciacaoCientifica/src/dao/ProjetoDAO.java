package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Projeto;

public class ProjetoDAO {
	
	private Connection con = null;
	
	public ProjetoDAO() {};
	
	//Realiza o cadastro de um projeto no banco de dados passando os valores inseridos pelo usuário
	//na tela de informações do projeto, durante o preenchimento do formulário
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
					
					res = prepStmt2.executeUpdate();
					
					if(res == 1) {
						ConexaoMySQL.fecharConexao();
						return true;
					} else {
						ConexaoMySQL.fecharConexao();
						return false;
					}

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
	
	//Exclui um projeto da tabela, usando como parâmetro o id de projeto presente na tabela
	//de inscirção dele, em que seu id é uma chave estrangeira
	public boolean excluirProjeto(int id_projeto) {
		
		ConexaoMySQL.abrirConexao();
		con = ConexaoMySQL.getCon();
		
		if(con != null) {
			
			String exclusao = "DELETE FROM projeto WHERE id_projeto = " + id_projeto;
			
			PreparedStatement prepStmt = null;
			
			try {
				
				prepStmt = con.prepareStatement(exclusao);
				
				int resultado = prepStmt.executeUpdate();
				
				if(resultado == 1) {
					ConexaoMySQL.fecharConexao();
					return true;
				} else {
					ConexaoMySQL.fecharConexao();
					return false;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return false;
	}

}
