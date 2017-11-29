package br.sgemasterjoias.validation;

import java.util.ArrayList;
import java.util.List;

import br.sgemasterjoias.model.ItemVenda;
import br.unitins.frame.application.ValidationException;
import br.unitins.frame.validation.Validation;


public class ItemVendaValidation implements Validation<ItemVenda> {
	List<String> listMessages;
	
	@Override
	public void validate(ItemVenda t) throws ValidationException {
		
		if (t.getNome() == null || t.getNome().trim().equals(""))
			getlistMessages().add("O Nome deve ser informado!");
		
		if (t.getPrecoCusto() == null || t.getPrecoCusto().toString().equals(""))
			getlistMessages().add("O Preço de custo deve ser informado!");
		
		if (t.getPrecoVenda() == null || t.getPrecoVenda().toString().equals(""))
			getlistMessages().add("O Preçode Venda deve ser informado!");
		
		if (t.getQuantidade() == null || t.getQuantidade().toString().equals(""))
			getlistMessages().add("A quantidade deve ser informado!");
				
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
