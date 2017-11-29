package br.sgemasterjoias.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import br.sgemasterjoias.model.Marca;
import br.sgemasterjoias.model.TipoProduto;
import br.unitins.frame.model.Model;

@Entity
public class Produto extends Model<Produto>{

		private static final long serialVersionUID = 4952026009947848707L;

		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqidproduto")
		@SequenceGenerator(name = "seqidproduto", sequenceName = "seqidproduto", allocationSize = 1)

		private Integer id;
		private String nome;
		private Double precoCusto;
		private Double precoVenda;
		private String descricao;
		
		private TipoProduto tipoProduto;

		
		private Marca marca;

		private MaterialProduto material;

		

		public MaterialProduto getMaterial() {
			return material;
		}

		public void setMaterial(MaterialProduto material) {
			this.material = material;
		}

		public TipoProduto getTipoProduto() {
			return tipoProduto;
		}

		public void setTipoProduto(TipoProduto tipoProduto) {
			this.tipoProduto = tipoProduto;
		}

		public Marca getMarca() {
			return marca;
		}

		public void setMarca(Marca marca) {
			this.marca = marca;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
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

		public Double getPrecoCusto() {
			return precoCusto;
		}

		public void setPrecoCusto(Double precoCusto) {
			this.precoCusto = precoCusto;
		}

		public Double getPrecoVenda() {
			return precoVenda;
		}

		public void setPrecoVenda(Double precoVenda) {
			this.precoVenda = precoVenda;
		}
		
}
