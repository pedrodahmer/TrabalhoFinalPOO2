package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import modelo.Aluno;

public class AlunoDAO {
	
	private Connection con = null;
	
	public AlunoDAO() {}
	
	public boolean cadastrarAluno(Aluno a) {
		
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
