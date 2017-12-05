package br.sgemasterjoias.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.sgemasterjoias.model.Pessoa;
import br.unitins.frame.model.Model;

@Entity
public class Cliente extends Model<Cliente>{

	private static final long serialVersionUID = 996136943333903802L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqidcliente")
	@SequenceGenerator(name = "seqidcliente", sequenceName = "seqidcliente", allocationSize = 1)
	private Integer id;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idPessoa", nullable = false, unique = true)
	private Pessoa pessoa;
	
	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
		
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
}
