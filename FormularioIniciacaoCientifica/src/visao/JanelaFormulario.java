package visao;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaFormulario extends JPanel {
	private JTextField fieldNomeAluno;
	private JTextField fieldInstituicao;
	private JRadioButton rdbtnUFCSPA;
	private JRadioButton rdbtnOutra;
	private JLabel lblInstituicao;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField fieldEmailAluno;

	public JanelaFormulario() {
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
		add(tabbedPane, BorderLayout.CENTER);
		
		JPanel pnlDadosAluno = new JPanel();
		pnlDadosAluno.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Dados do aluno", null, pnlDadosAluno, null);
		pnlDadosAluno.setLayout(new MigLayout("", "[][252.00,grow]", "[][][30.00][31.00][23.00]"));
		
		JLabel lblTituloDadosAluno = new JLabel("Dados do Aluno: ");
		lblTituloDadosAluno.setFont(new Font("Arial", Font.BOLD, 19));
		pnlDadosAluno.add(lblTituloDadosAluno, "cell 0 0");
		
		JLabel lblNomeAluno = new JLabel("Nome: ");
		lblNomeAluno.setFont(new Font("Arial", Font.BOLD, 13));
		pnlDadosAluno.add(lblNomeAluno, "flowx,cell 0 2,alignx left,spanx 2");
		
		fieldNomeAluno = new JTextField();
		pnlDadosAluno.add(fieldNomeAluno, "cell 0 2 2 1,growx");
		fieldNomeAluno.setColumns(10);
		
		lblInstituicao = new JLabel("Institui\u00E7\u00E3o:");
		lblInstituicao.setFont(new Font("Arial", Font.BOLD, 13));
		pnlDadosAluno.add(lblInstituicao, "flowx,cell 0 3,alignx trailing");
		
		rdbtnUFCSPA = new JRadioButton("UFCPSA");
		rdbtnUFCSPA.setIcon(new ImageIcon(JanelaExecucao.class.getResource("/imagens/icon-ufcspa-quadrado.png")));
		buttonGroup.add(rdbtnUFCSPA);
		pnlDadosAluno.add(rdbtnUFCSPA, "cell 0 3");
		
		rdbtnOutra = new JRadioButton("Outra");
		buttonGroup.add(rdbtnOutra);
		pnlDadosAluno.add(rdbtnOutra, "cell 0 3");
		
		fieldInstituicao = new JTextField();		
		pnlDadosAluno.add(fieldInstituicao, "cell 1 3,growx");
		fieldInstituicao.setColumns(10);
		
		JLabel lblEmailAluno = new JLabel("Email:");
		lblEmailAluno.setFont(new Font("Arial", Font.BOLD, 13));
		pnlDadosAluno.add(lblEmailAluno, "flowx,cell 0 4 2 1, spanx 2");
		
		fieldEmailAluno = new JTextField();
		pnlDadosAluno.add(fieldEmailAluno, "cell 0 4");
		fieldEmailAluno.setColumns(10);
		
		rdbtnUFCSPA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnUFCSPA.isSelected()) {
					fieldInstituicao.setEnabled(false);
					fieldInstituicao.setBackground(Color.LIGHT_GRAY);
				}
			}
		});
		
		rdbtnOutra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnOutra.isSelected()) {
					fieldInstituicao.setEnabled(true);
					fieldInstituicao.setBackground(Color.WHITE);
				}
			}
		});
		
		JPanel pnlDadosProjeto = new JPanel();
		pnlDadosProjeto.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Dados do projeto", null, pnlDadosProjeto, null);
		
		JPanel pnlDadosProf = new JPanel();
		pnlDadosProf.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Dados do professor orientador", null, pnlDadosProf, null);
		
	}

}
