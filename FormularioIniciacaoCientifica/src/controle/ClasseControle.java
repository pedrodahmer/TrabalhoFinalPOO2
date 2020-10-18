package controle;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import visao.JanelaCadastro;
import visao.JanelaExecucao;
import visao.JanelaLogin;
import visao.JanelaPrincipal;

public class ClasseControle implements ActionListener{
	
	private JanelaPrincipal jp;
	private JanelaLogin jl;
	private JanelaCadastro jc;
	private JanelaExecucao je;
	
	public ClasseControle(JanelaPrincipal jp, JanelaLogin jl, JanelaCadastro jc, JanelaExecucao je) {
		this.jl = jl;
		this.jp = jp;
		this.jc = jc;
		this.je = je;
		
		this.jp.getBtnLogin().addActionListener(this);
		this.jp.getBtnCadastro().addActionListener(this);
		this.jp.getItemMenuPrincipal().addActionListener(this);
		
		this.jl.getBtnLogar().addActionListener(this);
	}
	
	//Instanciando as classes que controlam as telas de visão
	JanelaLoginControle jlc = new JanelaLoginControle();
	JanelaCadastroControle jcc = new JanelaCadastroControle();
	JanelaExecucaoControle jec = new JanelaExecucaoControle();
	
	public ClasseControle() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("Menu Principal")) {
			CardLayout cl = (CardLayout) jp.getContentPane().getLayout();
			cl.show(jp.getContentPane(), "janelaPrincipal");
		}
		else if(e.getActionCommand().equals("Login")) {
			jlc.handlesAbrirLogin(jl, jp);
		}
		else if(e.getActionCommand().equals("Cadastrar-se")) {
			jcc.handlesAbrirCadastro(jc, jp);
		}
		else if (e.getActionCommand().equals("Logar")) {
			jlc.handlesLogin(jl);
			System.out.println("pedroa");
			jec.handlesAbrirExecucao(je, jp);			
		}
	}
	
	
	
}
