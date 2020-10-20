package visao;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class JanelaFormulario extends JPanel {
	private JTextField fieldNomeAluno;
	private JTextField fieldInstituicao;
	private JRadioButton rdbtnUFCSPA;
	private JRadioButton rdbtnOutra;
	private JLabel lblInstituicao;
	private ButtonGroup grupoInstituicao = new ButtonGroup();
	private JTextField fieldEmailAluno;
	private JTextField fieldCursoAluno;
	private JTextField fieldSerieAluno;
	private JTextField fieldRGAluno;
	private JTextField fieldCPFAluno;
	private JTextField fieldCargaHoraria;
	private JButton btnAnexarDocs;
	private JTextField fieldTituloProjeto;
	private JTextField fieldGrupoPesquisa;
	private JTextField fieldLocalProjeto;
	private JRadioButton rdbtnFaseFinal, rdbtnFaseIntermediaria, rdbtnFaseInicial;
	private JButton btnAnexarPlano, btnAnexarParecer;
	private ButtonGroup grupoFaseProjeto = new ButtonGroup();
	private JLabel lblTituloDadosOrientador;
	private JLabel lblNomeOrientador;
	private JTextField fieldNomeOrientador;
	private JLabel lblDepartamentoOrientador;
	private JTextField fieldDepartamentoOrientador;
	private JLabel lblEmailOrientador;
	private JTextField fieldEmailOrientador;
	private JLabel lblRamalOrientador;
	private JTextField fieldRamalOrientador;
	private JLabel lblTelefoneOrientador;
	private JTextField fieldCelularOrientador;
	private JButton btnFinalizar;
	private JButton btnAnexarHistEscolar;

	public JanelaFormulario() {
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
		add(tabbedPane, BorderLayout.CENTER);
		
		JPanel pnlDadosAluno = new JPanel();
		pnlDadosAluno.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Dados do aluno", new ImageIcon(JanelaExecucao.class.getResource("/imagens/icon-aluno.png")), 
				pnlDadosAluno, 
				null);
		pnlDadosAluno.setLayout(new MigLayout("", "[][252.00,grow]", "[][10.00][30.00][31.00][23.00][26.00][29.00][][]"));
		
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
		pnlDadosAluno.add(lblInstituicao, "flowx,cell 0 3,alignx left,spanx 2");
		
		rdbtnUFCSPA = new JRadioButton("UFCPSA");
		rdbtnUFCSPA.setBackground(Color.LIGHT_GRAY);
		rdbtnUFCSPA.setIcon(new ImageIcon(JanelaExecucao.class.getResource("/imagens/icon-ufcspa-quadrado.png")));
		grupoInstituicao.add(rdbtnUFCSPA);
		rdbtnUFCSPA.setSelected(true);
		pnlDadosAluno.add(rdbtnUFCSPA, "cell 0 3");
		
		rdbtnOutra = new JRadioButton("Outra");
		rdbtnOutra.setBackground(Color.LIGHT_GRAY);
		grupoInstituicao.add(rdbtnOutra);
		pnlDadosAluno.add(rdbtnOutra, "cell 0 3");
		
		JLabel lblEmailAluno = new JLabel("Email:");
		lblEmailAluno.setFont(new Font("Arial", Font.BOLD, 13));
		pnlDadosAluno.add(lblEmailAluno, "flowx,cell 0 4 2 1");
		
		fieldEmailAluno = new JTextField();
		pnlDadosAluno.add(fieldEmailAluno, "cell 0 4 2 1,growx");
		fieldEmailAluno.setColumns(10);
		
		JLabel lblCursoAluno = new JLabel("Curso:");
		lblCursoAluno.setFont(new Font("Arial", Font.BOLD, 13));
		pnlDadosAluno.add(lblCursoAluno, "flowx,cell 0 5");
		
		fieldCursoAluno = new JTextField();
		pnlDadosAluno.add(fieldCursoAluno, "cell 0 5,growx");
		fieldCursoAluno.setColumns(10);
		
		JLabel lblSerie = new JLabel("S\u00E9rie:");
		lblSerie.setFont(new Font("Arial", Font.BOLD, 13));
		pnlDadosAluno.add(lblSerie, "flowx,cell 1 5");
		
		fieldSerieAluno = new JTextField();
		pnlDadosAluno.add(fieldSerieAluno, "cell 1 5,growx");
		fieldSerieAluno.setColumns(10);
		
		JLabel lblRGAluno = new JLabel("RG:");
		lblRGAluno.setFont(new Font("Arial", Font.BOLD, 13));
		pnlDadosAluno.add(lblRGAluno, "flowx,cell 0 6");
		
		fieldRGAluno = new JTextField();
		pnlDadosAluno.add(fieldRGAluno, "cell 0 6,growx");
		fieldRGAluno.setColumns(10);
		
		JLabel lblCPFAluno = new JLabel("CPF:");
		lblCPFAluno.setFont(new Font("Arial", Font.BOLD, 13));
		pnlDadosAluno.add(lblCPFAluno, "flowx,cell 1 6");
		
		fieldCPFAluno = new JTextField();
		pnlDadosAluno.add(fieldCPFAluno, "cell 1 6,growx");
		fieldCPFAluno.setColumns(10);
		
		JLabel lblCargaHoraria = new JLabel("Carga hor\u00E1ria semanal:");
		lblCargaHoraria.setFont(new Font("Arial", Font.BOLD, 13));
		pnlDadosAluno.add(lblCargaHoraria, "flowx,cell 0 7");
		
		fieldCargaHoraria = new JTextField();
		pnlDadosAluno.add(fieldCargaHoraria, "cell 0 7");
		fieldCargaHoraria.setColumns(10);
		
		btnAnexarDocs = new JButton("Anexar RG e CPF");
		btnAnexarDocs.setActionCommand("anexarDocs");
		btnAnexarDocs.setVisible(false);
		pnlDadosAluno.add(btnAnexarDocs, "flowx,cell 1 7,growx");
		
		JLabel lblDocsAdicionais = new JLabel("(Hist\u00F3rico escolar, RG E CPF)");
		lblDocsAdicionais.setVisible(false);
		pnlDadosAluno.add(lblDocsAdicionais, "cell 1 8,alignx center");
		
		fieldInstituicao = new JTextField();	
		fieldInstituicao.setBackground(Color.LIGHT_GRAY);
		pnlDadosAluno.add(fieldInstituicao, "cell 0 3,growx");
		fieldInstituicao.setColumns(10);
		
		btnAnexarHistEscolar = new JButton("Anexar Hist\u00F3rico Escolar");
		pnlDadosAluno.add(btnAnexarHistEscolar, "cell 1 7,growx");
		
		rdbtnUFCSPA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnUFCSPA.isSelected()) {
					fieldInstituicao.setEnabled(false);
					fieldInstituicao.setBackground(Color.LIGHT_GRAY);
					
					btnAnexarDocs.setVisible(false);
					btnAnexarHistEscolar.setVisible(false);
					lblDocsAdicionais.setVisible(false);
				}
			}
		});
		
		rdbtnOutra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnOutra.isSelected()) {
					fieldInstituicao.setEnabled(true);
					fieldInstituicao.setBackground(Color.WHITE);
					
					btnAnexarDocs.setVisible(true);
					btnAnexarHistEscolar.setVisible(true);
					lblDocsAdicionais.setVisible(true);
				}
			}
		});
		
		JPanel pnlDadosProjeto = new JPanel();
		pnlDadosProjeto.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Dados do projeto", new ImageIcon(JanelaExecucao.class.getResource("/imagens/icon-orientador.png")),
				pnlDadosProjeto,
				null);
		pnlDadosProjeto.setLayout(new MigLayout("", "[258.00,grow][grow]", "[][][28.00][27.00][][][23.00][25.00]"));
		
		JLabel lblTituloDadosProjeto = new JLabel("Dados do Projeto: ");
		lblTituloDadosProjeto.setFont(new Font("Arial", Font.BOLD, 19));
		pnlDadosProjeto.add(lblTituloDadosProjeto, "cell 0 0");
		
		JLabel lblTituloProjeto = new JLabel("T\u00EDtulo:");
		lblTituloProjeto.setFont(new Font("Arial", Font.BOLD, 13));
		pnlDadosProjeto.add(lblTituloProjeto, "flowx,cell 0 2, spanx 2");
		
		fieldTituloProjeto = new JTextField();
		pnlDadosProjeto.add(fieldTituloProjeto, "cell 0 2 2 1,growx");
		fieldTituloProjeto.setColumns(10);
		
		JLabel lblGrupoPesquisaProjeto = new JLabel("Grupo de pesquisa:");
		lblGrupoPesquisaProjeto.setFont(new Font("Arial", Font.BOLD, 13));
		pnlDadosProjeto.add(lblGrupoPesquisaProjeto, "flowx,cell 0 3 2 1");
		
		fieldGrupoPesquisa = new JTextField();
		fieldGrupoPesquisa.setColumns(10);
		pnlDadosProjeto.add(fieldGrupoPesquisa, "cell 0 3 2 1,growx");
		
		JLabel lblParecerProjeto = new JLabel("Parecer do CEP/CEUA (quando cab\u00EDvel)");
		lblParecerProjeto.setFont(new Font("Arial", Font.BOLD, 13));
		pnlDadosProjeto.add(lblParecerProjeto, "flowx,cell 0 4, spanx 2");
		
		btnAnexarParecer = new JButton("Anexar documento");
		btnAnexarParecer.setActionCommand("anexarParecer");
		pnlDadosProjeto.add(btnAnexarParecer, "cell 0 4 2 1,grow");
		
		JLabel lblPlanoTrabalho = new JLabel("Plano de trabalho:");
		lblPlanoTrabalho.setFont(new Font("Arial", Font.BOLD, 13));
		pnlDadosProjeto.add(lblPlanoTrabalho, "flowx,cell 0 5");
		
		btnAnexarPlano = new JButton("Anexar documento");
		btnAnexarPlano.setActionCommand("anexarPlanoTrabalho");
		pnlDadosProjeto.add(btnAnexarPlano, "cell 0 5,growx");
		
		JLabel lblLocalProjeto = new JLabel("Unidade (Depto, Lab., etc):");
		lblLocalProjeto.setFont(new Font("Arial", Font.BOLD, 13));
		pnlDadosProjeto.add(lblLocalProjeto, "flowx,cell 0 6, spanx 2");
		
		fieldLocalProjeto = new JTextField();
		fieldLocalProjeto.setColumns(10);
		pnlDadosProjeto.add(fieldLocalProjeto, "cell 0 6 2 1,growx");
		
		JLabel lblFaseProjeto = new JLabel("Plano de trabalho:");
		lblFaseProjeto.setFont(new Font("Arial", Font.BOLD, 13));
		pnlDadosProjeto.add(lblFaseProjeto, "flowx,cell 0 7");
		
		rdbtnFaseInicial = new JRadioButton("Inicial");
		rdbtnFaseInicial.setBackground(Color.LIGHT_GRAY);
		grupoFaseProjeto.add(rdbtnFaseInicial);
		pnlDadosProjeto.add(rdbtnFaseInicial, "cell 0 7");
		
		rdbtnFaseIntermediaria = new JRadioButton("Intermedi\u00E1ria");
		rdbtnFaseIntermediaria.setBackground(Color.LIGHT_GRAY);
		grupoFaseProjeto.add(rdbtnFaseIntermediaria);
		pnlDadosProjeto.add(rdbtnFaseIntermediaria, "cell 0 7");
		
		rdbtnFaseFinal = new JRadioButton("Final");
		rdbtnFaseFinal.setBackground(Color.LIGHT_GRAY);
		grupoFaseProjeto.add(rdbtnFaseFinal);
		pnlDadosProjeto.add(rdbtnFaseFinal, "cell 0 7");
		
		JPanel pnlDadosProf = new JPanel();
		pnlDadosProf.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Dados do professor orientador", new ImageIcon(JanelaExecucao.class.getResource("/imagens/icon-projeto.png")), 
				pnlDadosProf, 
				null);
		pnlDadosProf.setLayout(new MigLayout("", "[][grow]", "[][][28.00][27.00][23.00][][]"));
		
		lblTituloDadosOrientador = new JLabel("Dados do Orientador: ");
		lblTituloDadosOrientador.setFont(new Font("Arial", Font.BOLD, 19));
		pnlDadosProf.add(lblTituloDadosOrientador, "cell 0 0");
		
		lblNomeOrientador = new JLabel("Nome:");
		lblNomeOrientador.setFont(new Font("Arial", Font.BOLD, 13));
		pnlDadosProf.add(lblNomeOrientador, "flowx,cell 0 2,alignx left, spanx 2");
		
		fieldNomeOrientador = new JTextField();
		pnlDadosProf.add(fieldNomeOrientador, "cell 0 2 2 1,growx");
		fieldNomeOrientador.setColumns(10);
		
		lblDepartamentoOrientador = new JLabel("Depto./PPG:");
		lblDepartamentoOrientador.setFont(new Font("Arial", Font.BOLD, 13));
		pnlDadosProf.add(lblDepartamentoOrientador, "flowx,cell 0 3");
		
		fieldDepartamentoOrientador = new JTextField();
		pnlDadosProf.add(fieldDepartamentoOrientador, "cell 0 3,growx");
		fieldDepartamentoOrientador.setColumns(10);
		
		lblEmailOrientador = new JLabel("Email:");
		lblEmailOrientador.setFont(new Font("Arial", Font.BOLD, 13));
		pnlDadosProf.add(lblEmailOrientador, "flowx,cell 1 3");
		
		fieldEmailOrientador = new JTextField();
		pnlDadosProf.add(fieldEmailOrientador, "cell 1 3,growx");
		fieldEmailOrientador.setColumns(10);
		
		lblRamalOrientador = new JLabel("Ramal:");
		lblRamalOrientador.setFont(new Font("Arial", Font.BOLD, 13));
		pnlDadosProf.add(lblRamalOrientador, "flowx,cell 0 4");
		
		fieldRamalOrientador = new JTextField();
		pnlDadosProf.add(fieldRamalOrientador, "cell 0 4,growx");
		fieldRamalOrientador.setColumns(10);
		
		lblTelefoneOrientador = new JLabel("Telefone celular:");
		lblTelefoneOrientador.setFont(new Font("Arial", Font.BOLD, 13));
		pnlDadosProf.add(lblTelefoneOrientador, "flowx,cell 1 4");
		
		fieldCelularOrientador = new JTextField();
		pnlDadosProf.add(fieldCelularOrientador, "cell 1 4,growx");
		fieldCelularOrientador.setColumns(10);
		
		btnFinalizar = new JButton("Finalizar inscri\u00E7\u00E3o");
		btnFinalizar.setActionCommand("finalizarInscricao");
		pnlDadosProf.add(btnFinalizar, "cell 0 6,growx, spanx 2");
		
	}

	public JTextField getFieldNomeAluno() {
		return fieldNomeAluno;
	}

	public void setFieldNomeAluno(JTextField fieldNomeAluno) {
		this.fieldNomeAluno = fieldNomeAluno;
	}

	public JTextField getFieldInstituicao() {
		return fieldInstituicao;
	}

	public void setFieldInstituicao(JTextField fieldInstituicao) {
		this.fieldInstituicao = fieldInstituicao;
	}

	public JRadioButton getRdbtnUFCSPA() {
		return rdbtnUFCSPA;
	}

	public void setRdbtnUFCSPA(JRadioButton rdbtnUFCSPA) {
		this.rdbtnUFCSPA = rdbtnUFCSPA;
	}

	public JRadioButton getRdbtnOutra() {
		return rdbtnOutra;
	}

	public void setRdbtnOutra(JRadioButton rdbtnOutra) {
		this.rdbtnOutra = rdbtnOutra;
	}

	public JLabel getLblInstituicao() {
		return lblInstituicao;
	}

	public void setLblInstituicao(JLabel lblInstituicao) {
		this.lblInstituicao = lblInstituicao;
	}

	public JTextField getFieldEmailAluno() {
		return fieldEmailAluno;
	}

	public void setFieldEmailAluno(JTextField fieldEmailAluno) {
		this.fieldEmailAluno = fieldEmailAluno;
	}

	public JTextField getFieldCursoAluno() {
		return fieldCursoAluno;
	}

	public void setFieldCursoAluno(JTextField fieldCursoAluno) {
		this.fieldCursoAluno = fieldCursoAluno;
	}

	public JTextField getFieldSerieAluno() {
		return fieldSerieAluno;
	}

	public void setFieldSerieAluno(JTextField fieldSerieAluno) {
		this.fieldSerieAluno = fieldSerieAluno;
	}

	public JTextField getFieldRGAluno() {
		return fieldRGAluno;
	}

	public void setFieldRGAluno(JTextField fieldRGAluno) {
		this.fieldRGAluno = fieldRGAluno;
	}

	public JTextField getFieldCPFAluno() {
		return fieldCPFAluno;
	}

	public void setFieldCPFAluno(JTextField fieldCPFAluno) {
		this.fieldCPFAluno = fieldCPFAluno;
	}

	public JTextField getFieldCargaHoraria() {
		return fieldCargaHoraria;
	}

	public void setFieldCargaHoraria(JTextField fieldCargaHoraria) {
		this.fieldCargaHoraria = fieldCargaHoraria;
	}

	public JButton getBtnAnexarDocs() {
		return btnAnexarDocs;
	}

	public void setBtnAnexarDocs(JButton btnAnexarDocs) {
		this.btnAnexarDocs = btnAnexarDocs;
	}

	public JTextField getFieldTituloProjeto() {
		return fieldTituloProjeto;
	}

	public void setFieldTituloProjeto(JTextField fieldTituloProjeto) {
		this.fieldTituloProjeto = fieldTituloProjeto;
	}

	public JTextField getFieldGrupoPesquisa() {
		return fieldGrupoPesquisa;
	}

	public void setFieldGrupoPesquisa(JTextField fieldGrupoPesquisa) {
		this.fieldGrupoPesquisa = fieldGrupoPesquisa;
	}

	public JTextField getFieldLocalProjeto() {
		return fieldLocalProjeto;
	}

	public void setFieldLocalProjeto(JTextField fieldLocalProjeto) {
		this.fieldLocalProjeto = fieldLocalProjeto;
	}

	public JRadioButton getRdbtnFaseFinal() {
		return rdbtnFaseFinal;
	}

	public void setRdbtnFaseFinal(JRadioButton rdbtnFaseFinal) {
		this.rdbtnFaseFinal = rdbtnFaseFinal;
	}

	public JRadioButton getRdbtnFaseIntermediaria() {
		return rdbtnFaseIntermediaria;
	}

	public void setRdbtnFaseIntermediaria(JRadioButton rdbtnFaseIntermediaria) {
		this.rdbtnFaseIntermediaria = rdbtnFaseIntermediaria;
	}

	public JRadioButton getRdbtnFaseInicial() {
		return rdbtnFaseInicial;
	}

	public void setRdbtnFaseInicial(JRadioButton rdbtnFaseInicial) {
		this.rdbtnFaseInicial = rdbtnFaseInicial;
	}

	public JButton getBtnAnexarPlano() {
		return btnAnexarPlano;
	}

	public void setBtnAnexarPlano(JButton btnAnexarPlano) {
		this.btnAnexarPlano = btnAnexarPlano;
	}

	public JButton getBtnAnexarParecer() {
		return btnAnexarParecer;
	}

	public void setBtnAnexarParecer(JButton btnAnexarParecer) {
		this.btnAnexarParecer = btnAnexarParecer;
	}

	public JTextField getFieldNomeOrientador() {
		return fieldNomeOrientador;
	}

	public void setFieldNomeOrientador(JTextField fieldNomeOrientador) {
		this.fieldNomeOrientador = fieldNomeOrientador;
	}

	public JTextField getFieldDepartamentoOrientador() {
		return fieldDepartamentoOrientador;
	}

	public void setFieldDepartamentoOrientador(JTextField fileldDepartamentoOrientador) {
		this.fieldDepartamentoOrientador = fileldDepartamentoOrientador;
	}

	public JTextField getFieldEmailOrientador() {
		return fieldEmailOrientador;
	}

	public void setFieldEmailOrientador(JTextField fieldEmailOrientador) {
		this.fieldEmailOrientador = fieldEmailOrientador;
	}

	public JTextField getFieldRamalOrientador() {
		return fieldRamalOrientador;
	}

	public void setFieldRamalOrientador(JTextField fieldRamalOrientador) {
		this.fieldRamalOrientador = fieldRamalOrientador;
	}

	public JTextField getFieldCelularOrientador() {
		return fieldCelularOrientador;
	}

	public void setFieldCelularOrientador(JTextField fieldCelularOrientador) {
		this.fieldCelularOrientador = fieldCelularOrientador;
	}

	public JButton getBtnFinalizar() {
		return btnFinalizar;
	}

	public void setBtnFinalizar(JButton btnFinalizar) {
		this.btnFinalizar = btnFinalizar;
	}

	public ButtonGroup getGrupoInstituicao() {
		return grupoInstituicao;
	}

	public void setGrupoInstituicao(ButtonGroup grupoInstituicao) {
		this.grupoInstituicao = grupoInstituicao;
	}

	public ButtonGroup getGrupoFaseProjeto() {
		return grupoFaseProjeto;
	}

	public void setGrupoFaseProjeto(ButtonGroup grupoFaseProjeto) {
		this.grupoFaseProjeto = grupoFaseProjeto;
	}

	public JLabel getLblTituloDadosOrientador() {
		return lblTituloDadosOrientador;
	}

	public void setLblTituloDadosOrientador(JLabel lblTituloDadosOrientador) {
		this.lblTituloDadosOrientador = lblTituloDadosOrientador;
	}

	public JLabel getLblNomeOrientador() {
		return lblNomeOrientador;
	}

	public void setLblNomeOrientador(JLabel lblNomeOrientador) {
		this.lblNomeOrientador = lblNomeOrientador;
	}

	public JLabel getLblDepartamentoOrientador() {
		return lblDepartamentoOrientador;
	}

	public void setLblDepartamentoOrientador(JLabel lblDepartamentoOrientador) {
		this.lblDepartamentoOrientador = lblDepartamentoOrientador;
	}

	public JLabel getLblEmailOrientador() {
		return lblEmailOrientador;
	}

	public void setLblEmailOrientador(JLabel lblEmailOrientador) {
		this.lblEmailOrientador = lblEmailOrientador;
	}

	public JLabel getLblRamalOrientador() {
		return lblRamalOrientador;
	}

	public void setLblRamalOrientador(JLabel lblRamalOrientador) {
		this.lblRamalOrientador = lblRamalOrientador;
	}

	public JLabel getLblTelefoneOrientador() {
		return lblTelefoneOrientador;
	}

	public void setLblTelefoneOrientador(JLabel lblTelefoneOrientador) {
		this.lblTelefoneOrientador = lblTelefoneOrientador;
	}

	public JButton getBtnAnexarHistEscolar() {
		return btnAnexarHistEscolar;
	}

	public void setBtnAnexarHistEscolar(JButton btnAnexarHistEscolar) {
		this.btnAnexarHistEscolar = btnAnexarHistEscolar;
	}
	
	// Caixas de dialogo
	public void avisoDoc(boolean sinal) {
		
		if(sinal) {
			JOptionPane.showMessageDialog(this, "Documento anexado!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
}
