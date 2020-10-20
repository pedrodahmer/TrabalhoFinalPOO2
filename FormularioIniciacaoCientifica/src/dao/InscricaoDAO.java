package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
			
}
		
		


