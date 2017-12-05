package br.sgemasterjoias.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import br.unitins.frame.model.Model;

@Entity
public class Estoque extends Model<Estoque>{

	private static final long serialVersionUID = 1734993885711775914L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqidestoque")
	@SequenceGenerator(name = "seqidestoque", sequenceName = "seqidestoque", allocationSize = 1)

	private Integer id;
	private Integer quantidadeProduto;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idproduto", nullable = false, unique = true)
	private Produto produto;
	

	public Integer getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

}
