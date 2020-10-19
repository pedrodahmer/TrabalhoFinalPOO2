package controle;

import visao.JanelaExecucao;
import visao.JanelaPrincipal;

public class JanelaExecucaoControle {
	
	public void handlesAbrirExecucao(JanelaExecucao je, JanelaPrincipal jp){
		je.setVisible(true);
		jp.dispose();
	}
	
}
