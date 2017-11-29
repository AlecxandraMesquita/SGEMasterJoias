package br.sgemasterjoias.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import br.sgemasterjoias.model.Pessoa;
import br.unitins.frame.model.Model;

@Entity
public class Pessoa  extends Model<Pessoa> {

	private static final long serialVersionUID = 7589277816197945826L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqidcliente")
	@SequenceGenerator(name = "seqidcliente", sequenceName = "seqidcliente", allocationSize = 1)
		private Integer id;
		private String nome;
		private String telefone;
		private String cpf;
		private String rg;
		private String email;
		private TipoPessoa tipo;
		
		
		
		public TipoPessoa getTipo() {
			return tipo;
		}
		public void setTipo(TipoPessoa tipo) {
			this.tipo = tipo;
		}
		
		
		@Override
		public Integer getId() {
			return id;
		}
		@Override
		public void setId(Integer id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getCpf() {
			return cpf;
		}
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		public String getTelefone() {
			return telefone;
		}
		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}
		public String getRg() {
			return rg;
		}
		public void setRg(String rg) {
			this.rg = rg;
		}
		public String getEmail() {
			return email;
		}
		public void setEmeil(String email) {
			this.email = email;
		}
}