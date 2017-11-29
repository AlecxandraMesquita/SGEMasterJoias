package br.sgemasterjoias.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.sgemasterjoias.model.Funcionario;
import br.sgemasterjoias.model.Pessoa;
import br.unitins.frame.repository.Repository;

public class FuncionarioRepository extends Repository<Funcionario>{

	public FuncionarioRepository(EntityManager em) {
		super(em);
	}

	@Override
	protected Class<Funcionario> getModelClass() {
		return Funcionario.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> bucarTodos() {
		
		Query query = geEntityManager().createQuery("Select f From Funcionario f Order by f.id Desc");
		List<Funcionario> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<Funcionario>();
		
		return lista;
		
	}
	
	public Funcionario bucarPessoa(Integer id) {

		Query query = geEntityManager().createQuery("SELECT f FROM Funcionario f WHERE f LIKE ?1 ORDER BY f.pessoa.id Desc");
		query.setParameter(1, "%" + id + "%");
		Funcionario funcionario = (Funcionario) query.getSingleResult();

		if (funcionario == null)
			funcionario = new Funcionario();
		return funcionario;
	}

}