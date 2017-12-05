package br.sgemasterjoias.validation;

import java.util.ArrayList;
import java.util.List;

import br.sgemasterjoias.model.Estoque;
import br.unitins.frame.application.ValidationException;
import br.unitins.frame.validation.Validation;


public class EstoqueValidation implements Validation<Estoque> {
	List<String> listMessages;
	
	@Override
	public void validate(Estoque t) throws ValidationException {
		
//		if (t.getNome() == null || t.getProduto.getNome().trim().equals(""))
//			getlistMessages().add("O Nome deve ser informado!");
//		
//		if (t.getPrecoCusto() == null || t.getPrecoCusto().toString().equals(""))
//			getlistMessages().add("O Preço de custo deve ser informado!");
//		
//		if (t.getPrecoVenda() == null || t.getPrecoVenda().toString().equals(""))
//			getlistMessages().add("O Preço de Venda deve ser informado!");
		
		if (t.getQuantidadeProduto() == null || t.getQuantidadeProduto().toString().equals(""))
			getlistMessages().add("A quantidade de Produto deve ser informada!");
				
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
