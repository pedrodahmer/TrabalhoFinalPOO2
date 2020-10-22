package controle;

import java.awt.CardLayout;

import dao.UsuarioDAO;
import modelo.Usuario;
import visao.JanelaExecucao;
import visao.JanelaLogin;
import visao.JanelaPrincipal;

public class LoginControle {
	
	//Instanciando e inicializando a classe DAO utilizada, para que n�o seja nescess�rio que ela seja passada por par�metro
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	//M�todo que realiza a troca de tela para a tela de login
	public void handlesAbrirLogin(JanelaLogin jl, JanelaPrincipal jp) {
		jp.getContentPane().add(jl, "telaLogin");
		CardLayout cl = (CardLayout) jp.getContentPane().getLayout();
        cl.show(jp.getContentPane(), "telaLogin");
	}
	
	//Realiza o login do usu�rio, acionando a classe DAO para verificar se usu�rio
	//esta presente no banco de dados
	public boolean handlesLogin(JanelaLogin jl) {		
		
		String senha = jl.getFieldSenha().getText();
		
		Usuario u = new Usuario(null, senha);
		
		boolean resultado = usuarioDAO.autenticaUsuario(u);

		jl.getFieldUsuario().setText("");
		jl.getFieldSenha().setText("");
		
		if(resultado) {
			System.out.println("usuario encontrado!");
			return true;
		}
		
		System.out.println("nao encontrou");
		return false;
	}
	
	//Limpa os campos da tela de Login
	public void handlesLimparLogin(JanelaLogin jl) {
		jl.getFieldUsuario().setText("");
		jl.getFieldSenha().setText("");
	}
	
	//Realiza a atroca da senha do usu�rio, chamando o m�todo na classe DAO respons�vel por opera��es com usu�rio
	public void atualizarSenha(JanelaLogin jl) {
		
		String nomeUsuario = jl.getFieldUsuario().getText();
		
		if(nomeUsuario.equals("")) {
			jl.avisoCampoNomeVazio();
		} else {
			String novaSenha = jl.obterNovaSenha();
			
			usuarioDAO.atualizarSenha(novaSenha, nomeUsuario);
		}
		
	}
}
