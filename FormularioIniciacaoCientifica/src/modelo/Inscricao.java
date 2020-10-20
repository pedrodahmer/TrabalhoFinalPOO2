package modelo;

public class Inscricao {

	private int id_aluno;
	private int id_orientador;
	private int id_projeto;
	
	public Inscricao() {};
	
	public Inscricao(int id_aluno, int id_orientador, int id_projeto) {
		this.id_aluno = id_aluno;
		this.id_orientador = id_orientador;
		this.id_projeto = id_projeto;
	}
	
	public int getId_aluno() {
		return id_aluno;
	}
	
	public void setId_aluno(int id_aluno) {
		this.id_aluno = id_aluno;
	}
	
	public int getId_orientador() {
		return id_orientador;
	}
	
	public void setId_orientador(int id_orientador) {
		this.id_orientador = id_orientador;
	}
	
	public int getId_projeto() {
		return id_projeto;
	}
	
	public void setId_projeto(int id_projeto) {
		this.id_projeto = id_projeto;
	}
	
}
