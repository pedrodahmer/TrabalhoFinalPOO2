package controle;

import java.awt.CardLayout;

import dao.UsuarioDAO;
import modelo.Usuario;
import visao.JanelaCadastro;
import visao.JanelaPrincipal;

public class CadastroControle {

	private UsuarioDAO usuarioDAO = new UsuarioDAO();

	// M�todo que realiza a troca de tela para a tela de cadastro apenas recebendo
	// as telas j� inicializadas como par�mtros
	public void handlesAbrirCadastro(JanelaCadastro jc, JanelaPrincipal jp) {
		jp.getContentPane().add(jc, "telaCadastro");
		CardLayout cl = (CardLayout) jp.getContentPane().getLayout();
		cl.show(jp.getContentPane(), "telaCadastro");
	}

	// Realiza o cadastro do usu�rio, criando um Usu�rio u com os dados da tela de
	// cadastro e acionando o m�todo que realiza o cadastro na classe DAO
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

	// M�todo respons�vel por limpar os campos da tela de cadastro
	public void handlesLimparCadastro(JanelaCadastro jc) {
		jc.getFieldNomeUsuario().setText("");
		jc.getFieldSenhaUsuario().setText("");
	}

}
