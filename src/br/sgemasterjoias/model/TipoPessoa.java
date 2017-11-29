package br.sgemasterjoias.model;

public enum TipoPessoa {

	CLIENTE(0,"Cliente"),
	FUNCIONARIO(1,"Funcionario");
	
	private Integer valor;
	private String nome;
	
	private TipoPessoa(Integer valo, String nomes) {
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
