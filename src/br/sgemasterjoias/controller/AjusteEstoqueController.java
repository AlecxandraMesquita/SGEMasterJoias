package br.sgemasterjoias.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import br.sgemasterjoias.factory.JPAFactory;
import br.sgemasterjoias.model.AjusteEstoque;
import br.sgemasterjoias.model.TipoAjuste;
import br.sgemasterjoias.repository.AjusteEstoqueRepository;
import br.sgemasterjoias.validation.AjusteEstoqueValidation;
import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;

@ManagedBean
@ViewScoped
public class AjusteEstoqueController extends Controller<AjusteEstoque> {

	private List<AjusteEstoque> listaAjusteEstoque;
	
	@Override
	protected EntityManager getEntityManager() {
		return JPAFactory.getEntityManager();
	}

	@Override
	public void clean(ActionEvent actionEvent) {
		super.clean(actionEvent);
		setListaAjusteEstoque(null);
		
	}

	@Override
	public AjusteEstoque getEntity() {
		if (entity == null) {
			entity = new AjusteEstoque();
		}
		return entity;
	}

	@Override
	public Validation<AjusteEstoque> getValidation() {
		
		return new AjusteEstoqueValidation();
	}
	
	public List<AjusteEstoque> getListaAjusteEstoque() {
		if (listaAjusteEstoque == null) {
			AjusteEstoqueRepository repository = new AjusteEstoqueRepository(JPAFactory.getEntityManager());
			listaAjusteEstoque = repository.bucarTodos();
		}
		return listaAjusteEstoque;
	}

	public void setListaAjusteEstoque (List<AjusteEstoque>listaAjusteEstoque) {
		this.listaAjusteEstoque = listaAjusteEstoque;
	}
	
	
	public TipoAjuste[] getTipoAjuste(){
		return TipoAjuste.values();
    }
}