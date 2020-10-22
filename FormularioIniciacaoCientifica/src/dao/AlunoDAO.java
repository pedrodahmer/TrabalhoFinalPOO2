package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Aluno;
import modelo.Inscricao;

public class AlunoDAO {

	private Connection con = null;

	public AlunoDAO() {
	}

	// Realiza o cadastro de um aluno no banco de dados passando os valores
	// inseridos pelo usuário na tela de informações do aluno,
	// durante o preenchimento do formulário
	public boolean cadastrarAluno(Aluno a, InscricaoDAO i) {

		ConexaoMySQL.abrirConexao();
		con = ConexaoMySQL.getCon();

		if (con != null) {

			String insereAluno = "INSERT INTO aluno(nome, email, cpf, rg, curso, instituicao, serie,"
					+ "horas_semanas, plano_trabalho, copia_rg_cpf, copia_hist_escolar) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement prepStmt = null;

			try {
				prepStmt = con.prepareStatement(insereAluno);

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
				prepStmt.setString(11, a.getHistEscolar());

				int res = prepStmt.executeUpdate();

				if (res == 1) {

					String insereInscricao = "INSERT INTO inscricao_ic (id_aluno_fk) VALUES (LAST_INSERT_ID())";

					PreparedStatement prepStmt2 = con.prepareStatement(insereInscricao);

					int resultado = prepStmt2.executeUpdate();

					if(resultado == 1) {
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

	// Exclui um aluno da tabela, usando como parâmetro o id de aluno presente na
	// tabela de inscirção dele, em que seu id é uma chave estrangeira
	public boolean excluirAluno(int id_aluno) {

		ConexaoMySQL.abrirConexao();
		con = ConexaoMySQL.getCon();

		if (con != null) {

			String excluiAluno = "DELETE FROM aluno WHERE id_aluno = " + id_aluno;

			PreparedStatement prepStmt = null;

			try {

				prepStmt = con.prepareStatement(excluiAluno);

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
