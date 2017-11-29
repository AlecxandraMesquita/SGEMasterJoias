package br.sgemasterjoias.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import br.sgemasterjoias.factory.JPAFactory;
import br.sgemasterjoias.model.ItemVenda;
import br.sgemasterjoias.repository.ItemVendaRepository;
import br.sgemasterjoias.validation.ItemVendaValidation;
import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;

@ManagedBean
@ViewScoped
public class ItemVendaController extends Controller<ItemVenda>{
	
	private List<ItemVenda> listaItemVenda;

	@Override
	protected EntityManager getEntityManager() {
		
		return JPAFactory.getEntityManager();
	}

	
	@Override
	public void clean(ActionEvent actionEvent) {
		super.clean(actionEvent);
		setListaItemVenda(null);
	}
	
	
	@Override
	public ItemVenda getEntity() {
		if (entity == null) {
			entity = new ItemVenda();
		}
		return entity;
	}

	@Override
	public Validation<ItemVenda> getValidation() {
		
		return new ItemVendaValidation();

	}


	public List<ItemVenda> getListaItemVenda() {
		if (listaItemVenda == null) {
			ItemVendaRepository repository = new ItemVendaRepository(JPAFactory.getEntityManager());
			listaItemVenda = repository.bucarTodos();
		}
		return listaItemVenda;
	}


	public void setListaItemVenda(List<ItemVenda> listaItemVenda) {
		this.listaItemVenda = listaItemVenda;
	}
	
	

}
