package br.sgemasterjoias.list.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.sgemasterjoias.factory.JPAFactory;
import br.sgemasterjoias.model.Pessoa;
import br.sgemasterjoias.repository.PessoaRepository;
import br.unitins.frame.listController.ListController;


@ManagedBean
@ViewScoped
public class PessoaListController extends ListController<Pessoa> {

	private static final long serialVersionUID = -5816342500278252412L;

	public PessoaListController() {
		super(new PessoaRepository(JPAFactory.getEntityManager()), true, false, false, 450, 650, "/listings/listagemPessoa");
		getEntity().setNome("");
	}

	@Override
	public Pessoa getEntity() {
		if (entity == null)
			entity = new Pessoa();
		return entity;
	}

	public List<Pessoa> getListEntity() {
		if (listEntity == null) {
			listEntity = new ArrayList<Pessoa>();
			PessoaRepository repository = new PessoaRepository(JPAFactory.getEntityManager());
			try {
				listEntity = repository.bucarPessoas(getEntity().getNome());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listEntity;
	}

}