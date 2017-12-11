package br.sgemasterjoias.list.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.sgemasterjoias.factory.JPAFactory;
import br.sgemasterjoias.model.Funcionario;
import br.sgemasterjoias.repository.FuncionarioRepository;
import br.sgemasterjoias.repository.PessoaRepository;
import br.unitins.frame.listController.ListController;


@ManagedBean
@ViewScoped
public class FuncionarioListController extends ListController<Funcionario> {

	private static final long serialVersionUID = -5542212482691338078L;

	public FuncionarioListController() {
		super(new FuncionarioRepository(JPAFactory.getEntityManager()), true, false, false, 450, 650, "/listings/listagemFuncionario");
		getEntity().setNome("");
	}

	@Override
	public Funcionario getEntity() {
		if (entity == null)
			entity = new Funcionario();
		return entity;
	}

	@Override
	public List<Funcionario> getListEntity() {
		if (listEntity == null) {
			listEntity = new ArrayList<Funcionario>();
			FuncionarioRepository repository = new FuncionarioRepository(JPAFactory.getEntityManager());
			try {
				listEntity = (List<Funcionario>) repository.bucarPessoa(getEntity().getId());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listEntity;
	}

}