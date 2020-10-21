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
	
	private UsuarioDAO usuarioDao;
	
	public ClasseControle(JanelaPrincipal jp, JanelaLogin jl, JanelaCadastro jc, JanelaExecucao je, JanelaFormulario jf, JanelaGerenciamento jg) {
		this.jl = jl;
		this.jp = jp;
		this.jc = jc;
		this.je = je;
		this.jf = jf;
		this.jg = jg;
		
		this.usuarioDao = new UsuarioDAO();
		
		this.jp.getBtnLogin().addActionListener(this);
		this.jp.getBtnCadastro().addActionListener(this);
		this.jp.getItemMenuPrincipal().addActionListener(this);
		
		this.jl.getBtnLogar().addActionListener(this);
		this.jl.getBtnLimpar().addActionListener(this);
		
		this.jc.getBtnCadastrar().addActionListener(this);
		this.jc.getBtnLimpar().addActionListener(this);
		
		this.je.getItemNovoForm().addActionListener(this);
		this.je.getItemMenuPrincipal().addActionListener(this);
		this.je.getItemSair().addActionListener(this);
		this.je.getItemGerenciamento().addActionListener(this);
		
		this.jf.getBtnAnexarParecer().addActionListener(this);
		this.jf.getBtnAnexarDocs().addActionListener(this);
		this.jf.getBtnAnexarPlano().addActionListener(this);
		this.jf.getBtnFinalizar().addActionListener(this);
		
		this.jg.getBtnExcluirInscricao().addActionListener(this);
		
		this.jl.getLblSenhaEsquecida().addMouseListener(this);
	}
	
	//Instanciando as classes que controlam as telas de visão
	JanelaLoginControle jlc = new JanelaLoginControle();
	JanelaCadastroControle jcc = new JanelaCadastroControle();
	JanelaExecucaoControle jec = new JanelaExecucaoControle();
	JanelaFormularioControle jfc = new JanelaFormularioControle();
	JanelaGerenciamentoControle jgc = new JanelaGerenciamentoControle();
	
	public ClasseControle() {
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getComponent() == jl.getLblSenhaEsquecida()) {
			jlc.atualizarSenha(jl, usuarioDao);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//métodos da tela principal
		if(e.getActionCommand().equals("Menu Principal")) {
			CardLayout cl = (CardLayout) jp.getContentPane().getLayout();
			cl.show(jp.getContentPane(), "janelaPrincipal");
		}
		
		//chamada dos métodos da tela de login
		else if(e.getActionCommand().equals("Login")) {
			jlc.handlesAbrirLogin(jl, jp);
		}
		else if (e.getActionCommand().equals("Logar")) {
			jec.handlesExibirNomeUsuario(jl, je);
			boolean resultado = jlc.handlesLogin(jl, usuarioDao);
			if(resultado == true) {
				jec.handlesAbrirExecucao(je); 
			}
			jp.dispose();	
		}
		else if (e.getActionCommand().equals("limpar-login")) {
			jlc.handlesLimparLogin(jl);	
		}
		
		//chamada dos métodos da tela de cadastro
		else if(e.getActionCommand().equals("Cadastrar-se")) {
			jcc.handlesAbrirCadastro(jc, jp);
		}
		else if(e.getActionCommand().equals("limpar-cadastro")) {
			jcc.handlesLimparCadastro(jc);;
		}
		else if(e.getActionCommand().equals("Cadastrar")) {
			jcc.handlesCadastro(jc, usuarioDao);
		}
		
		//chamada dos métodos da tela de execução
		else if(e.getActionCommand().equals("menuPrincipal")) {
			jec.handlesMenuPrincipal(jp, je);
		}
		else if(e.getActionCommand().equals("sair")) {
			jec.handlesSair();
		} else if(e.getActionCommand().equals("gerenciar")) {
			jec.handlesAbrirGerenciamento(je, jg);
			jgc.preencherTabela(jg);
		}
		
		//chamada dos métodos da tela de formulário
		else if(e.getActionCommand().equals("novoForm")) {
			jfc.handlesAbrirJanelaFormulario(je, jf);
		} 
		else if(e.getActionCommand().equals("anexarDocs")) {
			jfc.handlesAnexarArquivos(jf, "docs");
		} 
		else if(e.getActionCommand().equals("anexarParecer")) {
			jfc.handlesAnexarArquivos(jf, "parecer");
		} 
		else if(e.getActionCommand().equals("anexarPlanoTrabalho")) {
			jfc.handlesAnexarArquivos(jf, "planoTrabalho");
		} 
		else if(e.getActionCommand().equals("finalizarInscricao")) {
			boolean resultado = jfc.verificarCampos(jf);
			
			if(resultado) {
				jfc.criarInscricao(jf);
			}
		}
		
		// Chamada de metodos da tela de gerenciamento
		else if(e.getActionCommand().equals("excluirInscricao")) {
			jgc.excluirInscricao(jg);
		}
	}

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
