package br.sgemasterjoias.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.sgemasterjoias.model.Venda;
import br.unitins.frame.model.Model;

@Entity
public class Venda extends Model<Venda> {

	private static final long serialVersionUID = 5171332980587290892L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqidvenda")
	@SequenceGenerator(name = "seqidvenda", sequenceName = "seqidvenda", allocationSize = 1)
	private Integer id;
	@Temporal(TemporalType.DATE)
	private Date dataVenda;
	private Double valorTotal;
	
	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
}
