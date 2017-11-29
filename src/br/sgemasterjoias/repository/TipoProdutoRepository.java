package br.sgemasterjoias.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.sgemasterjoias.model.TipoProduto;
import br.unitins.frame.repository.Repository;

public class TipoProdutoRepository extends Repository<TipoProduto>{

	public TipoProdutoRepository(EntityManager em) {
		super(em);
	}

	@Override
	protected Class<TipoProduto> getModelClass() {
		return TipoProduto.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<TipoProduto> bucarTodos() {
		
		Query query = geEntityManager().createQuery("Select t From TipoProduto t Order by t.id Desc");
		List<TipoProduto> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<TipoProduto>();
		
		return lista;

	}
	
public List<TipoProduto> bucarTipoProdutos(String nome) {
		
		Query query = geEntityManager().createQuery("SELECT tp FROM TipoProduto tp WHERE tp.nome LIKE ?1 ORDER BY tp.nome");
		query.setParameter(1, "%"+nome+"%");
		List<TipoProduto> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<TipoProduto>();
		
		return lista;
	}
	

}
