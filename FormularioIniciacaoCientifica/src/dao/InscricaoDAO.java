package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Inscricao;

public class InscricaoDAO {
	
	private Connection con = null;
	
	public InscricaoDAO() {}
	
	public int obterUltimoIdInserido() {
		
		ConexaoMySQL.abrirConexao();
		con = ConexaoMySQL.getCon();
		
		int lastInsertedId = 0;
		
		if(con != null) {
			
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
			
		}
		
		return lastInsertedId;
		
	}
	
	public ArrayList<Inscricao> obterInscricoes() {
		
		ConexaoMySQL.abrirConexao();
		con = ConexaoMySQL.getCon();
		
		ArrayList<Inscricao> listaInscricao = new ArrayList<>();
		
		String sql = "SELECT I.id_inscricao_ic, A.nome, P.titulo, O.nome"
				+ " FROM inscricao_ic I"
				+ " INNER JOIN aluno A"
				+ " ON I.id_aluno_fk = A.id_aluno"
				+ " INNER JOIN projeto P"
				+ " ON I.id_projeto_fk = P.id_projeto"
				+ " INNER JOIN orientador O"
				+ " ON I.id_orientador_fk = O.id_orientador";
		
		try {
			PreparedStatement prepStmt = con.prepareStatement(sql);
			
			ResultSet rs = prepStmt.executeQuery();
			
			while(rs.next()) {
				Inscricao inscricao = new Inscricao();
				
				inscricao.setId_inscricao(rs.getInt(1));
				inscricao.setNomeAluno(rs.getString(2));
				inscricao.setTituloProjeto(rs.getString(3));
				inscricao.setNomeOrientador(rs.getString(4));
				
				listaInscricao.add(inscricao);
			}
			
			return listaInscricao;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaInscricao;
		
	}
			
}
		
		


