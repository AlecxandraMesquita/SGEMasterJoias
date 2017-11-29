package br.sgemasterjoias.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import br.sgemasterjoias.factory.JPAFactory;
import br.sgemasterjoias.model.Venda;
import br.sgemasterjoias.repository.VendaRepository;
import br.sgemasterjoias.validation.VendaValidation;
import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;

@ManagedBean
@ViewScoped
public class VendaController extends Controller<Venda>{
	
	private List<Venda> listaVenda;

	@Override
	protected EntityManager getEntityManager() {
		
		return JPAFactory.getEntityManager();
	}

	
	@Override
	public void clean(ActionEvent actionEvent) {
		super.clean(actionEvent);
		setListaVenda(null);
	}
	
	
	@Override
	public Venda getEntity() {
		if (entity == null) {
			entity = new Venda();
		}
		return entity;
	}

	@Override
	public Validation<Venda> getValidation() {
		
		return new VendaValidation();

	}


	public List<Venda> getListaVenda() {
		if (listaVenda == null) {
			VendaRepository repository = new VendaRepository(JPAFactory.getEntityManager());
			listaVenda = repository.bucarTodos();
		}
		return listaVenda;
	}


	public void setListaVenda(List<Venda> listaVenda) {
		this.listaVenda = listaVenda;
	}
	
	

}
