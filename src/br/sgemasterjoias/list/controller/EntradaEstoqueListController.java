package br.sgemasterjoias.list.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.sgemasterjoias.factory.JPAFactory;
import br.sgemasterjoias.model.EntradaEstoque;
import br.sgemasterjoias.repository.EntradaEstoqueRepository;
import br.sgemasterjoias.repository.ProdutoRepository;
import br.unitins.frame.listController.ListController;


@ManagedBean
@ViewScoped
public class EntradaEstoqueListController extends ListController<EntradaEstoque> {

	private static final long serialVersionUID = -5542212482691338078L;

	public EntradaEstoqueListController() {
		super(new EntradaEstoqueRepository(JPAFactory.getEntityManager()), true, false, false, 450, 650, "/listings/listagemEntradaEstoque");
		getEntity().getProduto().setNome("");
	}

	@Override
	public EntradaEstoque getEntity() {
		if (entity == null)
			entity = new EntradaEstoque();
		return entity;
	}

	@Override
	public List<EntradaEstoque> getListEntity() {
		if (listEntity == null) {
			listEntity = new ArrayList<EntradaEstoque>();
			EntradaEstoqueRepository repository = new EntradaEstoqueRepository(JPAFactory.getEntityManager());
			try {
				listEntity = (List<EntradaEstoque>) repository.bucarItem(getEntity().getId());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listEntity;
	}

}