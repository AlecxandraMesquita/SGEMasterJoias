package br.sgemasterjoias.validation;

import java.util.ArrayList;
import java.util.List;

import br.sgemasterjoias.model.AjusteEstoque;
import br.unitins.frame.application.ValidationException;
import br.unitins.frame.validation.Validation;


public class AjusteEstoqueValidation implements Validation<AjusteEstoque> {
	List<String> listMessages;
	
	@Override
	public void validate(AjusteEstoque t) throws ValidationException {
		
		if (t.getEstoqueAntigo() == null || t.getEstoqueAntigo().toString().equals(""))
			getlistMessages().add("O estoque Antigo deve ser informado!");
		
		if (t.getAjusteEstoque() == null || t.getAjusteEstoque().toString().equals(""))
			getlistMessages().add("O Ajuste deve ser informado!");
		
		if (t.getDataAjuste() == null || t.getDataAjuste().toString().equals(""))
			getlistMessages().add("A Data do Ajuste deve ser informado!");
		
		if (t.getMotivoAjuste() == null || t.getMotivoAjuste().toString().equals(""))
			getlistMessages().add("O Motivo do Ajuste deve ser informado!");
		
		if (t.getTipoAjuste() == null || t.getTipoAjuste().toString().equals(""))
			getlistMessages().add("O Tipo do Ajuste deve ser informado!");
					
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
