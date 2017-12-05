package br.sgemasterjoias.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.sgemasterjoias.model.Cliente;
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
	
	public List<Cliente> bucarClientes(String nome) {
		
		Query query = geEntityManager().createQuery("SELECT c FROM Cliente c WHERE c.pessoa.nome LIKE ?1 ORDER BY c.pessoa.nome");
		query.setParameter(1, "%"+nome+"%");
		List<Cliente> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<Cliente>();
		
		return lista;
	}
	public Cliente bucarPessoa(Integer id) {
	
		Query query = geEntityManager().createQuery("SELECT c FROM Cliente c WHERE c.pessoa.id = ?1 ");
		query.setParameter(1, id);
		Cliente cliente = null;
		try {
			cliente = (Cliente) query.getSingleResult();	
		} catch (javax.persistence.NoResultException exception) {
			
		}
	
		return cliente;
	}

}
