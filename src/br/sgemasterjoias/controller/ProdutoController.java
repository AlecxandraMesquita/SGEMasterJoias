package br.sgemasterjoias.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import br.sgemasterjoias.factory.JPAFactory;
import br.sgemasterjoias.model.Marca;
import br.sgemasterjoias.model.MaterialProduto;
import br.sgemasterjoias.model.Produto;
import br.sgemasterjoias.model.TipoProduto;
import br.sgemasterjoias.repository.MarcaRepository;
import br.sgemasterjoias.repository.ProdutoRepository;
import br.sgemasterjoias.repository.TipoProdutoRepository;
import br.sgemasterjoias.validation.ProdutoValidation;
import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;

@ManagedBean
@ViewScoped
public class ProdutoController extends Controller<Produto>{
	
	private List<Produto> listaProduto;
	private List<TipoProduto> listaTipoProduto;
	private List<Marca> listaMarca;
	
	@Override
	protected EntityManager getEntityManager() {
		
		return JPAFactory.getEntityManager();
	}
	
	@Override
	public void clean(ActionEvent actionEvent) {
		super.clean(actionEvent);
		setListaProduto(null);
		setListaTipoProduto(null);
	}
	
	
	@Override
	public Produto getEntity() {
		if (entity == null) {
			entity = new Produto();
			entity.setTipoProduto(new TipoProduto());
		}
		return entity;
	}

	@Override
	public Validation<Produto> getValidation() {
		
		return new ProdutoValidation();

	}


	public List<Produto> getListaProduto() {
		if (listaProduto == null) {
			ProdutoRepository repository = new ProdutoRepository(JPAFactory.getEntityManager());
			listaProduto = repository.bucarTodos();
		}
		return listaProduto;
	}


	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}
	
	
	public List<TipoProduto> getListaTipoProduto() {
		if (listaTipoProduto == null) {
			TipoProdutoRepository repository = new TipoProdutoRepository(JPAFactory.getEntityManager());
			listaTipoProduto = repository.bucarTodos();
		}
		return listaTipoProduto;
	}

	public void setListaTipoProduto(List<TipoProduto> listaTipoProduto) {
		this.listaTipoProduto = listaTipoProduto;
}

	
	public List<Marca> getListaMarca() {
		if (listaMarca == null) {
			MarcaRepository repository = new MarcaRepository(JPAFactory.getEntityManager());
			listaMarca = repository.bucarTodos();
		}
		return listaMarca;
	}

	public void setListaMarca(List<Marca> listaMarca) {
		this.listaMarca = listaMarca;
	}

	public MaterialProduto[] getMaterial(){
		return MaterialProduto.values();
    }
	
}
