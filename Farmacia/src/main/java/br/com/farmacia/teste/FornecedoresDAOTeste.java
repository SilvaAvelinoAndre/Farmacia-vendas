package br.com.farmacia.teste;

import org.junit.Test;

import br.com.farmacia.DAO.FornecedoresDAO;
import br.com.farmacia.domain.Fornecedores;

public class FornecedoresDAOTeste {

	@Test
	public void salvar() {
		Fornecedores f1 = new Fornecedores();
		f1.setDescricao("Descri��o A");
		
		FornecedoresDAO fdao = new FornecedoresDAO();
		
		fdao.salvar(f1);
		
		
		
	}
	

}
