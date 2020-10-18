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
		this.jl = jl;
		
	}
	
	public ClasseControle() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
