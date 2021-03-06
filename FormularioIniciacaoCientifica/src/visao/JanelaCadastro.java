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

public class JanelaCadastro extends JPanel {
	private JTextField fieldNomeUsuario;
	private JPasswordField fieldSenhaUsuario;
	private JButton btnLimpar;
	private JButton btnCadastrar;

	/**
	 * Create the panel.
	 */
	public JanelaCadastro() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(new MigLayout("", "[grow]", "[30.00][][30.00][30.00][][30.00][30.00][][30.00][][]"));

		JLabel lblTituloCadastro = new JLabel("Cadastro");
		lblTituloCadastro.setFont(new Font("Arial", Font.BOLD, 19));
		add(lblTituloCadastro, "cell 0 0,alignx center");
		lblTituloCadastro.setSize(50, 50);

		JLabel lblNomeUsuario = new JLabel("Informe o nome de usuario");
		lblNomeUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
		add(lblNomeUsuario, "cell 0 2,alignx center");

		fieldNomeUsuario = new JTextField();
		add(fieldNomeUsuario, "cell 0 3,alignx center");
		fieldNomeUsuario.setColumns(30);

		JLabel lblSenhaUsuario = new JLabel("Informe a senha de usuario");
		lblSenhaUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
		add(lblSenhaUsuario, "cell 0 5,alignx center");

		fieldSenhaUsuario = new JPasswordField();
		add(fieldSenhaUsuario, "cell 0 6,alignx center");
		fieldSenhaUsuario.setColumns(30);

		btnLimpar = new JButton("Limpar");
		btnLimpar.setActionCommand("limpar-cadastro");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLimpar.setIcon(new ImageIcon(JanelaCadastro.class.getResource("/imagens/limpar.png")));
		add(btnLimpar, "flowx,cell 0 8,alignx center");

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setActionCommand("cadastrar");
		btnCadastrar.setIcon(new ImageIcon(JanelaCadastro.class.getResource("/imagens/icon-cadastro.png")));
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(btnCadastrar, "cell 0 8,aligny baseline");

	}

	public JTextField getFieldNomeUsuario() {
		return fieldNomeUsuario;
	}

	public void setFieldNomeUsuario(JTextField fieldNomeUsuario) {
		this.fieldNomeUsuario = fieldNomeUsuario;
	}

	public JPasswordField getFieldSenhaUsuario() {
		return fieldSenhaUsuario;
	}

	public void setFieldSenhaUsuario(JPasswordField fieldSenhaUsuario) {
		this.fieldSenhaUsuario = fieldSenhaUsuario;
	}

	public JButton getBtnLimpar() {
		return btnLimpar;
	}

	public void setBtnLimpar(JButton btnLimpar) {
		this.btnLimpar = btnLimpar;
	}

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}

	public void setBtnCadastrar(JButton btnCadastrar) {
		this.btnCadastrar = btnCadastrar;
	}

	public void avisoSucessoCadastro() {
		JOptionPane.showMessageDialog(this, "Usu�rio cadastrado com sucesso!", "Sucesso!", JOptionPane.PLAIN_MESSAGE);
	}

	public void avisoFalhaCadastro() {
		JOptionPane.showMessageDialog(this, "Houve um erro no cadastro. Tente novamente!", "Erro!",
				JOptionPane.ERROR_MESSAGE);
	}

	public void avisoPreenchaOsCampos() {
		JOptionPane.showMessageDialog(this, "Preencha todos os campos e tente novamente", "Aviso!",
				JOptionPane.WARNING_MESSAGE);
	}
}
