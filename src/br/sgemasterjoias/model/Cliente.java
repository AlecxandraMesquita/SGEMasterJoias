package br.sgemasterjoias.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.sgemasterjoias.model.Pessoa;

@Entity
public class Cliente extends Pessoa{

	private static final long serialVersionUID = 996136943333903802L;

	@Temporal(TemporalType.DATE)
	private Date dataCadastro;

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}
