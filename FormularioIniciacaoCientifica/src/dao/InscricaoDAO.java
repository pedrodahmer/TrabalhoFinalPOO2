package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Inscricao;

public class InscricaoDAO {

	private Connection con = null;

	// Instanciando e inicializando as classes DAO utilizadas
	private AlunoDAO alunoDao = new AlunoDAO();
	private OrientadorDAO orientadorDao = new OrientadorDAO();
	private ProjetoDAO projetoDao = new ProjetoDAO();

	public InscricaoDAO() {
	}

	// Obtém o último id inserido na tabela, realizando uma querry que busca o
	// último id
	// presente na tabela inscrição
	public int obterUltimoIdInserido() {

		ConexaoMySQL.abrirConexao();
		con = ConexaoMySQL.getCon();

		int lastInsertedId = 0;

		if (con != null) {

			String sql = "SELECT * FROM inscricao_ic WHERE id_inscricao_ic = "
					+ "(SELECT max(id_inscricao_ic) FROM inscricao_ic)";

			try {

				PreparedStatement prepStmt = con.prepareStatement(sql);

				ResultSet rs = prepStmt.executeQuery();

				if (rs.next()) {
					lastInsertedId = rs.getInt("id_inscricao_ic");
					/*
					 * i.setId_aluno(lastInsertedId); resultId = i.getId_aluno();
					 */
				}

				return lastInsertedId;

			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		return lastInsertedId;

	}

	// Retorna um ArrayList, em que cada linha representa um objeto de inscrição,
	// contendo os ids de Aluno, Orientador e Projeto da inscrição
	public ArrayList<Inscricao> obterInscricoes() {

		ConexaoMySQL.abrirConexao();
		con = ConexaoMySQL.getCon();

		ArrayList<Inscricao> listaInscricao = new ArrayList<>();

		String sql = "SELECT I.id_inscricao_ic, A.nome, P.titulo, O.nome" + " FROM inscricao_ic I"
				+ " INNER JOIN aluno A" + " ON I.id_aluno_fk = A.id_aluno" + " INNER JOIN projeto P"
				+ " ON I.id_projeto_fk = P.id_projeto" + " INNER JOIN orientador O"
				+ " ON I.id_orientador_fk = O.id_orientador";

		try {
			PreparedStatement prepStmt = con.prepareStatement(sql);

			ResultSet rs = prepStmt.executeQuery();

			while (rs.next()) {
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

	public boolean excluirInscricao(String id) {

		ConexaoMySQL.abrirConexao();
		con = ConexaoMySQL.getCon();

		int id_inscricao = Integer.parseInt(id);

		String consulta = "SELECT * FROM inscricao_ic WHERE id_inscricao_ic = " + id_inscricao;

		PreparedStatement prepStmt = null;

		int id_aluno = 0, id_orientador = 0, id_projeto = 0;

		try {
			prepStmt = con.prepareStatement(consulta);

			ResultSet rs = prepStmt.executeQuery();

			while (rs.next()) {

				id_aluno = rs.getInt(2);
				id_orientador = rs.getInt(3);
				id_projeto = rs.getInt(4);

			}

			String exclusao = "DELETE FROM inscricao_ic WHERE id_inscricao_ic = " + id_inscricao;

			prepStmt = con.prepareStatement(exclusao);

			int resultado = prepStmt.executeUpdate();

			if (resultado == 1) {

				boolean resultadoAluno = alunoDao.excluirAluno(id_aluno);
				boolean resultadoOrientador = orientadorDao.excluirOrientador(id_orientador);
				boolean resultadoProjeto = projetoDao.excluirProjeto(id_projeto);

				if (resultadoAluno && resultadoOrientador && resultadoProjeto) {
					ConexaoMySQL.fecharConexao();
					return true;
				}

			} else {
				ConexaoMySQL.fecharConexao();
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

}
