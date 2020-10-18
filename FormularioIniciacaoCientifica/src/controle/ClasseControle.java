package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import visao.JanelaLogin;
import visao.JanelaPrincipal;
import visao.JanelaSelecao;

public class ClasseControle implements ActionListener{
	
	private JanelaPrincipal jp;
	private JanelaLogin jl;
	private JanelaSelecao js;
	
	public ClasseControle(JanelaPrincipal jp) {
		this.jp = jp;
		
		this.jp.getItemSair().addActionListener(this);
	}
	
	public ClasseControle() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Sair")) {
			System.exit(0);
		}
		
	}
	
	
	
}
