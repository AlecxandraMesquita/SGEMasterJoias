package br.sgemasterjoias.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.sgemasterjoias.model.Pessoa;
import br.unitins.frame.repository.Repository;

public class PessoaRepository extends Repository<Pessoa> {

	public PessoaRepository(EntityManager em) {
		super(em);
	}

	@Override
	protected Class<Pessoa> getModelClass() {
		return Pessoa.class;
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> bucarTodos() {

		Query query = geEntityManager().createQuery("Select p From Pessoa p Order by p.id Desc");
		List<Pessoa> lista = query.getResultList();

		if (lista == null)
			lista = new ArrayList<Pessoa>();

		return lista;

	}

	public List<Pessoa> bucarPessoas(String nome) {

		Query query = geEntityManager().createQuery("SELECT p FROM Pessoa p WHERE p.nome LIKE ?1 ORDER BY p.nome");
		query.setParameter(1, "%" + nome + "%");
		List<Pessoa> lista = query.getResultList();

		if (lista == null)
			lista = new ArrayList<Pessoa>();

		return lista;
	}
	
//	public List<Pessoa> bucarPessoaID(Integer id) {
//
//		Query query = geEntityManager().createQuery("SELECT p FROM Pessoa p WHERE p.id LIKE ?1 ORDER BY p.id");
//		query.setParameter(1, "%" + id + "%");
//		List<Pessoa> lista = query.getResultList();
//
//		if (lista == null)
//			lista = new ArrayList<Pessoa>();
//		return lista;
//	}

}