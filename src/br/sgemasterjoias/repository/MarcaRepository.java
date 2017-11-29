package br.sgemasterjoias.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.sgemasterjoias.model.Marca;
import br.unitins.frame.repository.Repository;

public class MarcaRepository extends Repository<Marca>{

	public MarcaRepository(EntityManager em) {
		super(em);
	}

	@Override
	protected Class<Marca> getModelClass() {
		return Marca.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<Marca> bucarTodos() {
		
		Query query = geEntityManager().createQuery("Select m From Marca m Order by m.id Desc");
		List<Marca> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<Marca>();
		
		return lista;

	}

}
