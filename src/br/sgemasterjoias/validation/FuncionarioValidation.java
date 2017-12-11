package br.sgemasterjoias.validation;

import java.util.ArrayList;
import java.util.List;

import br.sgemasterjoias.model.Funcionario;
import br.unitins.frame.application.ValidationException;
import br.unitins.frame.validation.Validation;


public class FuncionarioValidation implements Validation<Funcionario> {
	List<String> listMessages;
	
	@Override
	public void validate(Funcionario t) throws ValidationException {
				
		if (t.getSenha() == null || t.getSenha().equals(""))
			getlistMessages().add("A Senha deve ser informada!");
		
		if (t.getSalario() == null || t.getSalario().toString().equals(""))
			getlistMessages().add("O Salario deve ser informado!");
		
				
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
