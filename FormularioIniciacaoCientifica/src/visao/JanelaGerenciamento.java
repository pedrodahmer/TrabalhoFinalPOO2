package visao;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JanelaGerenciamento extends JPanel {
	private JTextField fieldInformeId;
	private JTable tabelaInscricao;
	private final String colunas[] = { "ID_Inscricao", "Aluno", "Projeto", "Orientador" };
	private JButton btnExcluirInscricao;

	/**
	 * Create the panel.
	 */
	public JanelaGerenciamento() {
		setLayout(new MigLayout("", "[21.00,grow]", "[][][][grow]"));

		JLabel lblTituloGerenciamento = new JLabel("Gerenciamento de Inscri\u00E7\u00F5es");
		lblTituloGerenciamento.setFont(new Font("Arial", Font.BOLD, 19));
		add(lblTituloGerenciamento, "cell 0 0");

		JLabel lblInformeId = new JLabel("Selecione o ID da inscri\u00E7\u00E3o");
		lblInformeId.setFont(new Font("Arial", Font.PLAIN, 12));
		add(lblInformeId, "flowx,cell 0 2");

		fieldInformeId = new JTextField();
		add(fieldInformeId, "cell 0 2");
		fieldInformeId.setColumns(10);

		btnExcluirInscricao = new JButton("Excluir");
		btnExcluirInscricao.setActionCommand("excluirInscricao");
		btnExcluirInscricao.setFont(new Font("Arial", Font.PLAIN, 12));
		add(btnExcluirInscricao, "cell 0 2");

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 3,grow");

		TableModel tableModel = new DefaultTableModel(colunas, 0);

		tabelaInscricao = new JTable(tableModel);
		tabelaInscricao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				fieldInformeId.setText(tabelaInscricao.getValueAt(tabelaInscricao.getSelectedRow(), 0).toString());

			}
		});
		scrollPane.setViewportView(tabelaInscricao);

	}

	public JTextField getFieldInformeId() {
		return fieldInformeId;
	}

	public void setFieldInformeId(JTextField fieldInformeId) {
		this.fieldInformeId = fieldInformeId;
	}

	public JTable getTabelaInscricao() {
		return tabelaInscricao;
	}

	public void setTabelaInscricao(JTable tabelaInscricao) {
		this.tabelaInscricao = tabelaInscricao;
	}

	public JButton getBtnExcluirInscricao() {
		return btnExcluirInscricao;
	}

	public void setBtnExcluirInscricao(JButton btnExcluirInscricao) {
		this.btnExcluirInscricao = btnExcluirInscricao;
	}

	// Caixas de dialogo
	public void avisoCampoIdVazio() {
		JOptionPane.showMessageDialog(this, "Selecione uma inscrição na tabela!", "Aviso", JOptionPane.WARNING_MESSAGE);
	}

	public void avisoResultadoExclusao(boolean sinal) {

		if (sinal) {
			JOptionPane.showMessageDialog(this, "Inscrição excluída!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, "Não foi possível excluir a inscrição", "Erro",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public int avisoExclusao() {
		int resposta = JOptionPane.showConfirmDialog(this,
				"Excluir a inscrição excluirá o aluno, orientador e projeto. Prosseguir?", "Aviso",
				JOptionPane.WARNING_MESSAGE);

		return resposta;
	}

}
