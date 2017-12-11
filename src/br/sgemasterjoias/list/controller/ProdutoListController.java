package br.sgemasterjoias.list.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.sgemasterjoias.factory.JPAFactory;
import br.sgemasterjoias.model.Produto;
import br.sgemasterjoias.repository.ProdutoRepository;
import br.unitins.frame.listController.ListController;


@ManagedBean
@ViewScoped
public class ProdutoListController extends ListController<Produto> {

	private static final long serialVersionUID = -5542212482691338078L;

	public ProdutoListController() {
		super(new ProdutoRepository(JPAFactory.getEntityManager()), true, false, false, 450, 650, "/listings/listagemProduto");
		getEntity().setNome("");
	}

	@Override
	public Produto getEntity() {
		if (entity == null)
			entity = new Produto();
		return entity;
	}

	@Override
	public List<Produto> getListEntity() {
		if (listEntity == null) {
			listEntity = new ArrayList<Produto>();
			ProdutoRepository repository = new ProdutoRepository(JPAFactory.getEntityManager());
			try {
				listEntity = (List<Produto>) repository.bucarProdutos(getEntity().getNome());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listEntity;
	}

}