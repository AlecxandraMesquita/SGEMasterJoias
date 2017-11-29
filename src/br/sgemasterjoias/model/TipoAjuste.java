package br.sgemasterjoias.model;

public enum TipoAjuste {

	ENTRADA(0,"Entrada"),
	SAIDA(1,"Saída");
	
	private Integer valor;
	private String nome;
	
	private TipoAjuste(Integer valo, String nomes) {
		valor = valo;
		nome = nomes;
	}
	
	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
