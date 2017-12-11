package br.sgemasterjoias.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.sgemasterjoias.model.Produto;
import br.sgemasterjoias.model.Produto;
import br.sgemasterjoias.model.Produto;
import br.unitins.frame.repository.Repository;

public class ProdutoRepository extends Repository<Produto> {

	public ProdutoRepository(EntityManager em) {
		super(em);
	}

	@Override
	protected Class<Produto> getModelClass() {
		return Produto.class;
	}

	@SuppressWarnings("unchecked")
	public List<Produto> bucarTodos() {

		Query query = geEntityManager().createQuery("Select p From Produto p Order by p.id Desc");
		List<Produto> lista = query.getResultList();

		if (lista == null)
			lista = new ArrayList<Produto>();

		return lista;

	}
	
	public List<Produto> bucarProdutos(String nome) {

		Query query = geEntityManager().createQuery("SELECT pt FROM Produto pt WHERE pt.nome LIKE ?1 ORDER BY pt.nome");
		query.setParameter(1, "%" + nome + "%");
		List<Produto> lista = query.getResultList();

		if (lista == null)
			lista = new ArrayList<Produto>();

		return lista;
	}
	
//	public Produto bucarItem(Integer id) {
//
//		Query query = geEntityManager().createQuery("SELECT p FROM Produto p WHERE p.id = ?1 ");
//		query.setParameter(1, id);
//		Produto produto = null;
//		try {
//			produto = (Produto) query.getSingleResult();	
//		} catch (javax.persistence.NoResultException exception) {
//			
//		}
//
//		return produto;
//	}

}
