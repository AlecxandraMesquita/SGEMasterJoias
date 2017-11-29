package br.sgemasterjoias.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.sgemasterjoias.model.ItemVenda;
import br.unitins.frame.repository.Repository;

public class ItemVendaRepository extends Repository<ItemVenda>{

	public ItemVendaRepository(EntityManager em) {
		super(em);
	}

	@Override
	protected Class<ItemVenda> getModelClass() {
		return ItemVenda.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<ItemVenda> bucarTodos() {
		
		Query query = geEntityManager().createQuery("Select i From ItemVenda i Order by i.id Desc");
		List<ItemVenda> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<ItemVenda>();
		
		return lista;

	}

}
