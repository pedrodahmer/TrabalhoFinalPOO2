package visao;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaLogin extends JPanel {
	private JTextField fieldUsuario;
	private JTextField fieldSenha;
	private JButton btnLogar;
	private JButton btnLimpar;

	//construtor da janela de login
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
		
		fieldSenha = new JTextField();
		add(fieldSenha, "cell 0 6,alignx center");
		fieldSenha.setColumns(30);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLimpar.setIcon(new ImageIcon(JanelaLogin.class.getResource("/imagens/limpar.png")));
		add(btnLimpar, "flowx,cell 0 8,alignx center");
		
		btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JanelaExecucao je = new JanelaExecucao();
				je.setVisible(true);
				
			}
		});
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

	public void setFieldSenha(JTextField fieldSenha) {
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
	
	

}
