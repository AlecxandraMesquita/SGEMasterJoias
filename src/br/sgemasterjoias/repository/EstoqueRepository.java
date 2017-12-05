package br.sgemasterjoias.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.sgemasterjoias.model.Estoque;
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
	public List<Estoque> bucarEstoques(String nome) {
		
		Query query = geEntityManager().createQuery("SELECT f FROM Estoque f WHERE f.pessoa.nome LIKE ?1 ORDER BY f.pessoa.nome");
		query.setParameter(1, "%"+nome+"%");
		List<Estoque> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<Estoque>();
		
		return lista;
}
public Estoque bucarProduto(Integer id) {

	Query query = geEntityManager().createQuery("SELECT f FROM Estoque f WHERE f.pessoa.id = ?1 ");
	query.setParameter(1, id);
	Estoque funcionario = null;
	try {
		funcionario = (Estoque) query.getSingleResult();	
	} catch (javax.persistence.NoResultException exception) {
		
	}

	return funcionario;
}

}
