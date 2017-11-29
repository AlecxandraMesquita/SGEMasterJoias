package br.sgemasterjoias.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import br.unitins.frame.model.Model;
@Entity
public class Marca extends Model<Marca> {

	private static final long serialVersionUID = 400846722652630357L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqidmarca")
	@SequenceGenerator(name = "seqidmarca", sequenceName = "seqidmarca", allocationSize = 1)
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
