package br.sgemasterjoias.model;

public enum Status {
	ATIVO(0,"Ativo"),
	INATIVO(1,"Inativo");
	
	private Integer valor;
	private String nome;
	
	private Status(Integer valo, String nomes) {
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
