package br.sgemasterjoias.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.sgemasterjoias.factory.JPAFactory;
import br.sgemasterjoias.model.Pessoa;
import br.sgemasterjoias.repository.PessoaRepository;
import br.unitins.frame.application.ApplicationException;

@FacesConverter(value = "pessoaConverter", forClass = Pessoa.class)
public class PessoaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		PessoaRepository repository = new PessoaRepository(JPAFactory.getEntityManager());
		try {
			Pessoa f = ((Pessoa) repository.find(Integer.parseInt(arg2)));
			return f;
		} catch (NumberFormatException | ApplicationException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 != null) {
			return ((Pessoa) arg2).getId() == null ? "" : ((Pessoa) arg2).getId().toString();
		}
		return "";
	}
}
