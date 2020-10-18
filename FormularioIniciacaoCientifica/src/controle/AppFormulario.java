package controle;

import visao.JanelaCadastro;
import visao.JanelaLogin;
import visao.JanelaPrincipal;
import visao.JanelaSelecao;

public class AppFormulario {
	public static void main(String[] args) {
		
		JanelaPrincipal jan = new JanelaPrincipal();
		ClasseControle cc = new ClasseControle(jan);
		
		jan.setVisible(true);
	}
}
