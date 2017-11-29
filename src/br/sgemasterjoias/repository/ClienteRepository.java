package br.sgemasterjoias.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.sgemasterjoias.model.Cliente;
import br.unitins.frame.repository.Repository;

public class ClienteRepository extends Repository<Cliente>{

	public ClienteRepository(EntityManager em) {
		super(em);
	}

	@Override
	protected Class<Cliente> getModelClass() {
		return Cliente.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> bucarTodos() {
		
		Query query = geEntityManager().createQuery("Select c From Cliente c Order by c.id Desc");
		List<Cliente> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<Cliente>();
		
		return lista;

	}

}
