package br.sgemasterjoias.validation;

import java.util.ArrayList;
import java.util.List;

import br.sgemasterjoias.model.Venda;
import br.unitins.frame.application.ValidationException;
import br.unitins.frame.validation.Validation;


public class VendaValidation implements Validation<Venda> {
	List<String> listMessages;
	
	@Override
	public void validate(Venda t) throws ValidationException {
		
		if (t.getDataVenda() == null || t.getDataVenda().toString().equals(""))
			getlistMessages().add("A Data da Venda deve ser informada!");
		
		if (t.getValorTotal() == null || t.getValorTotal().toString().equals(""))
			getlistMessages().add("O Valor Total deve ser informado!");
				
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

		