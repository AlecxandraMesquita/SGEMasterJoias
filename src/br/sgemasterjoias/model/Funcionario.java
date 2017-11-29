package br.sgemasterjoias.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import br.sgemasterjoias.model.Pessoa;
import br.unitins.frame.model.Model;

@Entity
public class Funcionario extends Model<Funcionario>{

	private static final long serialVersionUID = 5572666984451356012L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqidfuncionario")
	@SequenceGenerator(name = "seqidfuncionario", sequenceName = "seqidfuncionario", allocationSize = 1)
	private Integer id;
	private String senha;
	private Double salario;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idPessoa", nullable = false, unique = true)
	private Pessoa pessoa;
	
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
	@Override
	public Integer getId() {
		return id;
	}
	@Override
	public void setId(Integer id) {
		this.id = id;
	}
}
