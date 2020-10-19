package modelo;

public class Aluno {
	
	private String nome;
	private String rg;
	private String cpf;
	private String email;
	private String curso;
	private String instituicao;
	private String serie;
	private String planoTrabalho;
	private int horasSemanais;
	private String copiaDocumento;

	public Aluno() {}

	public Aluno(String nome, String rg, String cpf, String email, String curso, String instituicao, String serie,
			String planoTrabalho, int horasSemanais, String copiaDocumento) {
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.email = email;
		this.curso = curso;
		this.instituicao = instituicao;
		this.serie = serie;
		this.planoTrabalho = planoTrabalho;
		this.horasSemanais = horasSemanais;
		this.copiaDocumento = copiaDocumento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getPlanoTrabalho() {
		return planoTrabalho;
	}

	public void setPlanoTrabalho(String planoTrabalho) {
		this.planoTrabalho = planoTrabalho;
	}

	public int getHorasSemanais() {
		return horasSemanais;
	}

	public void setHorasSemanais(int horasSemanais) {
		this.horasSemanais = horasSemanais;
	}

	public String getCopiaDocumento() {
		return copiaDocumento;
	}

	public void setCopiaDocumento(String copiaDocumento) {
		this.copiaDocumento = copiaDocumento;
	}
	
}
