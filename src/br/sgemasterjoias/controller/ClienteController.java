package br.sgemasterjoias.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import br.sgemasterjoias.factory.JPAFactory;
import br.sgemasterjoias.model.Cliente;
import br.sgemasterjoias.repository.ClienteRepository;
import br.sgemasterjoias.validation.ClienteValidation;
import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;

@ManagedBean
@ViewScoped
public class ClienteController extends Controller<Cliente>{
	
	private List<Cliente> listaCliente;

	@Override
	protected EntityManager getEntityManager() {
		
		return JPAFactory.getEntityManager();
	}

	
	@Override
	public void clean(ActionEvent actionEvent) {
		super.clean(actionEvent);
		setListaCliente(null);
	}
	
	
	@Override
	public Cliente getEntity() {
		if (entity == null) {
			entity = new Cliente();
		}
		return entity;
	}

	@Override
	public Validation<Cliente> getValidation() {
		
		return new ClienteValidation();

	}


	public List<Cliente> getListaCliente() {
		if (listaCliente == null) {
			ClienteRepository repository = new ClienteRepository(JPAFactory.getEntityManager());
			listaCliente = repository.bucarTodos();
		}
		return listaCliente;
	}


	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}
	
	

}
