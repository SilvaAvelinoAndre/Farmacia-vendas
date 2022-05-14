package br.com.farmacia.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.farmacia.DAO.FornecedoresDAO;
import br.com.farmacia.domain.Fornecedores;

public class FornecedoresDAOTeste {

	@Test
	@Ignore
	public void salvar() {
		Fornecedores f1 = new Fornecedores();
		f1.setDescricao("Descri��o a");
		
		FornecedoresDAO fdao = new FornecedoresDAO();
		
		fdao.salvar(f1);
		
		
		
	}
	@Test
	@Ignore
	public void listar() {
		FornecedoresDAO fdao = new FornecedoresDAO();
		
		List<Fornecedores> fornecedores = fdao.listar();
		
		for(Fornecedores fornecedor : fornecedores) {
			System.out.println(fornecedor);
		}
		
	}

	@Test
	public void buscarPorId() {
		FornecedoresDAO fdao = new FornecedoresDAO();
		Fornecedores f1 = fdao.buscarPorId(2L);
		Fornecedores f2 = fdao.buscarPorId(3L);
		
		System.out.println(f1);
		System.out.println(f2);
		
	}
}
