package br.com.farmacia.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.farmacia.DAO.FornecedoresDAO;
import br.com.farmacia.domain.Fornecedores;

@FacesConverter("fornecedoresConverter")
public class FornecedoresConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent componente, String valor) {

		try {
			Long id = Long.parseLong(valor);
			FornecedoresDAO fdao = new FornecedoresDAO();
			Fornecedores fornecedores = fdao.buscarPorId(id);
			
			return fornecedores;
			
		}catch(RuntimeException e) {
			return null;	
		}
		
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent componente, Object obj) {
		
		try {
			Fornecedores fornecedores = (Fornecedores) obj;
			Long id = fornecedores.getId();
			return id.toString();
			
		}catch(RuntimeException e) {
			return null;	
		}
		
	}

}
