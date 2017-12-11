package br.sgemasterjoias.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.sgemasterjoias.model.EntradaEstoque;
import br.sgemasterjoias.model.Funcionario;
import br.unitins.frame.repository.Repository;

public class EntradaEstoqueRepository extends Repository<EntradaEstoque>{

	public EntradaEstoqueRepository(EntityManager em) {
		super(em);
	}

	@Override
	protected Class<EntradaEstoque> getModelClass() {
		return EntradaEstoque.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<EntradaEstoque> bucarTodos() {
		
		Query query = geEntityManager().createQuery("Select e From EntradaEstoque e Order by e.id Desc");
		List<EntradaEstoque> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<EntradaEstoque>();
		
		return lista;
	}
	public List<EntradaEstoque> bucarEntradaEstoques(String nome) {
		
		Query query = geEntityManager().createQuery("SELECT e FROM EntradaEstoque e WHERE e.produto.nome LIKE ?1 ORDER BY e.produro.nome");
		query.setParameter(1, "%"+nome+"%");
		List<EntradaEstoque> lista = query.getResultList();
		if (lista == null)
			lista = new ArrayList<EntradaEstoque>();
		
		return lista;
	}
	
	public EntradaEstoque bucarItem(Integer id) {

		Query query = geEntityManager().createQuery("SELECT f FROM Funcionario f WHERE f.produto.id = ?1 ");
		query.setParameter(1, id);
		EntradaEstoque entrada = null;
		try {
			entrada = (EntradaEstoque) query.getSingleResult();	
		} catch (javax.persistence.NoResultException exception) {
			
		}

		return entrada;
	}

}
