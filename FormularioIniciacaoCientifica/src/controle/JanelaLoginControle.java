package controle;

import java.awt.CardLayout;

import visao.JanelaExecucao;
import visao.JanelaLogin;
import visao.JanelaPrincipal;

public class JanelaLoginControle {
	
	//Método que realiza a troca de tela para a tela de login
	public void handlesAbrirLogin(JanelaLogin jl, JanelaPrincipal jp) {
		jl = new JanelaLogin();
		jp.getContentPane().add(jl, "telaLogin");
		CardLayout cl = (CardLayout) jp.getContentPane().getLayout();
        cl.show(jp.getContentPane(), "telaLogin");
	}
	
	//Realiza o login do usuário, acionando o método de conexão mysql para verificar se usuário
	//esta presente no banco de dados
	public boolean handlesLogin(JanelaLogin jl) {		
		return true;
	}
}
