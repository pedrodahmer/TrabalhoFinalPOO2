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

public class JanelaFormularioControle {
	
	private String caminhoDocs = null;
	private String caminhoParecer = null;
	private String caminhoPlanoTrabalho = null;
	private String caminhoHistEscolar = null;
	
	private AlunoDAO alunoDao = new AlunoDAO();
	private ProjetoDAO projetoDao = new ProjetoDAO();
	private OrientadorDAO orientadorDao = new OrientadorDAO();
	private InscricaoDAO inscricaoDao = new InscricaoDAO();
	
	private Inscricao inscricao = new Inscricao();
	
	public void handlesAbrirJanelaFormulario(JanelaExecucao je, JanelaFormulario jf) {
		je.setContentPane(jf);
		jf.revalidate();
		jf.repaint();
	}
	
	public boolean handlesAnexarArquivos(JanelaFormulario jf, String arquivo) {
		JFileChooser fileChooser = new JFileChooser();
		int resposta = fileChooser.showOpenDialog(jf);
		
		if(resposta == JFileChooser.APPROVE_OPTION) {
			
			switch(arquivo) {
				case "docs":
					caminhoDocs = fileChooser.getSelectedFile().getAbsolutePath();
					break;
				case "planoTrabalho":
					caminhoPlanoTrabalho = fileChooser.getSelectedFile().getAbsolutePath();
					break;
				case "parecer":
					caminhoParecer = fileChooser.getSelectedFile().getAbsolutePath();
					break;
			}
			
		}
		
		jf.avisoDoc(true);
		
		return true;
	}
	
	public boolean verificarCampos(JanelaFormulario jf) {
		
		if(jf.getRdbtnOutra().isSelected()) {
			if(caminhoDocs == null || caminhoHistEscolar == null) {
				return false;
			}
		}
		
		if(jf.getFieldNomeAluno().getText() == null|| jf.getFieldCPFAluno().getText() == null 
				||jf.getFieldRGAluno().getText() == null
				|| jf.getFieldEmailAluno().getText() == null || jf.getFieldCursoAluno().getText() == null
				||jf.getFieldInstituicao().getText() == null || jf.getFieldSerieAluno().getText() == null 
				|| jf.getFieldCargaHoraria().getText() == null || jf.getFieldTituloProjeto().getText() == null 
				|| jf.getFieldLocalProjeto().getText() == null || jf.getFieldGrupoPesquisa().getText() == null 
				|| jf.getFieldNomeOrientador().getText() == null || jf.getFieldRamalOrientador().getText() == null 
				|| jf.getFieldEmailOrientador().getText() == null || jf.getFieldCelularOrientador().getText() == null 
				|| caminhoPlanoTrabalho == null) {
			return false;
		}
		
		return true;
	}
	
	public boolean criarInscricao(JanelaFormulario jf) {
		
		Aluno aluno = obterCamposAluno(jf);
		Projeto projeto = obterCamposProjeto(jf);
		Orientador orientador = obterCamposOrientador(jf);
		
		if(aluno == null || projeto == null || orientador == null) {
			return false;
		}
		
		alunoDao.cadastrarAluno(aluno, inscricaoDao);
		orientadorDao.cadastrarOrientador(orientador, inscricaoDao);
		projetoDao.cadastrarProjeto(projeto, inscricaoDao);
		
		return true;
	}
	
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
		
		Aluno aluno = new Aluno(nome, rg, cpf, email, curso, instituicao, serie, planoTrabalho, horasSemanais, copiaDocumento, histEscolar);
		
		return aluno;
	}
	
	public Projeto obterCamposProjeto(JanelaFormulario jf) {
		
		String titulo = jf.getFieldTituloProjeto().getText();
		String grupoPesquisa = jf.getFieldGrupoPesquisa().getText();
		String unidade = jf.getFieldLocalProjeto().getText();
		String faseProjeto = jf.getGrupoFaseProjeto().getSelection().toString();
		String parecerCEP_CEUA = caminhoParecer;
		
		Projeto projeto = new Projeto(titulo, grupoPesquisa, unidade, faseProjeto, parecerCEP_CEUA);
		
		return projeto;
	}
	
	public Orientador obterCamposOrientador(JanelaFormulario jf) {
		
		String nome = jf.getFieldNomeOrientador().getText();
		String departamento = jf.getFieldDepartamentoOrientador().getText();
		int ramal = Integer.parseInt(jf.getFieldRamalOrientador().getText());
		String email = jf.getFieldEmailOrientador().getText();
		String telefoneCelular = jf.getFieldCelularOrientador().getText();
		
		Orientador orientador = new Orientador(nome, departamento, ramal, email, telefoneCelular);
		
		return orientador;
	}
	
}
