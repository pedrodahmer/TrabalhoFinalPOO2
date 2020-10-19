package controle;

import java.awt.CardLayout;

import visao.JanelaExecucao;
import visao.JanelaFormulario;

public class JanelaFormularioControle {
	
	public void handlesAbrirJanelaFormulario(JanelaExecucao je, JanelaFormulario jf) {
		je.setContentPane(jf);
		jf.revalidate();
		jf.repaint();
	}
	
}
