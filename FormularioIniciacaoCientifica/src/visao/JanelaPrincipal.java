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

public class JanelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JanelaLogin jl;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrincipal frame = new JanelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Elementos da Janela Principal
	public JanelaPrincipal() {
		setTitle("Formul\u00E1rio de inscri\u00E7\u00E3o para IC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel, "name_100053754431500");
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
		JButton btnLogin = new JButton("Logar");
		btnLogin.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				jl = new JanelaLogin();
				
				CardLayout cl = (CardLayout) contentPane.getLayout();
	            cl.show(contentPane, "telaLogin");
			}
		});
		btnLogin.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/imagens/icon-login.png")));
		panel.add(btnLogin, "cell 0 3,alignx center,aligny center");
		
		//Botão de cadastro
		JButton btnCadastro = new JButton("Cadastrar-se");
		btnCadastro.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/imagens/icon-cadastro.png")));
		panel.add(btnCadastro, "cell 0 4,alignx center");
	}

}
