package visao;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class JanelaSelecao extends JPanel {

	private JLabel lblUsuarioLogado;
	
	
	public JanelaSelecao() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(new MigLayout("", "[][][][12.00][133.00][][][]", "[][][][][31.00][25.00][]"));
		
		JLabel lblBemVindo = new JLabel("Bem-vindo");
		lblBemVindo.setFont(new Font("Arial", Font.BOLD, 19));
		add(lblBemVindo, "cell 4 4");
		
		lblUsuarioLogado = new JLabel("");
		lblUsuarioLogado.setFont(new Font("Arial", Font.BOLD, 19));
		add(lblUsuarioLogado, "cell 5 4");
		
		JLabel lblInstrucao = new JLabel("Selecione Arquivo/Novo formul\u00E1rio para preencher um novo formul\u00E1rio");
		add(lblInstrucao, "cell 4 5 2097051 1,alignx center,aligny center");

	}


	public JLabel getLblUsuarioLogado() {
		return lblUsuarioLogado;
	}


	public void setLblUsuarioLogado(JLabel lblUsuarioLogado) {
		this.lblUsuarioLogado = lblUsuarioLogado;
	}

}
