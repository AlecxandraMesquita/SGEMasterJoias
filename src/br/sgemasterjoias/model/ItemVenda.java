package br.sgemasterjoias.model;

import javax.persistence.Entity;

import br.sgemasterjoias.model.Produto;

@Entity
public class ItemVenda extends Produto{

	private static final long serialVersionUID = -7161610143623798220L;
	
	private Integer quantidade;
	private Double valor;
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
}
