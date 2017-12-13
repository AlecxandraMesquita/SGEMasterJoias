package br.sgemasterjoias.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import br.sgemasterjoias.factory.JPAFactory;
import br.sgemasterjoias.model.Funcionario;
import br.sgemasterjoias.model.MaterialProduto;
import br.sgemasterjoias.model.Pessoa;
import br.sgemasterjoias.model.TipoPessoa;
import br.sgemasterjoias.repository.PessoaRepository;
import br.sgemasterjoias.util.Report;
import br.sgemasterjoias.validation.PessoaValidation;
import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;

@ManagedBean
@ViewScoped
public class PessoaController extends Controller<Pessoa>{
	
	private List<Pessoa> listaPessoa;
	
	 private Report relatorio;

	 public Report getRelatorio() {
		 if (relatorio == null)
		 relatorio = new Report("jdbc/masterjoias", "reports", "RelatorioPessoas");
		 return relatorio;
	 }

	@Override
	protected EntityManager getEntityManager() {
		
		return JPAFactory.getEntityManager();
	}

	
	@Override
	public void clean(ActionEvent actionEvent) {
		super.clean(actionEvent);
		setListaPessoa(null);
	}
	
	
	@Override
	public Pessoa getEntity() {
		if (entity == null) {
			entity = new Pessoa();
		}
		return entity;
	}

	@Override
	public Validation<Pessoa> getValidation() {
		
		return new PessoaValidation();

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
	
//	public TipoPessoa[] getTipo(){
//		return TipoPessoa.values();
//    }
	
}	
