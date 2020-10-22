package controle;

import java.awt.CardLayout;

import javax.swing.JFileChooser;

import dao.AlunoDAO;
import dao.InscricaoDAO;
import dao.OrientadorDAO;
import dao.ProjetoDAO;
import modelo.Aluno;
import modelo.Inscricao;
import modelo.Orientador;
import modelo.Projeto;
import visao.JanelaExecucao;
import visao.JanelaFormulario;

public class FormularioControle {

	// Criação de variáveis para que elas possam armazenar o caminho dos arquivos
	// selecionados pelo usuário
	private String caminhoDocs = null;
	private String caminhoParecer = null;
	private String caminhoPlanoTrabalho = null;
	private String caminhoHistEscolar = null;

	// Instanciando e inicializando as classes DAO utilizadas, para que não seja
	// nescessário que elas sejam passadas por parâmetro
	private AlunoDAO alunoDao = new AlunoDAO();
	private ProjetoDAO projetoDao = new ProjetoDAO();
	private OrientadorDAO orientadorDao = new OrientadorDAO();
	private InscricaoDAO inscricaoDao = new InscricaoDAO();

	// Abre a janela de preenhimento de formulário
	public void abrirJanelaFormulario(JanelaExecucao je, JanelaFormulario jf) {
		je.setContentPane(jf);
		jf.revalidate();
		jf.repaint();
	}

	// Responsável por abrir os JFileChoosers para que o
	// usuário anexe arquivos necessários
	public boolean anexarArquivos(JanelaFormulario jf, String arquivo) {
		JFileChooser fileChooser = new JFileChooser();
		int resposta = fileChooser.showOpenDialog(jf);

		if (resposta == JFileChooser.APPROVE_OPTION) {

			switch (arquivo) {
			case "docs":
				caminhoDocs = fileChooser.getSelectedFile().getAbsolutePath();
				break;
			case "planoTrabalho":
				caminhoPlanoTrabalho = fileChooser.getSelectedFile().getAbsolutePath();
				break;
			case "parecer":
				caminhoParecer = fileChooser.getSelectedFile().getAbsolutePath();
				break;
			case "histEscolar":
				caminhoHistEscolar = fileChooser.getSelectedFile().getAbsolutePath();
				break;
			}

		}

		jf.avisoDoc(true);

		return true;
	}

	// Verifica se nenhum dos campos obrigatórios não foi preenchido
	public boolean verificarCampos(JanelaFormulario jf) {

		if (jf.getRdbtnOutra().isSelected()) {
			if (caminhoDocs == null) {
				jf.avisoDocsRG_CPF();
				return false;
			}
		}
		
		if(caminhoHistEscolar == null) {
			jf.avisoDocHistEscolar();
			return false;
		}
		
		if(caminhoPlanoTrabalho == null) {
			jf.avisoDocPlanoTrabalho();
			return false;
		}

		if (jf.getFieldNomeAluno().getText() == null || jf.getFieldCPFAluno().getText() == null
				|| jf.getFieldRGAluno().getText() == null || jf.getFieldEmailAluno().getText() == null
				|| jf.getFieldCursoAluno().getText() == null || jf.getFieldInstituicao().getText() == null
				|| jf.getFieldSerieAluno().getText() == null || jf.getFieldCargaHoraria().getText() == null
				|| jf.getFieldTituloProjeto().getText() == null || jf.getFieldLocalProjeto().getText() == null
				|| jf.getFieldGrupoPesquisa().getText() == null || jf.getFieldNomeOrientador().getText() == null
				|| jf.getFieldRamalOrientador().getText() == null || jf.getFieldEmailOrientador().getText() == null
				|| jf.getFieldCelularOrientador().getText() == null) {
			jf.avisoCamposVazios();
			return false;
		}

		return true;
	}

