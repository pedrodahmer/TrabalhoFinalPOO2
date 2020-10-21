package controle;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import dao.InscricaoDAO;
import modelo.Inscricao;
import visao.JanelaGerenciamento;

public class JanelaGerenciamentoControle {

	private InscricaoDAO inscricaoDao = new InscricaoDAO();
	
	public JanelaGerenciamentoControle() {};
	
	public void preencherTabela(JanelaGerenciamento jg) {
		
		ArrayList<Inscricao> inscricoes;
		
		inscricoes = inscricaoDao.obterInscricoes();
		
		DefaultTableModel tabelaModelo = (DefaultTableModel) jg.getTabelaInscricao().getModel();
		
		tabelaModelo.setRowCount(0);
		
		Object registro[] = new Object[4];
		
		for(int i = 0; i < inscricoes.size(); i++) {
			registro[0] = inscricoes.get(i).getId_inscricao();
			registro[1] = inscricoes.get(i).getNomeAluno();
			registro[2] = inscricoes.get(i).getTituloProjeto();
			registro[3] = inscricoes.get(i).getNomeOrientador();
			tabelaModelo.addRow(registro);
		}
		
	}
	
	public void excluirInscricao(JanelaGerenciamento jg) {
		
		String id_inscricao = jg.getFieldInformeId().getText();
		
		if(id_inscricao == null) {
			jg.avisoCampoIdVazio();
		} else {
			int resposta = jg.avisoExclusao();
			
			if(resposta == 0) {
				boolean resultado = inscricaoDao.excluirInscricao(id_inscricao);
				
				jg.avisoResultadoExclusao(resultado);
			}
			
		}

	}
	
}
