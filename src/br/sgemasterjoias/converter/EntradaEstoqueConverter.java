package br.sgemasterjoias.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.sgemasterjoias.factory.JPAFactory;
import br.sgemasterjoias.model.EntradaEstoque;
import br.sgemasterjoias.repository.EntradaEstoqueRepository;
import br.sgemasterjoias.repository.MarcaRepository;
import br.unitins.frame.application.ApplicationException;

@FacesConverter(value = "entradaEstoqueConverter", forClass = EntradaEstoque.class)
public class EntradaEstoqueConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		EntradaEstoqueRepository repository = new EntradaEstoqueRepository(JPAFactory.getEntityManager());
		try {
			EntradaEstoque f = ((EntradaEstoque) repository.find(Integer.parseInt(arg2)));
			return f;
		} catch (NumberFormatException | ApplicationException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 != null) {
			return ((EntradaEstoque) arg2).getId() == null ? "" : ((EntradaEstoque) arg2).getId().toString();
		}
		return "";
	}
}
