package controle;

import visao.JanelaExecucao;
import visao.JanelaLogin;
import visao.JanelaPrincipal;

public class JanelaExecucaoControle {
	
	public void handlesAbrirExecucao(JanelaExecucao je){
		je.setVisible(true);
	}
	
	public void handlesMenuPrincipal(JanelaPrincipal jp, JanelaExecucao je) {
		jp.setVisible(true);
		je.dispose();
	}
	
	public void handlesExibirNomeUsuario(JanelaLogin jl, JanelaExecucao je){
		String nome = jl.getFieldUsuario().getText();
		je.getLblNomeUser().setText(nome);
	}
	
	public void handlesSair() {
		System.exit(0);
	}
	
}
