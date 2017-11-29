package br.sgemasterjoias.validation;

import java.util.ArrayList;
import java.util.List;

import br.sgemasterjoias.model.TipoProduto;
import br.unitins.frame.application.ValidationException;
import br.unitins.frame.validation.Validation;


public class TipoProdutoValidation implements Validation<TipoProduto> {
	List<String> listMessages;
	
	@Override
	public void validate(TipoProduto t) throws ValidationException {
				
		if (t.getNome() == null || t.getNome().trim().equals(""))
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
