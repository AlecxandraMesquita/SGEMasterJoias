package br.sgemasterjoias.validation;

import java.util.ArrayList;
import java.util.List;

import br.sgemasterjoias.model.Marca;
import br.unitins.frame.application.ValidationException;
import br.unitins.frame.validation.Validation;


public class MarcaValidation implements Validation<Marca> {
	List<String> listMessages;
	
	@Override
	public void validate(Marca m) throws ValidationException {
		
		if (m.getNome() == null || m.getNome().trim().equals(""))
			getlistMessages().add("O Nome deve ser informado!");
		
				
		if (getlistMessages().size() > 0)
			throw new ValidationException(getlistMessages());
	}

	public List<String> getlistMessages() {
		if (listMessages == null)
			listMessages = new ArrayList<String>();
		return listMessages;
	}

	public void setlistMessages(List<String> listMessages) {
		this.listMessages = listMessages;
	}
}
