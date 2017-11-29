package br.sgemasterjoias.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.sgemasterjoias.factory.JPAFactory;
import br.sgemasterjoias.model.TipoProduto;
import br.sgemasterjoias.repository.TipoProdutoRepository;
import br.unitins.frame.application.ApplicationException;

@FacesConverter(value = "tipoProdutoConverter", forClass = TipoProduto.class)
public class TipoProdutoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		TipoProdutoRepository repository = new TipoProdutoRepository(JPAFactory.getEntityManager());
		try {
			TipoProduto f = ((TipoProduto) repository.find(Integer.parseInt(arg2)));
			return f;
		} catch (NumberFormatException | ApplicationException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 != null) {
			return ((TipoProduto) arg2).getId() == null ? "" : ((TipoProduto) arg2).getId().toString();
		}
		return "";
	}
}
