package br.sgemasterjoias.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import br.sgemasterjoias.factory.JPAFactory;
import br.sgemasterjoias.model.TipoProduto;
import br.sgemasterjoias.repository.TipoProdutoRepository;
import br.sgemasterjoias.validation.TipoProdutoValidation;
import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;

@ManagedBean
@ViewScoped
public class TipoProdutoController extends Controller<TipoProduto>{
	
	private List<TipoProduto> listaTipoProduto;

	@Override
	protected EntityManager getEntityManager() {
		
		return JPAFactory.getEntityManager();
	}

	
	@Override
	public void clean(ActionEvent actionEvent) {
		super.clean(actionEvent);
		setListaTipoProduto(null);
	}
	
	
	@Override
	public TipoProduto getEntity() {
		if (entity == null) {
			entity = new TipoProduto();
		}
		return entity;
	}

	@Override
	public Validation<TipoProduto> getValidation() {
		
		return new TipoProdutoValidation();

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
	
	

}
