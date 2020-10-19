package controle;

import visao.JanelaCadastro;
import visao.JanelaExecucao;
import visao.JanelaFormulario;
import visao.JanelaLogin;
import visao.JanelaPrincipal;

public class AppFormulario {
	public static void main(String[] args) {
		
		JanelaPrincipal jp = new JanelaPrincipal();
		JanelaLogin jl = new JanelaLogin();
		JanelaCadastro jc = new JanelaCadastro();
		JanelaExecucao je = new JanelaExecucao();
		JanelaFormulario jf = new JanelaFormulario();
		
		ClasseControle cc = new ClasseControle(jp, jl, jc, je, jf);
		
		jp.setVisible(true);
	}
}
