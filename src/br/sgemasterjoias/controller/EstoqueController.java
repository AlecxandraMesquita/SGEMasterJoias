package br.sgemasterjoias.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import br.sgemasterjoias.factory.JPAFactory;
import br.sgemasterjoias.model.Estoque;
import br.sgemasterjoias.repository.EstoqueRepository;
import br.sgemasterjoias.validation.EstoqueValidation;
import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;

@ManagedBean
@ViewScoped
public class EstoqueController extends Controller<Estoque>{
	
	private List<Estoque> listaEstoque;

	@Override
	protected EntityManager getEntityManager() {
		
		return JPAFactory.getEntityManager();
	}

	
	@Override
	public void clean(ActionEvent actionEvent) {
		super.clean(actionEvent);
		setListaEstoque(null);
	}
	
	
	@Override
	public Estoque getEntity() {
		if (entity == null) {
			entity = new Estoque();
		}
		return entity;
	}

	@Override
	public Validation<Estoque> getValidation() {
		
		return new EstoqueValidation();

	}


	public List<Estoque> getListaEstoque() {
		if (listaEstoque == null) {
			EstoqueRepository repository = new EstoqueRepository(JPAFactory.getEntityManager());
			listaEstoque = repository.bucarTodos();
		}
		return listaEstoque;
	}


	public void setListaEstoque(List<Estoque> listaEstoque) {
		this.listaEstoque = listaEstoque;
	}
	
	

}
