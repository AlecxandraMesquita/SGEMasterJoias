package br.sgemasterjoias.repository;


import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.sgemasterjoias.model.Funcionario;
import br.sgemasterjoias.model.Pessoa;
import br.unitins.frame.application.Session;
import br.unitins.frame.application.Util;
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
	public List<Funcionario> bucarFuncionarios(String nome) {
			
			Query query = geEntityManager().createQuery("SELECT f FROM Funcionario f WHERE f.pessoa.nome LIKE ?1 ORDER BY f.pessoa.nome");
			query.setParameter(1, "%"+nome+"%");
			List<Funcionario> lista = query.getResultList();
			
			if (lista == null)
				lista = new ArrayList<Funcionario>();
			
			return lista;
	}
	public Funcionario bucarPessoa(Integer id) {

		Query query = geEntityManager().createQuery("SELECT f FROM Funcionario f WHERE f.pessoa.id = ?1 ");
		query.setParameter(1, id);
		Funcionario funcionario = null;
		try {
			funcionario = (Funcionario) query.getSingleResult();	
		} catch (javax.persistence.NoResultException exception) {
			
		}

		return funcionario;
	}
	public Funcionario buscarUFuncionarioPorCPF(String CPF) {
		TypedQuery<Funcionario> query = geEntityManager().createQuery("SELECT f FROM Funcionario f WHERE f.pessoa.cpf = :CPF", Funcionario.class);

		return query.setParameter("CPF", CPF).getSingleResult();
		}
	
	
}