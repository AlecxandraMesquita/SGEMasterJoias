package br.sgemasterjoias.validation;

import java.util.ArrayList;
import java.util.List;

import br.sgemasterjoias.model.Produto;
import br.unitins.frame.application.ValidationException;
import br.unitins.frame.validation.Validation;


public class ProdutoValidation implements Validation<Produto> {
	List<String> listMessages;
	
	@Override
	public void validate(Produto t) throws ValidationException {
		
		if (t.getNome() == null || t.getNome().trim().equals(""))
			getlistMessages().add("O Nome deve ser informado!");
		
		if (t.getPrecoCusto() == null || t.getPrecoCusto().toString().equals(""))
			getlistMessages().add("O Preço de Custo deve ser informado!");
		
		if (t.getPrecoVenda() == null || t.getPrecoVenda().toString().equals(""))
			getlistMessages().add("O Preço de venda deve ser informado!");
		
		if (t.getDescricao() == null || t.getDescricao().toString().equals(""))
			getlistMessages().add("O Preço de venda deve ser informado!");
		
		if (t.getTipoProduto() == null || t.getTipoProduto().toString().equals(""))
			getlistMessages().add("O Preço de venda deve ser informado!");
		
		if (t.getMarca() == null || t.getMarca().toString().equals(""))
			getlistMessages().add("O Preço de venda deve ser informado!");
		
		if (t.getMaterial() == null || t.getMaterial().toString().equals(""))
			getlistMessages().add("O Preço de venda deve ser informado!");
				
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
