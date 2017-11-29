package br.sgemasterjoias.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.sgemasterjoias.model.Venda;
import br.unitins.frame.repository.Repository;

public class VendaRepository extends Repository<Venda>{

	public VendaRepository(EntityManager em) {
		super(em);
	}

	@Override
	protected Class<Venda> getModelClass() {
		return Venda.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<Venda> bucarTodos() {
		
		Query query = geEntityManager().createQuery("Select v From Venda v Order by v.id Desc");
		List<Venda> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<Venda>();
		
		return lista;

	}

}
