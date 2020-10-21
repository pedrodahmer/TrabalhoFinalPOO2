package controle;

import java.awt.CardLayout;

import visao.JanelaExecucao;
import visao.JanelaGerenciamento;
import visao.JanelaLogin;
import visao.JanelaPrincipal;

public class JanelaExecucaoControle {
	
	//Abre a janela de execução
	public void abrirExecucao(JanelaExecucao je){
		je.setVisible(true);
	}
	
	//Abre a janela de gerenciamento de inscrições
	public void abrirGerenciamento(JanelaExecucao je, JanelaGerenciamento jg) {		
		je.setContentPane(jg);
		je.repaint();
		je.revalidate();
	}
	
	//Realiza a volta para o menu principal
	public void menuPrincipal(JanelaPrincipal jp, JanelaExecucao je) {
		jp.setVisible(true);
		je.dispose();
	}
	
	//Busca o nome que o usuário informou na tela de login e altera o label da tela de execução para que esse seja o nome exibido
	public void exibirNomeUsuario(JanelaLogin jl, JanelaExecucao je){
		String nome = jl.getFieldUsuario().getText();
		je.getLblNomeUser().setText(nome);
	}
	
	//Encerra a execução do programa
	public void sair() {
		System.exit(0);
	}
	
}
