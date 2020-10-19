package controle;

import java.awt.CardLayout;

import dao.UsuarioDAO;
import modelo.Usuario;
import visao.JanelaExecucao;
import visao.JanelaLogin;
import visao.JanelaPrincipal;

public class JanelaLoginControle {
	
	//M�todo que realiza a troca de tela para a tela de login
	public void handlesAbrirLogin(JanelaLogin jl, JanelaPrincipal jp) {
		jp.getContentPane().add(jl, "telaLogin");
		CardLayout cl = (CardLayout) jp.getContentPane().getLayout();
        cl.show(jp.getContentPane(), "telaLogin");
	}
	
	//Realiza o login do usu�rio, acionando o m�todo de conex�o mysql para verificar se usu�rio
	//esta presente no banco de dados
	public boolean handlesLogin(JanelaLogin jl, UsuarioDAO usuarioDao) {		
		
		String senha = jl.getFieldSenha().getText();
		
		Usuario u = new Usuario(null, senha);
		
		boolean resultado = usuarioDao.autenticaUsuario(u);
		
		if(resultado) {
			System.out.println("usuario encontrado!");
			return true;
		}
		
		System.out.println("nao encontrou");
		return false;
	}
	
	public void handlesLimparLogin(JanelaLogin jl) {
		jl.getFieldUsuario().setText("");
		jl.getFieldSenha().setText("");
	}
}
