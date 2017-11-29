package br.sgemasterjoias.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import br.sgemasterjoias.model.TipoProduto;
import br.unitins.frame.model.Model;

@Entity
public class TipoProduto extends Model<TipoProduto> {

	private static final long serialVersionUID = -5352243674923177180L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqidtipoProduto")
	@SequenceGenerator(name = "seqidtipoProduto", sequenceName = "seqidtipoProduto", allocationSize = 1)
	private Integer id;
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
