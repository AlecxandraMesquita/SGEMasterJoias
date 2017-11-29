package br.sgemasterjoias.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import br.sgemasterjoias.model.Pessoa;
import br.unitins.frame.model.Model;

@Entity
public class Funcionario extends Pessoa{

	private static final long serialVersionUID = 5572666984451356012L;
	
	private String senha;
	private Double salario;
	
	Pessoa pessoa = new Pessoa();
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
}
