package controle;

import java.awt.CardLayout;

import dao.UsuarioDAO;
import modelo.Usuario;
import visao.JanelaCadastro;
import visao.JanelaPrincipal;

public class CadastroControle {

	private UsuarioDAO usuarioDAO = new UsuarioDAO();

	// Método que realiza a troca de tela para a tela de cadastro apenas recebendo
	// as telas já inicializadas como parâmtros
	public void handlesAbrirCadastro(JanelaCadastro jc, JanelaPrincipal jp) {
		jp.getContentPane().add(jc, "telaCadastro");
		CardLayout cl = (CardLayout) jp.getContentPane().getLayout();
		cl.show(jp.getContentPane(), "telaCadastro");
	}

	// Realiza o cadastro do usuário, criando um Usuário u com os dados da tela de
	// cadastro e acionando o método que realiza o cadastro na classe DAO
	public boolean handlesCadastro(JanelaCadastro jc) {
		String nome = jc.getFieldNomeUsuario().getText();
		String senha = jc.getFieldSenhaUsuario().getText();

		if (nome.equals("") || senha.equals("")) {
			jc.avisoPreenchaOsCampos();
			return false;
		}

		Usuario u = new Usuario(nome, senha);

		boolean resultado = usuarioDAO.cadastraUsuario(u);

		jc.getFieldNomeUsuario().setText("");
		jc.getFieldSenhaUsuario().setText("");

		if (resultado) {
			jc.avisoSucessoCadastro();
			return true;
		}

		jc.avisoFalhaCadastro();
		return false;
	}

	// Método responsável por limpar os campos da tela de cadastro
	public void handlesLimparCadastro(JanelaCadastro jc) {
		jc.getFieldNomeUsuario().setText("");
		jc.getFieldSenhaUsuario().setText("");
	}

}
