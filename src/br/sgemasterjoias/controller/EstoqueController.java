package br.sgemasterjoias.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import br.sgemasterjoias.factory.JPAFactory;
import br.sgemasterjoias.list.controller.EntradaEstoqueListController;
import br.sgemasterjoias.list.controller.ProdutoListController;
import br.sgemasterjoias.model.EntradaEstoque;
//import br.sgemasterjoias.list.controller.ProdutoListController;
//import br.sgemasterjoias.model.EntradaEstoque;
import br.sgemasterjoias.model.Estoque;
//import br.sgemasterjoias.model.ItemEntradaEstoque;
import br.sgemasterjoias.model.Produto;
import br.sgemasterjoias.repository.EntradaEstoqueRepository;
//import br.sgemasterjoias.repository.EntradaEstoqueRepository;
import br.sgemasterjoias.repository.EstoqueRepository;
//import br.sgemasterjoias.repository.ItemEntradaEstoqueRepository;
import br.sgemasterjoias.repository.ProdutoRepository;
import br.sgemasterjoias.validation.EstoqueValidation;
import br.unitins.frame.application.SelectionListener;
import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;

@ManagedBean
@ViewScoped
public class EstoqueController extends Controller<Estoque>{
	
	private List<Estoque> listaEstoque;
	private List<Produto> listaProduto;
	private List<EntradaEstoque> listaItemEntrada;
	private Estoque estoque, estoque1;
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
	
	public List<EntradaEstoque> getListaItemEntrada() {
		if (listaItemEntrada == null) {
			EntradaEstoqueRepository repository = new EntradaEstoqueRepository(JPAFactory.getEntityManager());
			listaItemEntrada = repository.bucarTodos();
		}
		return listaItemEntrada;
	}
	public void setListaEntrada(List<EntradaEstoque> listaItemEntrada) {
		this.listaItemEntrada = listaItemEntrada;
	}
	
	public void abrirListEntrada(ActionEvent actionEvent) {
		EntradaEstoqueListController lista = new EntradaEstoqueListController();
		lista.openList(new SelectionListener<EntradaEstoque>() {
			@Override
			public void select(EntradaEstoque entity) {
				EstoqueRepository repository = new EstoqueRepository(JPAFactory.getEntityManager());
				estoque1 = repository.bucarEntradas(entity.getId());
				//consulta de estoque que passa como parametro o id da pessoa e retorna um estoque
				 if (estoque1 != null)
						setEntity(estoque1);
				else
				  	getEntity().setEntrada(entity);
			}
		});
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
	
	
	public void abrirListProduto(ActionEvent actionEvent) {
		ProdutoListController list = new ProdutoListController();
		list.openList(new SelectionListener<Produto>() {
			@Override
			public void select(Produto entity) {
				EstoqueRepository repository = new EstoqueRepository(JPAFactory.getEntityManager());
				estoque = repository.bucarEntradas(entity.getId());
				//consulta de estoque que passa como parametro o id da pessoa e retorna um estoque
				 if (estoque != null)
						setEntity(estoque);
				else
				  	getEntity().setProduto(entity);
			}
		});
	}
	
	
}
