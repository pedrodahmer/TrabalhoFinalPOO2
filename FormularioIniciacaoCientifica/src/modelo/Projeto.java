package modelo;

public class Projeto {

	private String titulo;
	private String grupoPesquisa;
	private String unidade;
	private String faseProjeto;
	private String parecerCEP_CEUA;

	public Projeto(String titulo, String grupoPesquisa, String unidade, String faseProjeto, String parecerCEP_CEUA) {
		this.titulo = titulo;
		this.grupoPesquisa = grupoPesquisa;
		this.unidade = unidade;
		this.faseProjeto = faseProjeto;
		this.parecerCEP_CEUA = parecerCEP_CEUA;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGrupoPesquisa() {
		return grupoPesquisa;
	}

	public void setGrupoPesquisa(String grupoPesquisa) {
		this.grupoPesquisa = grupoPesquisa;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getFaseProjeto() {
		return faseProjeto;
	}

	public void setFaseProjeto(String faseProjeto) {
		this.faseProjeto = faseProjeto;
	}

	public String getParecerCEP_CEUA() {
		return parecerCEP_CEUA;
	}

	public void setParecerCEP_CEUA(String parecerCEP_CEUA) {
		this.parecerCEP_CEUA = parecerCEP_CEUA;
	}

}
