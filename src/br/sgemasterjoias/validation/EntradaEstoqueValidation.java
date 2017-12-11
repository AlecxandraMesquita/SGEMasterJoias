package br.sgemasterjoias.validation;

import java.util.ArrayList;
import java.util.List;

import br.sgemasterjoias.model.EntradaEstoque;
import br.sgemasterjoias.model.Funcionario;
import br.unitins.frame.application.ValidationException;
import br.unitins.frame.validation.Validation;


public class EntradaEstoqueValidation implements Validation<EntradaEstoque> {
	List<String> listMessages;
	
	@Override
	public void validate(EntradaEstoque t) throws ValidationException {
				
		if (t.getDataAlteracao() == null || t.getDataAlteracao().equals(""))
			getlistMessages().add("A Data deve ser informada!");
		
		if (t.getQuantidade() == null || t.getQuantidade().toString().equals(""))
			getlistMessages().add("A Quanridade deve ser informada!");
		
		if (t.getProduto() == null || t.getProduto().toString().equals(""))
			getlistMessages().add("O Item deve ser informado!");
				
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