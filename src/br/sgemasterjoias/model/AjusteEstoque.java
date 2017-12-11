package br.sgemasterjoias.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import br.sgemasterjoias.model.AjusteEstoque;
//import br.com.sgemasterjoias.TipoAjuste;
import br.unitins.frame.model.Model;

@Entity
public class AjusteEstoque extends Model<AjusteEstoque> {

	private static final long serialVersionUID = -1089609028562302191L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqidajusteEstoque")
	@SequenceGenerator(name = "seqidajusteEstoque", sequenceName = "seqidajusteEstoque", allocationSize = 1)
	
	private Integer id;
	private Integer ajusteEntoque;
	private Date dataAjuste;
	private String motivoAjuste;
	private EntradaEstoque entrada;
	private Estoque estoqueAntigo;
	
	public Estoque getEstoqueAntigo() {
		return estoqueAntigo;
	}
	public void setEstoqueAntigo(Estoque estoqueAntigo) {
		this.estoqueAntigo = estoqueAntigo;
	}
	private TipoAjuste tipoAjuste;
	

	public Integer getAjusteEstoque() {
		return ajusteEntoque;
	}
	public void setAjusteEstoque(Integer ajusteEntoque) {
		this.ajusteEntoque = ajusteEntoque;
	}
	public Date getDataAjuste() {
		return dataAjuste;
	}
	public void setDataAjuste(Date dataAjuste) {
		this.dataAjuste = dataAjuste;
	}
	public String getMotivoAjuste() {
		return motivoAjuste;
	}
	public void setMotivoAjuste(String motivoAjuste) {
		this.motivoAjuste = motivoAjuste;
	}
	public TipoAjuste getTipoAjuste() {
		return tipoAjuste;
	}
	public void setTipoAjuste(TipoAjuste tipoAjuste) {
		this.tipoAjuste = tipoAjuste;
	}
	@Override
	public Integer getId() {
		return id;
	}
	@Override
	public void setId(Integer id) {
		this.id = id;
		
	}
	public EntradaEstoque getEntrada() {
		return entrada;
	}
	public void setEntrada(EntradaEstoque entrada) {
		this.entrada = entrada;
		
	}

}
