package controle;

import java.awt.CardLayout;

import visao.JanelaCadastro;
import visao.JanelaPrincipal;

public class JanelaCadastroControle {

	//M�todo que realiza a troca de tela para a tela de cadastro
	public void handlesAbrirCadastro(JanelaCadastro jc, JanelaPrincipal jp) {
		jp.getContentPane().add(jc, "telaCadastro");
		CardLayout cl = (CardLayout) jp.getContentPane().getLayout();
		cl.show(jp.getContentPane(), "telaCadastro");
	}
	
	//Realiza o cadastro do usu�rio, criando um Usu�rio com os dados da tela de cadastro e
	//acionando o m�todo de conex�o mysql
	public boolean handlesCadastro(JanelaCadastro jc) {
		return true;
	}
	
	public void handlesLimparCadastro(JanelaCadastro jc) {
		jc.getFieldNomeUsuario().setText("");
		jc.getFieldSenhaUsuario().setText("");
	}
	
}
