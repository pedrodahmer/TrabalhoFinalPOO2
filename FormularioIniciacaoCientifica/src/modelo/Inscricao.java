package modelo;

public class Inscricao {

	private int id_inscricao;
	private String nomeAluno;
	private String tituloProjeto;
	private String nomeOrientador;
	
	public Inscricao() {}

	public Inscricao(int id_inscricao, String nomeAluno, String tituloProjeto, String nomeOrientador) {
		this.id_inscricao = id_inscricao;
		this.nomeAluno = nomeAluno;
		this.tituloProjeto = tituloProjeto;
		this.nomeOrientador = nomeOrientador;
	}

	public int getId_inscricao() {
		return id_inscricao;
	}

	public void setId_inscricao(int id_inscricao) {
		this.id_inscricao = id_inscricao;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getTituloProjeto() {
		return tituloProjeto;
	}

	public void setTituloProjeto(String tituloProjeto) {
		this.tituloProjeto = tituloProjeto;
	}

	public String getNomeOrientador() {
		return nomeOrientador;
	}

	public void setNomeOrientador(String nomeOrientador) {
		this.nomeOrientador = nomeOrientador;
	}
	
}
