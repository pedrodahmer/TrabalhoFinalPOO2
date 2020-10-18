package visao;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class JanelaCadastro extends JPanel {
	private JTextField fieldNomeUsuario;
	private JTextField fieldSenhaUsuario;

	/**
	 * Create the panel.
	 */
	public JanelaCadastro() {
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
		
		fieldSenhaUsuario = new JTextField();
		add(fieldSenhaUsuario, "cell 0 6,alignx center");
		fieldSenhaUsuario.setColumns(30);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLimpar.setIcon(new ImageIcon(JanelaCadastro.class.getResource("/imagens/limpar.png")));
		add(btnLimpar, "flowx,cell 0 8,alignx center");
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setIcon(new ImageIcon(JanelaCadastro.class.getResource("/imagens/icon-cadastro.png")));
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(btnCadastrar, "cell 0 8,aligny baseline");

	}

}
