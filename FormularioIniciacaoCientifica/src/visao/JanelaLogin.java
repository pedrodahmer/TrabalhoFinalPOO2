package visao;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JanelaLogin extends JPanel {
	private JTextField fieldUsuario;
	private JPasswordField fieldSenha;
	private JButton btnLogar;
	private JButton btnLimpar;
	private JLabel lblSenhaEsquecida;

	// construtor da janela de login
	public JanelaLogin() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(new MigLayout("", "[grow]", "[30.00][][30.00][30.00][][30.00][30.00][][50.00]"));

		JLabel lblTituloLogin = new JLabel("LOGIN");
		lblTituloLogin.setFont(new Font("Arial", Font.BOLD, 19));
		add(lblTituloLogin, "cell 0 0,alignx center");

		JLabel lblUsuario = new JLabel("Usu\u00E1rio");
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
		add(lblUsuario, "flowx,cell 0 2,alignx center");

		fieldUsuario = new JTextField();
		add(fieldUsuario, "cell 0 3,alignx center");
		fieldUsuario.setColumns(30);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 14));
		add(lblSenha, "flowx,cell 0 5,alignx center");

		fieldSenha = new JPasswordField();
		add(fieldSenha, "cell 0 6,alignx center");
		fieldSenha.setColumns(30);

		lblSenhaEsquecida = new JLabel("Esqueci minha senha");
		lblSenhaEsquecida.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblSenhaEsquecida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				lblSenhaEsquecida.setForeground(Color.BLUE);

			}

			@Override
			public void mouseExited(MouseEvent e) {

				lblSenhaEsquecida.setForeground(Color.BLACK);

			}
		});
		lblSenhaEsquecida.setFont(new Font("Arial", Font.PLAIN, 10));
		add(lblSenhaEsquecida, "cell 0 7,alignx center");

		btnLimpar = new JButton("Limpar");
		btnLimpar.setActionCommand("limpar-login");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLimpar.setIcon(new ImageIcon(JanelaLogin.class.getResource("/imagens/limpar.png")));
		add(btnLimpar, "flowx,cell 0 8,alignx center");

		btnLogar = new JButton("Logar");
		btnLogar.setActionCommand("logar");
		btnLogar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogar.setIcon(new ImageIcon(JanelaLogin.class.getResource("/imagens/icon-login.png")));
		add(btnLogar, "cell 0 8,alignx center");

	}

	public JTextField getFieldUsuario() {
		return fieldUsuario;
	}

	public void setFieldUsuario(JTextField fieldUsuario) {
		this.fieldUsuario = fieldUsuario;
	}

	public JTextField getFieldSenha() {
		return fieldSenha;
	}

	public void setFieldSenha(JPasswordField fieldSenha) {
		this.fieldSenha = fieldSenha;
	}

	public JButton getBtnLogar() {
		return btnLogar;
	}

	public void setBtnLogar(JButton btnLogar) {
		this.btnLogar = btnLogar;
	}

	public JButton getBtnLimpar() {
		return btnLimpar;
	}

	public void setBtnLimpar(JButton btnLimpar) {
		this.btnLimpar = btnLimpar;
	}

	public JLabel getLblSenhaEsquecida() {
		return lblSenhaEsquecida;
	}

	public void setLblSenhaEsquecida(JLabel lblSenhaEsquecida) {
		this.lblSenhaEsquecida = lblSenhaEsquecida;
	}

	public String obterNovaSenha() {

		String novaSenha = JOptionPane.showInputDialog(this, "Insira sua nova senha:", "Alteração de senha",
				JOptionPane.INFORMATION_MESSAGE);

		return novaSenha;

	}

	public void avisoCampoNomeVazio() {
		JOptionPane.showMessageDialog(this, "Preencha o campo nome!", "Aviso", JOptionPane.WARNING_MESSAGE);
	}

	public void avisoUsuarioNaoEncontrado() {
		JOptionPane.showMessageDialog(this, "Usuário não encontrado", "Aviso", JOptionPane.WARNING_MESSAGE);
	}
}
