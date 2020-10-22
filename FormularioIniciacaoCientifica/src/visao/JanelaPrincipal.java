package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.CardLayout;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Toolkit;

public class JanelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JanelaLogin jl;
	private JanelaCadastro jc;
	private JMenuItem itemMenuPrincipal;
	private JMenuItem itemSair;

	private JButton btnLogin;
	private JButton btnCadastro;

	public JanelaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(JanelaPrincipal.class.getResource("/imagens/icon-ufcspa-quadrado.png")));
		setTitle("Formul\u00E1rio de Inscri\u00E7\u00E3o para IC Volunt\u00E1ria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);

		setResizable(false);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Arquivo");
		menuBar.add(mnNewMenu);

		itemSair = new JMenuItem("Sair");
		itemSair.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/imagens/exit.png")));
		itemSair.setActionCommand("sair-janelaPrincipal");

		itemMenuPrincipal = new JMenuItem("Menu Principal");
		itemMenuPrincipal.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/imagens/icon-home.png")));
		mnNewMenu.add(itemMenuPrincipal);
		mnNewMenu.add(itemSair);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel, "janelaPrincipal");
		panel.setLayout(new MigLayout("", "[grow]", "[40.00][][32.00][41.00][36.00]"));

		JLabel lblTitulo = new JLabel(
				"Formul\u00E1rio de Inscri\u00E7\u00E3o para Inicia\u00E7\u00E3o Cient\u00EDfica Volunt\u00E1ria");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 19));
		panel.add(lblTitulo, "cell 0 0,alignx center,aligny top");

		JLabel lblLogoUfcspa = new JLabel("");
		lblLogoUfcspa.setBounds(0, 0, 180, 90);

		// Mecanismo para redimensionar a imagem
		try {
			lblLogoUfcspa.setIcon(new ImageIcon(ImageIO
					.read(JanelaPrincipal.class.getResource("/imagens/informatica-biomedica.png")).getScaledInstance(
							lblLogoUfcspa.getWidth(), lblLogoUfcspa.getHeight(), BufferedImage.TYPE_INT_RGB)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panel.add(lblLogoUfcspa, "cell 0 1,alignx center");

		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogin.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/imagens/icon-login.png")));
		panel.add(btnLogin, "cell 0 3,alignx center,aligny center");

		btnCadastro = new JButton("Cadastrar-se");
		btnCadastro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCadastro.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/imagens/icon-cadastro.png")));
		panel.add(btnCadastro, "cell 0 4,alignx center");
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}

	public JButton getBtnCadastro() {
		return btnCadastro;
	}

	public void setBtnCadastro(JButton btnCadastro) {
		this.btnCadastro = btnCadastro;
	}

	public JMenuItem getItemMenuPrincipal() {
		return itemMenuPrincipal;
	}

	public void setItemMenuPrincipal(JMenuItem itemMenuPrincipal) {
		this.itemMenuPrincipal = itemMenuPrincipal;
	}

	public JMenuItem getItemSair() {
		return itemSair;
	}

	public void setItemSair(JMenuItem itemSair) {
		this.itemSair = itemSair;
	}
}
