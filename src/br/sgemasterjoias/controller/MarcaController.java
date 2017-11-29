package br.sgemasterjoias.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import br.sgemasterjoias.factory.JPAFactory;
import br.sgemasterjoias.model.Marca;
import br.sgemasterjoias.repository.MarcaRepository;
import br.sgemasterjoias.validation.MarcaValidation;
import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;

@ManagedBean
@ViewScoped
public class MarcaController extends Controller<Marca>{
	
	private List<Marca> listaMarca;

	@Override
	protected EntityManager getEntityManager() {
		
		return JPAFactory.getEntityManager();
	}

	
	@Override
	public void clean(ActionEvent actionEvent) {
		super.clean(actionEvent);
		setListaMarca(null);
	}
	
	
	@Override
	public Marca getEntity() {
		if (entity == null) {
			entity = new Marca();
		}
		return entity;
	}

	@Override
	public Validation<Marca> getValidation() {
		
		return new MarcaValidation();

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
	
	

}
