package br.com.farmacia.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.farmacia.DAO.FornecedoresDAO;
import br.com.farmacia.DAO.ProdutosDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.domain.Produtos;

public class ProdutosDAOTeste {

	@Test
	public void salvar() {
		
		FornecedoresDAO pdao = new FornecedoresDAO();  // para poder fazer operações  no banco de dados
		Fornecedores fornecedor = pdao.buscarPorId(3L); // fazer uma busca do id do fornecedor para passar como parametro de chave estrangeira
		
		Produtos p1 = new Produtos();
		
		p1.setDescricao("Plastico bolha");
		p1.setQuantidade(50);
		p1.setPreco(100.00);
		p1.setFornecedores(fornecedor); // parametro de chave estrangeira, recebido da busca feita acima. 
		
		ProdutosDAO produto = new ProdutosDAO();
		

		produto.salvar(p1);

	}

	@Test
	@Ignore
	public void listar() {
		ProdutosDAO pdao = new ProdutosDAO();

		List<Produtos> produto = pdao.listar();

		for (Produtos fun : produto) {
			System.out.println(fun);
		}

	}

	@Test
	@Ignore
	public void buscarPorId() {
		ProdutosDAO pdao = new ProdutosDAO();
		Produtos p1 = pdao.buscarPorId(2L);
		Produtos p2 = pdao.buscarPorId(3L);

		System.out.println(p1);
		System.out.println(p2);

	}

	@Test
	@Ignore
	public void deletar() {
		ProdutosDAO pdao = new ProdutosDAO();

		Produtos produto = pdao.buscarPorId(4L); // primeiro efetua uma busca para saber quem deletar

	
			pdao.deletar(produto); // depois aplica o deletar da classe DornecedorDAO
	

	}

	
	@Test
	@Ignore
	public void editar() {
		
		FornecedoresDAO fdao = new FornecedoresDAO();
		Fornecedores fornecedor = fdao.buscarPorId(2L);
		
		ProdutosDAO pdao = new ProdutosDAO();
		

		Produtos produto = pdao.buscarPorId(3L);
		produto.setDescricao("Vinho bordo demi-sec");;
		produto.setQuantidade(0);
		produto.setPreco(0.0);
		produto.setFornecedores(fornecedor);
		
		
			pdao.editar(produto); 
		

	}

}
