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
import javax.swing.JTextField;

public class JanelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JanelaLogin jl;
	private JanelaCadastro jc;
	private JMenuItem itemSair;
	private JButton btnLogin;
	private JButton btnCadastro;
	private JButton btnLogar;

	public JanelaPrincipal() {
		setTitle("Formul\u00E1rio de inscri\u00E7\u00E3o para IC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		
		setResizable(false); // Desabilitar redimensionamento
		
		// Definicao do menu bar e itens
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Arquivo");
		menuBar.add(mnNewMenu);
		
		itemSair = new JMenuItem("Sair");
		itemSair.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/imagens/exit.png")));
		mnNewMenu.add(itemSair);
		
		// Voltar a tela principal
		JMenuItem itemMenuPrincipal = new JMenuItem("Menu Principal");
		itemMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		mnNewMenu.add(itemMenuPrincipal);
		
		// Definicao do content pane
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		// Definicao do painel principal
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel, "panelPrincipal");
		panel.setLayout(new MigLayout("", "[grow]", "[40.00][][32.00][41.00][36.00]"));
		
		//Declaração e atributos do label de título do programa
		JLabel lblTitulo = new JLabel("Formul\u00E1rio de Inscri\u00E7\u00E3o para Inicia\u00E7\u00E3o Cient\u00EDfica Volunt\u00E1ria");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 19));
		panel.add(lblTitulo, "cell 0 0,alignx center,aligny top");
		
		//Declaração do label de logo da ufcspa
		JLabel lblLogoUfcspa = new JLabel("");
		lblLogoUfcspa.setBounds(0, 0, 180, 90);
		
		//Mecanismo para redimensionar a imagem
		try {
			lblLogoUfcspa.setIcon(new ImageIcon(ImageIO.read(JanelaPrincipal.class.getResource("/imagens/informatica-biomedica.png")).getScaledInstance(lblLogoUfcspa.getWidth(), lblLogoUfcspa.getHeight(), BufferedImage.TYPE_INT_RGB)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panel.add(lblLogoUfcspa, "cell 0 1,alignx center");
		
		//Botão de Login
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		/*btnLogin.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {				
				
				jl = new JanelaLogin();
				contentPane.add(jl, "telaLogin");
				CardLayout cl = (CardLayout) contentPane.getLayout();
	            cl.show(contentPane, "telaLogin");	            
			
			}
		});*/
		btnLogin.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/imagens/icon-login.png")));
		panel.add(btnLogin, "cell 0 3,alignx center,aligny center");
		
		//Botão de cadastro
		btnCadastro = new JButton("Cadastrar-se");
		/*btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jc = new JanelaCadastro();
				contentPane.add(jc, "telaCadastro");
				CardLayout cl = (CardLayout) contentPane.getLayout();
				cl.show(contentPane, "telaCadastro");
				
			}
		});*/
		btnCadastro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCadastro.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/imagens/icon-cadastro.png")));
		panel.add(btnCadastro, "cell 0 4,alignx center");
		
		// Painel de Login
		JPanel paneLogin = new JPanel();
		contentPane.add(paneLogin, "telaLogin");
		paneLogin.setLayout(new MigLayout("", "[]", "[][][][][][][][][]"));
		
		JLabel lblTituloLogin = new JLabel("LOGIN");
		paneLogin.add(lblTituloLogin, "cell 0 0");
		
		btnLogar = new JButton("Logar");
		paneLogin.add(btnLogar, "cell 0 8");
		
		// Painel de Cadastro
		JPanel panelCadastro = new JPanel();
		contentPane.add(panelCadastro, "telaCadastro");
		panelCadastro.setLayout(new MigLayout("", "[]", "[]"));
		
		JLabel lblTituloCadastro = new JLabel("CADASTRO");
		panelCadastro.add(lblTituloCadastro, "cell 0 0");
		
		// Painel do Formulario
		JPanel panelFormulario = new JPanel();
		contentPane.add(panelFormulario, "telaFormulario");
		panelFormulario.setLayout(new MigLayout("", "[]", "[]"));
		
		JLabel lblTituloFormulario = new JLabel("FORMULARIO");
		panelFormulario.add(lblTituloFormulario, "cell 0 0");
	}

	public JMenuItem getItemSair() {
		return itemSair;
	}

	public void setItemSair(JMenuItem itemSair) {
		this.itemSair = itemSair;
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

	public JButton getBtnLogar() {
		return btnLogar;
	}

	public void setBtnLogar(JButton btnLogar) {
		this.btnLogar = btnLogar;
	}

}
