package controle;

import visao.JanelaCadastro;
import visao.JanelaFormulario;
import visao.JanelaLogin;
import visao.JanelaPrincipal;
import visao.JanelaSelecao;

public class AppFormulario {
	public static void main(String[] args) {
		
		JanelaPrincipal jp = new JanelaPrincipal();
		
//		JanelaLogin jl = new JanelaLogin();
//		JanelaCadastro jc = new JanelaCadastro();
//		JanelaFormulario jf = new JanelaFormulario();
		
		ClasseControle cc = new ClasseControle(jp);
		
		jp.setVisible(true);
	}
}