	// Cria a inscrição do aluno, usando o ID do aluno, orientador e projeto
	public boolean criarInscricao(JanelaFormulario jf) {

		Aluno aluno = obterCamposAluno(jf);
		Projeto projeto = obterCamposProjeto(jf);
		Orientador orientador = obterCamposOrientador(jf);

		if (aluno == null || projeto == null || orientador == null) {
			return false;
		}

		boolean resultadoAluno = alunoDao.cadastrarAluno(aluno, inscricaoDao);
		if(resultadoAluno) {
			boolean resultadoOrientador = orientadorDao.cadastrarOrientador(orientador, inscricaoDao);
			if(resultadoOrientador) {
				boolean resultadoProjeto = projetoDao.cadastrarProjeto(projeto, inscricaoDao);
				if(resultadoProjeto) {
					limparCamposFormulario(jf);
					jf.avisoSucessoInscricao();
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
		
	}

	// Obtem os valores presentes nos campos preenchiveis de dados de aluno
	public Aluno obterCamposAluno(JanelaFormulario jf) {

		String nome = jf.getFieldNomeAluno().getText();
		String rg = jf.getFieldRGAluno().getText();
		String cpf = jf.getFieldCPFAluno().getText();
		String email = jf.getFieldEmailAluno().getText();
		String curso = jf.getFieldCursoAluno().getText();
		String instituicao = jf.getFieldInstituicao().getText();
		String serie = jf.getFieldSerieAluno().getText();
		String planoTrabalho = caminhoPlanoTrabalho;
		int horasSemanais = Integer.parseInt(jf.getFieldCargaHoraria().getText());
		String copiaDocumento = caminhoDocs;
		String histEscolar = caminhoHistEscolar;

		Aluno aluno = new Aluno(nome, rg, cpf, email, curso, instituicao, serie, planoTrabalho, horasSemanais,
				copiaDocumento, histEscolar);

		return aluno;
	}

	// Obtem os valores presentes nos campos preenchiveis de dados de projeto
	public Projeto obterCamposProjeto(JanelaFormulario jf) {

		String titulo = jf.getFieldTituloProjeto().getText();
		String grupoPesquisa = jf.getFieldGrupoPesquisa().getText();
		String unidade = jf.getFieldLocalProjeto().getText();
		String faseProjeto = obterFaseProjeto(jf);
		String parecerCEP_CEUA = caminhoParecer;

		Projeto projeto = new Projeto(titulo, grupoPesquisa, unidade, faseProjeto, parecerCEP_CEUA);

		return projeto;
	}

	// Obtem os valores presentes nos campos preenchiveis de dados de orientador
	public Orientador obterCamposOrientador(JanelaFormulario jf) {

		String nome = jf.getFieldNomeOrientador().getText();
		String departamento = jf.getFieldDepartamentoOrientador().getText();
		int ramal = Integer.parseInt(jf.getFieldRamalOrientador().getText());
		String email = jf.getFieldEmailOrientador().getText();
		String telefoneCelular = jf.getFieldCelularOrientador().getText();

		Orientador orientador = new Orientador(nome, departamento, ramal, email, telefoneCelular);

		return orientador;
	}
	
	public String obterFaseProjeto(JanelaFormulario jf) {
		
		String faseProjeto = jf.getRdbtnFaseInicial().getText();;
		
		if(jf.getRdbtnFaseIntermediaria().isSelected()) {
			faseProjeto = jf.getRdbtnFaseIntermediaria().getText();
		} else if(jf.getRdbtnFaseFinal().isSelected()) {
			faseProjeto = jf.getRdbtnFaseFinal().getText();
		}
		
		return faseProjeto;
	}
	
	public void limparCamposFormulario(JanelaFormulario jf) {
		
		jf.getFieldNomeAluno().setText("");
		jf.getFieldCPFAluno().setText("");
		jf.getFieldRGAluno().setText("");
		jf.getFieldCursoAluno().setText("");
		jf.getFieldCargaHoraria().setText("");
		jf.getFieldEmailAluno().setText("");
		jf.getFieldInstituicao().setText("");
		jf.getFieldSerieAluno().setText("");
		jf.getFieldNomeOrientador().setText("");
		jf.getFieldEmailOrientador().setText("");
		jf.getFieldCelularOrientador().setText("");
		jf.getFieldRamalOrientador().setText("");
		jf.getFieldDepartamentoOrientador().setText("");
		jf.getFieldGrupoPesquisa().setText("");
		jf.getFieldTituloProjeto().setText("");
		caminhoDocs = null;
		caminhoHistEscolar = null;
		caminhoParecer = null;
		caminhoPlanoTrabalho = null;
		jf.getRdbtnFaseInicial().setSelected(true);
		jf.getRdbtnUFCSPA().setSelected(true);
		
	}

}
