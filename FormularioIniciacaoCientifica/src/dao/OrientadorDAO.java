package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Orientador;
import modelo.Projeto;

public class OrientadorDAO {

	private Connection con = null;

	public OrientadorDAO() {
	}

	// Cadastra um orientador na tabela de orientadores usando os valores informados
	// pelo usuário
	public boolean cadastrarOrientador(Orientador o, InscricaoDAO i) {

		ConexaoMySQL.abrirConexao();
		con = ConexaoMySQL.getCon();

		if (con != null) {

			String insereOrientador = "INSERT INTO orientador (nome, departamento, email, ramal, celular) "
					+ "VALUES (?, ?, ?, ?, ?)";

			PreparedStatement prepStmt = null;

			try {
				prepStmt = con.prepareStatement(insereOrientador);

				prepStmt.setString(1, o.getNome());
				prepStmt.setString(2, o.getDepartamento());
				prepStmt.setString(3, o.getEmail());
				prepStmt.setInt(4, o.getRamal());
				prepStmt.setString(5, o.getTelefoneCelular());

				int res = prepStmt.executeUpdate();

				if (res == 1) {

					int lastInsertedId = i.obterUltimoIdInserido();

					String atualizaInscricao = "UPDATE inscricao_ic SET id_orientador_fk = LAST_INSERT_ID()"
							+ "WHERE id_inscricao_ic = " + lastInsertedId;

					PreparedStatement prepStmt2 = con.prepareStatement(atualizaInscricao);

					res = prepStmt2.executeUpdate();

					if (res == 1) {
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

	// Exclui um orientador da tabela, usando como parâmetro o id de orientador
	// presente na tabela de inscirção dele, em que seu id é uma chave estrangeira
	public boolean excluirOrientador(int id_orientador) {

		ConexaoMySQL.abrirConexao();
		con = ConexaoMySQL.getCon();

		if (con != null) {

			String excluiOrientador = "DELETE FROM orientador WHERE id_orientador = " + id_orientador;

			PreparedStatement prepStmt = null;

			try {

				prepStmt = con.prepareStatement(excluiOrientador);

				int resultado = prepStmt.executeUpdate();

				if (resultado == 1) {
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
