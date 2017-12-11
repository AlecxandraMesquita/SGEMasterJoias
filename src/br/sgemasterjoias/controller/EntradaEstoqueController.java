package br.sgemasterjoias.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import br.sgemasterjoias.factory.JPAFactory;
import br.sgemasterjoias.list.controller.PessoaListController;
import br.sgemasterjoias.list.controller.ProdutoListController;
import br.sgemasterjoias.model.EntradaEstoque;
import br.sgemasterjoias.model.Pessoa;
import br.sgemasterjoias.model.Produto;
import br.sgemasterjoias.model.TipoProduto;
import br.sgemasterjoias.repository.EntradaEstoqueRepository;
import br.sgemasterjoias.repository.FuncionarioRepository;
import br.sgemasterjoias.repository.ProdutoRepository;
import br.sgemasterjoias.validation.EntradaEstoqueValidation;
import br.sgemasterjoias.validation.ProdutoValidation;
import br.unitins.frame.application.SelectionListener;
import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;

@ManagedBean
@ViewScoped
public class EntradaEstoqueController extends Controller<EntradaEstoque>{
	
	private List<Produto> listaProduto;
	private List<EntradaEstoque> listaEntradaEstoque;
	private EntradaEstoque entrada;
	@Override
	protected EntityManager getEntityManager() {
		
		return JPAFactory.getEntityManager();
	}
	
	@Override
	public void clean(ActionEvent actionEvent) {
		super.clean(actionEvent);
		setListaProduto(null);
	}
	
	
	@Override
	public EntradaEstoque getEntity() {
		if (entity == null) {
			entity = new EntradaEstoque();
//			entity.setProduto(new Produto());
		}
		return entity;
	}

	@Override
	public Validation<EntradaEstoque> getValidation() {
		
		return new EntradaEstoqueValidation();

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
				EntradaEstoqueRepository repository = new EntradaEstoqueRepository(JPAFactory.getEntityManager());
				entrada = repository.bucarItem(entity.getId());
				//consulta de funcionario que passa como parametro o id da pessoa e retorna um funcionario
				 if (entrada != null)
						setEntity(entrada);
				else
				  	getEntity().setProduto(entity);
			}
		});
	}
}