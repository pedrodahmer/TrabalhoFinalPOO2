package controle;

import java.awt.CardLayout;

import dao.UsuarioDAO;
import modelo.Usuario;
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
	public boolean handlesCadastro(JanelaCadastro jc, UsuarioDAO usuarioDao) {
		String nome = jc.getFieldNomeUsuario().getText();
		String senha = jc.getFieldSenhaUsuario().getText();
		
		Usuario u = new Usuario(nome, senha);
		
		boolean resultado = usuarioDao.cadastraUsuario(u);
		
		jc.getFieldNomeUsuario().setText("");
		jc.getFieldSenhaUsuario().setText("");
		
		if(resultado) {
			System.out.println("OK!");
			return true;
		}
		
		return false;
	}
	
	public void handlesLimparCadastro(JanelaCadastro jc) {
		jc.getFieldNomeUsuario().setText("");
		jc.getFieldSenhaUsuario().setText("");
	}
	
}
