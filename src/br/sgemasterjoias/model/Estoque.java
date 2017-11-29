package br.sgemasterjoias.model;

import javax.persistence.Entity;

import br.unitins.frame.model.Model;

@Entity
public class Estoque extends Produto{

	private static final long serialVersionUID = 1734993885711775914L;

	private Integer quantidadeProduto;

	public Integer getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

}
