package br.sgemasterjoias.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.sgemasterjoias.factory.JPAFactory;
import br.sgemasterjoias.model.Marca;
import br.sgemasterjoias.repository.MarcaRepository;
import br.unitins.frame.application.ApplicationException;

@FacesConverter(value = "marcaConverter", forClass = Marca.class)
public class MarcaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		MarcaRepository repository = new MarcaRepository(JPAFactory.getEntityManager());
		try {
			Marca f = ((Marca) repository.find(Integer.parseInt(arg2)));
			return f;
		} catch (NumberFormatException | ApplicationException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 != null) {
			return ((Marca) arg2).getId() == null ? "" : ((Marca) arg2).getId().toString();
		}
		return "";
	}
}
