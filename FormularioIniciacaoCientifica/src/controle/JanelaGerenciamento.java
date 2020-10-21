package controle;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JButton;

public class JanelaGerenciamento extends JPanel {
	private JTextField fieldInformeId;
	private JTable tabelaInscricao;
	private final String colunas[] = {"ID_Inscricao", "Aluno", "Projeto", "Orientador"};
//	private final Object linhas[][] = {};
	
	/**
	 * Create the panel.
	 */
	public JanelaGerenciamento() {
		setLayout(new MigLayout("", "[21.00,grow]", "[][][][grow]"));
		
		JLabel lblTituloGerenciamento = new JLabel("Gerenciamento de Inscri\u00E7\u00F5es");
		lblTituloGerenciamento.setFont(new Font("Arial", Font.BOLD, 19));
		add(lblTituloGerenciamento, "cell 0 0");
		
		JLabel lblInformeId = new JLabel("Informe o ID da inscri\u00E7\u00E3o");
		add(lblInformeId, "flowx,cell 0 2");
		
		fieldInformeId = new JTextField();
		add(fieldInformeId, "cell 0 2");
		fieldInformeId.setColumns(10);
		
		JButton btnDeletarInscricao = new JButton("Deletar");
		add(btnDeletarInscricao, "cell 0 2");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 3,grow");
		
		TableModel tableModel = new DefaultTableModel(colunas, 0);
		
		tabelaInscricao = new JTable(tableModel);
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

}
