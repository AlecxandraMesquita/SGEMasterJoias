package br.sgemasterjoias.model;

public enum MaterialProduto {

	OURO(0,"Ouro"),
	PRATA(1,"Prata"),
	BRONZE(2,"Bronze"),
	LATAO(3, "Latao");
	
	private Integer valor;
	private String nome;
	
	private MaterialProduto(Integer valor, String nome) {
		this.valor = valor;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}
}
