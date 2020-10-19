package controle;

import java.awt.CardLayout;

import visao.JanelaCadastro;
import visao.JanelaPrincipal;

public class JanelaCadastroControle {

	//Método que realiza a troca de tela para a tela de cadastro
	public void handlesAbrirCadastro(JanelaCadastro jc, JanelaPrincipal jp) {
		jp.getContentPane().add(jc, "telaCadastro");
		CardLayout cl = (CardLayout) jp.getContentPane().getLayout();
		cl.show(jp.getContentPane(), "telaCadastro");
	}
	
	//Realiza o cadastro do usuário, criando um Usuário com os dados da tela de cadastro e
	//acionando o método de conexão mysql
	public boolean handlesCadastro(JanelaCadastro jc) {
		return true;
	}
	
	public void handlesLimparCadastro(JanelaCadastro jc) {
		jc.getFieldNomeUsuario().setText("");
		jc.getFieldSenhaUsuario().setText("");
	}
	
}
