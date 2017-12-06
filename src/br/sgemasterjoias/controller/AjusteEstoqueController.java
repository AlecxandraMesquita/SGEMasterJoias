package br.sgemasterjoias.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import br.sgemasterjoias.factory.JPAFactory;
import br.sgemasterjoias.list.controller.EntradaEstoqueListController;
import br.sgemasterjoias.model.AjusteEstoque;
import br.sgemasterjoias.model.Estoque;
import br.sgemasterjoias.model.EntradaEstoque;
import br.sgemasterjoias.model.TipoAjuste;
import br.sgemasterjoias.repository.AjusteEstoqueRepository;
import br.sgemasterjoias.repository.EntradaEstoqueRepository;
import br.sgemasterjoias.repository.EstoqueRepository;
import br.sgemasterjoias.validation.AjusteEstoqueValidation;
import br.unitins.frame.application.SelectionListener;
import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;

@ManagedBean
@ViewScoped
public class AjusteEstoqueController extends Controller<AjusteEstoque> {

	private List<AjusteEstoque> listaAjusteEstoque;
	private List<Estoque> listaEstoque;
	private List<EntradaEstoque> listaEntradaEstoque;
	private AjusteEstoque ajuste;
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
	
	public TipoAjuste[] getTipoAjuste(){
		return TipoAjuste.values();
    }
	
	public List<EntradaEstoque> getListaEntradaEstoque() {
		if (listaEntradaEstoque == null) {
			EntradaEstoqueRepository repository = new EntradaEstoqueRepository(JPAFactory.getEntityManager());
			listaEntradaEstoque = repository.bucarTodos();
		}
		return listaEntradaEstoque;
	}

	public void setListaEntradaEstoque(List<EntradaEstoque> listaEntradaEstoque) {
		this.listaEntradaEstoque = listaEntradaEstoque;
	}

	public void abrirListEnttrada(ActionEvent actionEvent) {
		EntradaEstoqueListController list = new EntradaEstoqueListController();
		list.openList(new SelectionListener<EntradaEstoque>() {
			@Override
			public void select(EntradaEstoque entity) {
				AjusteEstoqueRepository repository = new AjusteEstoqueRepository(JPAFactory.getEntityManager());
				ajuste = repository.bucarAjuste(entity.getId());
				//consulta de funcionario que passa como parametro o id da pessoa e retorna um funcionario
				 if (ajuste != null)
						setEntity(ajuste);
				else
				  	getEntity().setEntrada(entity);
			}
		});
	}
}