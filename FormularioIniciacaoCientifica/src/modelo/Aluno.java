package modelo;

public class Aluno {
	
	private String nome;
	private String curso;
	private String instituicao;
	private String rg;
	private String cpf;
	private String serie;
	private int horasSemanais;

	public Aluno() {}

	public Aluno(String nome, String curso, String instituicao, String rg, String cpf, String serie,
			int horasSemanais) {
		super();
		this.nome = nome;
		this.curso = curso;
		this.instituicao = instituicao;
		this.rg = rg;
		this.cpf = cpf;
		this.serie = serie;
		this.horasSemanais = horasSemanais;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public int getHorasSemanais() {
		return horasSemanais;
	}

	public void setHorasSemanais(int horasSemanais) {
		this.horasSemanais = horasSemanais;
	}
	
	// Aqui agora vai
	
}
