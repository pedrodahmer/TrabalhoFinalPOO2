package controle;

import visao.JanelaCadastro;
import visao.JanelaExecucao;
import visao.JanelaLogin;
import visao.JanelaPrincipal;

public class AppFormulario {
	public static void main(String[] args) {
		
		JanelaPrincipal jp = new JanelaPrincipal();
		JanelaLogin jl = new JanelaLogin();
		JanelaCadastro jc = new JanelaCadastro();
		JanelaExecucao je = new JanelaExecucao();
		ClasseControle cc = new ClasseControle(jp, jl, jc, je);
		
		jp.setVisible(true);
	}
}
