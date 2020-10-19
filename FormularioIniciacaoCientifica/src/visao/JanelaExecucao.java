package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class JanelaExecucao extends JFrame {

	private JPanel contentPane;
	private JMenuItem itemNovoForm;
	private JMenuItem itemMenuPrincipal;
	private JMenuItem itemSair;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaExecucao frame = new JanelaExecucao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JanelaExecucao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		itemNovoForm = new JMenuItem("Realizar nova inscri\u00E7\u00E3o");
		itemNovoForm.setActionCommand("novoForm");
		itemNovoForm.setIcon(new ImageIcon(JanelaExecucao.class.getResource("/imagens/icon-inscricao.png")));
		mnArquivo.add(itemNovoForm);
		
		itemMenuPrincipal = new JMenuItem("Menu principal");
		itemMenuPrincipal.setIcon(new ImageIcon(JanelaExecucao.class.getResource("/imagens/icon-home.png")));
		mnArquivo.add(itemMenuPrincipal);
		
		itemSair = new JMenuItem("Sair");
		itemSair.setIcon(new ImageIcon(JanelaExecucao.class.getResource("/imagens/exit.png")));
		mnArquivo.add(itemSair);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[214.00,grow][grow]", "[grow]"));
		
		JLabel lblUfcspa = new JLabel("");
		lblUfcspa.setBounds(0, 0, 140, 70);
		try {
			lblUfcspa.setIcon(new ImageIcon(ImageIO.read(JanelaPrincipal.class.getResource("/imagens/informatica-biomedica.png")).getScaledInstance(lblUfcspa.getWidth(), lblUfcspa.getHeight(), BufferedImage.TYPE_INT_RGB)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		contentPane.add(lblUfcspa, "flowx,cell 0 0,alignx center");
		
		JLabel lblBemVindo = new JLabel("Bem-vindo,");
		lblBemVindo.setFont(new Font("Arial", Font.BOLD, 19));
		contentPane.add(lblBemVindo, "flowx,cell 1 0");
		
		JLabel lblNomeUser = new JLabel("Pedrao");
		lblNomeUser.setFont(new Font("Arial", Font.BOLD, 19));
		contentPane.add(lblNomeUser, "cell 1 0");
	}

	public JMenuItem getItemNovoForm() {
		return itemNovoForm;
	}

	public void setItemNovoForm(JMenuItem itemNovoForm) {
		this.itemNovoForm = itemNovoForm;
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
