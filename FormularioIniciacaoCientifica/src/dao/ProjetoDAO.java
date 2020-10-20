package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import modelo.Projeto;
import modelo.Usuario;

public class ProjetoDAO {
	
	private Connection con = null;
	
	public ProjetoDAO() {};
	
	public boolean cadastrarProjeto(Projeto p) {
		
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
