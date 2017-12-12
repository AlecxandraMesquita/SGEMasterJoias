package br.sgemasterjoias.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import br.sgemasterjoias.factory.JPAFactory;
//import br.sgemasterjoias.list.controller.FuncionarioListController;
import br.sgemasterjoias.list.controller.PessoaListController;
import br.sgemasterjoias.model.Funcionario;
import br.sgemasterjoias.model.MaterialProduto;
import br.sgemasterjoias.model.Permissao;
import br.sgemasterjoias.model.Pessoa;
import br.sgemasterjoias.model.Status;
import br.sgemasterjoias.repository.ClienteRepository;
import br.sgemasterjoias.repository.FuncionarioRepository;
import br.sgemasterjoias.repository.PessoaRepository;
import br.sgemasterjoias.validation.FuncionarioValidation;
import br.unitins.frame.application.SelectionListener;
import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;


@ManagedBean
@ViewScoped
public class FuncionarioController extends Controller<Funcionario>{
	
	private List<Funcionario> listaFuncionario;
	private List<Pessoa> listaPessoa;
	private Funcionario funcionario;
	
	@Override
	protected EntityManager getEntityManager() {
		
		return JPAFactory.getEntityManager();
	}

	
	@Override
	public void clean(ActionEvent actionEvent) {
		super.clean(actionEvent);
		setListaFuncionario(null);
	}
	
	
	@Override
	public Funcionario getEntity() {
		if (entity == null) {
			entity = new Funcionario();
		}
		return entity;
	}

	@Override
	public Validation<Funcionario> getValidation() {
		
		return new FuncionarioValidation();

	}


	public List<Funcionario> getListaFuncionario() {
		if (listaFuncionario == null) {
			FuncionarioRepository repository = new FuncionarioRepository(JPAFactory.getEntityManager());
			listaFuncionario = repository.bucarTodos();
		}
		return listaFuncionario;
	}


	public void setListaFuncionario(List<Funcionario> listaFuncionario) {
		this.listaFuncionario = listaFuncionario;
	}
	
	public List<Pessoa> getListaPessoa() {
		if (listaPessoa == null) {
			PessoaRepository repository = new PessoaRepository(JPAFactory.getEntityManager());
			listaPessoa = repository.bucarTodos();
		}
		return listaPessoa;
	}

	public void setListaPessoa(List<Pessoa> listaPessoa) {
		this.listaPessoa = listaPessoa;
	}

	public void abrirListPessoa(ActionEvent actionEvent) {
		PessoaListController list = new PessoaListController();
		list.openList(new SelectionListener<Pessoa>() {
			@Override
			public void select(Pessoa entity) {
				FuncionarioRepository repository = new FuncionarioRepository(JPAFactory.getEntityManager());
				funcionario = repository.bucarPessoa(entity.getId());
				//consulta de funcionario que passa como parametro o id da pessoa e retorna um funcionario
				 if (funcionario != null)
						setEntity(funcionario);
				else
				  	getEntity().setPessoa(entity);
			}
		});
	}
	
	public void abrirListFuncionario(ActionEvent actionEvent) {
		PessoaListController list = new PessoaListController();
		list.openList(new SelectionListener<Pessoa>() {
			@Override
			public void select(Pessoa entity) {
				FuncionarioRepository repository = new FuncionarioRepository(JPAFactory.getEntityManager());
				funcionario = repository.bucarPessoa(entity.getId());
				//consulta de funcionario que passa como parametro o id da pessoa e retorna um funcionario
				 if (funcionario != null)
						setEntity(funcionario);
				else
				  	getEntity().setPessoa(entity);
			}
		});
	}
	
	public Status[] getStatus(){
		return Status.values();
   }
	
	public Permissao[] getPermissao(){
		return Permissao.values();
    }
}