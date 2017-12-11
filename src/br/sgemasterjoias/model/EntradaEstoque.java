package br.sgemasterjoias.model;

import java.util.Date;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.format.annotation.DateTimeFormat;

import br.sgemasterjoias.model.Produto;
import br.unitins.frame.model.Model;

@Entity
public class EntradaEstoque extends Model<EntradaEstoque> {

	private static final long serialVersionUID = 8371910426027163469L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqidentradaEstoque")
	@SequenceGenerator(name = "seqidentradaEstoque", sequenceName = "seqidentradaEstoque", allocationSize = 1)
	
	private Integer id;
	@DateTimeFormat
	private Date dataEntrada;
	private Integer quantidade;
	private Produto produto;
	
	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
		
	}
	
	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto= produto;
	}

	public void setNome(String string) {
		
	}
}
