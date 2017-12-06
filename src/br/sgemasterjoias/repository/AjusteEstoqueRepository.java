package br.sgemasterjoias.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.sgemasterjoias.model.AjusteEstoque;
import br.sgemasterjoias.model.AjusteEstoque;
import br.unitins.frame.repository.Repository;


public class AjusteEstoqueRepository extends Repository<AjusteEstoque>{

	public AjusteEstoqueRepository(EntityManager em) {
		super(em);
	}

	@Override
	protected Class<AjusteEstoque> getModelClass() {
		return AjusteEstoque.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<AjusteEstoque> bucarTodos() {
		
		Query query = geEntityManager().createQuery("Select a From AjusteEstoque a Order by a.id Desc");
		List<AjusteEstoque> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<AjusteEstoque>();
		
		return lista;

	}
public List<AjusteEstoque> bucarAjusteEstoque(String nome) {
		
		Query query = geEntityManager().createQuery("SELECT ae FROM AjusteEstoque ae WHERE ae.nome LIKE ?1 ORDER BY ae.nome");
		query.setParameter(1, "%"+nome+"%");
		List<AjusteEstoque> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<AjusteEstoque>();
		
		return lista;
	}
	
	public List<AjusteEstoque> bucarAjustes(String nome) {
		
		Query query = geEntityManager().createQuery("SELECT f FROM AjusteEstoque f WHERE f.entrada.nome LIKE ?1 ORDER BY f.entrada.nome");
		query.setParameter(1, "%"+nome+"%");
		List<AjusteEstoque> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<AjusteEstoque>();
		
		return lista;
	}
	public AjusteEstoque bucarAjuste(Integer id) {
	
		Query query = geEntityManager().createQuery("SELECT f FROM AjusteEstoque f WHERE f.entrada.id = ?1 ");
		query.setParameter(1, id);
		AjusteEstoque ajuste = null;
		try {
			ajuste = (AjusteEstoque) query.getSingleResult();	
		} catch (javax.persistence.NoResultException exception) {
		
		}
	
		return ajuste;
	}
}
