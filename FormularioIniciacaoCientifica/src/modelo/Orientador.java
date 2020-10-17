package modelo;

public class Orientador {
	
	private String nome;
	private String departamento;
	private int ramal;
	private String email;
	private int telefoneCelular;
	
	public Orientador() {}

	public Orientador(String nome, String departamento, int ramal, String email, int telefoneCelular) {
		super();
		this.nome = nome;
		this.departamento = departamento;
		this.ramal = ramal;
		this.email = email;
		this.telefoneCelular = telefoneCelular;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public int getRamal() {
		return ramal;
	}

	public void setRamal(int ramal) {
		this.ramal = ramal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(int telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}
	
	

}
