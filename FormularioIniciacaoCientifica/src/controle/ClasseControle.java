package controle;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import visao.JanelaCadastro;
import visao.JanelaFormulario;
import visao.JanelaLogin;
import visao.JanelaPrincipal;
import visao.JanelaSelecao;

public class ClasseControle implements ActionListener{
	
	private JanelaPrincipal jp;
	private JanelaLogin jl;
	private JanelaCadastro jc;
	// private JanelaSelecao js;
	private JanelaFormulario jf;
	
	public ClasseControle(JanelaPrincipal jp) {
		this.jp = jp;
		
		this.jp.getItemSair().addActionListener(this);
		this.jp.getBtnLogin().addActionListener(this);
		this.jp.getBtnCadastro().addActionListener(this);
		
		this.jp.getBtnLogar().addActionListener(this);
	}
	
	public ClasseControle() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Acao sair
		if(e.getActionCommand().equals("Sair")) {
			System.exit(0);
		}
		
		// Acao ir para tela login
		if(e.getActionCommand().equals("Login")) {
			
			CardLayout cl = (CardLayout) this.jp.getContentPane().getLayout();
			cl.show(this.jp.getContentPane(), "telaLogin");
			
		}
		
		// Acao ir para tela cadastro
		if(e.getActionCommand().equals("Cadastrar-se")) {
			
			CardLayout cl = (CardLayout) this.jp.getContentPane().getLayout();
            cl.show(this.jp.getContentPane(), "panelCadastro");
            
		}
		
		// Acao login
		if(e.getActionCommand().equals("Logar")) {
			
			CardLayout cl = (CardLayout) this.jp.getContentPane().getLayout();
			cl.show(this.jp.getContentPane(), "telaFormulario");
			
		}
		
		// Acao cadastro
		if(e.getActionCommand().equals("Cadastrar")) {
			
			
			
		}
		
	}
	
	
	
}
