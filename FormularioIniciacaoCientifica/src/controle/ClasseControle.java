package controle;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import dao.UsuarioDAO;
import visao.JanelaCadastro;
import visao.JanelaExecucao;
import visao.JanelaFormulario;
import visao.JanelaGerenciamento;
import visao.JanelaLogin;
import visao.JanelaPrincipal;

public class ClasseControle implements ActionListener, MouseListener {

	private JanelaPrincipal jp;
	private JanelaLogin jl;
	private JanelaCadastro jc;
	private JanelaExecucao je;
	private JanelaFormulario jf;
	private JanelaGerenciamento jg;

	public ClasseControle(JanelaPrincipal jp, JanelaLogin jl, JanelaCadastro jc, JanelaExecucao je, JanelaFormulario jf,
			JanelaGerenciamento jg) {
		// Declaracao de todas as janelas da aplicacao
		this.jl = jl;
		this.jp = jp;
		this.jc = jc;
		this.je = je;
		this.jf = jf;
		this.jg = jg;

		// Adicionando ActionListener em todos os componentes que realizam uma funcao
		this.jp.getBtnLogin().addActionListener(this);
		this.jp.getBtnCadastro().addActionListener(this);
		this.jp.getItemMenuPrincipal().addActionListener(this);
		this.jp.getItemSair().addActionListener(this);

		this.jl.getBtnLogar().addActionListener(this);
		this.jl.getBtnLimpar().addActionListener(this);

		this.jc.getBtnCadastrar().addActionListener(this);
		this.jc.getBtnLimpar().addActionListener(this);

		this.je.getItemNovoForm().addActionListener(this);
		this.je.getItemMenuPrincipal().addActionListener(this);
		this.je.getItemSair().addActionListener(this);
		this.je.getItemGerenciamento().addActionListener(this);

		this.jf.getBtnAnexarHistEscolar().addActionListener(this);
		this.jf.getBtnAnexarParecer().addActionListener(this);
		this.jf.getBtnAnexarDocs().addActionListener(this);
		this.jf.getBtnAnexarPlano().addActionListener(this);
		this.jf.getBtnFinalizar().addActionListener(this);

		this.jg.getBtnExcluirInscricao().addActionListener(this);

		this.jl.getLblSenhaEsquecida().addMouseListener(this);
	}

	// Instanciando as classes que controlam cada uma das telas do pacote visao
	LoginControle jlc = new LoginControle();
	CadastroControle jcc = new CadastroControle();
	InscricoesControle jec = new InscricoesControle();
	FormularioControle jfc = new FormularioControle();
	GerenciamentoControle jgc = new GerenciamentoControle();

	public ClasseControle() {
	}

	// Metodo oriundo da interface MouseListener
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getComponent() == jl.getLblSenhaEsquecida()) {
			jlc.atualizarSenha(jl);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		// Metodos da tela principal
		if (e.getActionCommand().equals("menuPrincipal")) {
			
			// Utilizando card layout para abrir um novo JPanel
			CardLayout cl = (CardLayout) jp.getContentPane().getLayout();
			cl.show(jp.getContentPane(), "janelaPrincipal");
		
		} else if (e.getActionCommand().equals("sair-janelaPrincipal")) {
			System.exit(0);
		}

		// Chamada dos metodos da tela de login
		else if (e.getActionCommand().equals("login")) {
		
			jlc.handlesAbrirLogin(jl, jp);
		
		} else if (e.getActionCommand().equals("logar")) {
			jec.exibirNomeUsuario(jl, je);
			
			boolean resultado = jlc.handlesLogin(jl);
			
			if (resultado == true) {
				jec.abrirExecucao(je);
				jp.dispose();
			}
			
		} else if (e.getActionCommand().equals("limpar-login")) {
		
			jlc.handlesLimparLogin(jl);
		
		}

		// Chamada dos metodos da tela de cadastro
		else if (e.getActionCommand().equals("cadastro")) {
		
			jcc.abrirCadastro(jc, jp);
		
		} else if (e.getActionCommand().equals("limpar-cadastro")) {
		
			jcc.limparCadastro(jc);
		
		} else if (e.getActionCommand().equals("cadastrar")) {
		
			jcc.cadastro(jc);
		
		}

		// Chamada dos metodos da tela de execucao
		else if (e.getActionCommand().equals("menuPrincipalExecucao")) {
		
			jec.menuPrincipal(jp, je);
		
		} else if (e.getActionCommand().equals("sair")) {
		
			jec.sair();
		
		} else if (e.getActionCommand().equals("gerenciar")) {
			
			jec.abrirGerenciamento(je, jg);
			jgc.preencherTabela(jg);
		
		}

		// Chamada dos metodos da tela de formulario
		else if (e.getActionCommand().equals("novoForm")) {
			
			jfc.abrirJanelaFormulario(je, jf);
			
		} else if (e.getActionCommand().equals("botao-historico-escolar")) {
			
			jfc.anexarArquivos(jf, "histEscolar");
		
		} else if (e.getActionCommand().equals("anexarDocs")) {
			
			jfc.anexarArquivos(jf, "docs");
		
		} else if (e.getActionCommand().equals("anexarParecer")) {
		
			jfc.anexarArquivos(jf, "parecer");
		
		} else if (e.getActionCommand().equals("anexarPlanoTrabalho")) {
		
			jfc.anexarArquivos(jf, "planoTrabalho");
		
		} else if (e.getActionCommand().equals("finalizarInscricao")) {
			boolean resultado = jfc.verificarCampos(jf);

			if (resultado) {
				jfc.criarInscricao(jf);
			}
		}

		// Chamada de metodos da tela de gerenciamento
		else if (e.getActionCommand().equals("excluirInscricao")) {
			jgc.excluirInscricao(jg);
		}
	}

	// Metodos da interface MouseListener nao usados
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
