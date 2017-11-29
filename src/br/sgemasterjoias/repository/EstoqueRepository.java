package br.sgemasterjoias.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.sgemasterjoias.model.Estoque;
import br.unitins.frame.repository.Repository;

public class EstoqueRepository extends Repository<Estoque>{

	public EstoqueRepository(EntityManager em) {
		super(em);
	}

	@Override
	protected Class<Estoque> getModelClass() {
		return Estoque.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<Estoque> bucarTodos() {
		
		Query query = geEntityManager().createQuery("Select e From Estoque e Order by e.id Desc");
		List<Estoque> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<Estoque>();
		
		return lista;

	}

}
