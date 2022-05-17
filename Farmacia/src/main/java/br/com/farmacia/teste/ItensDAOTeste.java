package br.com.farmacia.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.farmacia.DAO.FornecedoresDAO;
import br.com.farmacia.DAO.ItensDAO;
import br.com.farmacia.DAO.ProdutosDAO;
import br.com.farmacia.DAO.VendasDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.domain.Itens;
import br.com.farmacia.domain.Produtos;
import br.com.farmacia.domain.Vendas;

public class ItensDAOTeste {

	@Test
	@Ignore
	public void salvar() {
		
		ProdutosDAO pdao = new ProdutosDAO();  // para poder fazer operações  no banco de dados
		Produtos produtos = pdao.buscarPorId(2L); // fazer uma busca do id do itens para passar como parametro de chave estrangeira
		
		VendasDAO vdao = new VendasDAO();
		Vendas venda = vdao.buscarPorId(2L);
	
		
		Itens item1 = new Itens();
		
		item1.setQuantidade(10);
		item1.setPreco_parcial(7850.00);
		item1.setProduto(produtos);
		item1.setVendas(venda);  
		
		ItensDAO itens = new ItensDAO();
		

		itens.salvar(item1);

	}

	@Test
	@Ignore
	public void listar() {
		ProdutosDAO idao = new ProdutosDAO();

		List<Produtos> produto = idao.listar();

		for (Produtos fun : produto) {
			System.out.println(fun);
		}

	}

	@Test
	@Ignore
	public void buscarPorId() {
		ProdutosDAO idao = new ProdutosDAO();
		Produtos p1 = idao.buscarPorId(2L);
		Produtos p2 = idao.buscarPorId(3L);

		System.out.println(p1);
		System.out.println(p2);

	}

	@Test
	@Ignore
	public void deletar() {
		ProdutosDAO idao = new ProdutosDAO();

		Produtos produto = idao.buscarPorId(4L); // primeiro efetua uma busca para saber quem deletar

	
			idao.deletar(produto); // depois aplica o deletar da classe DornecedorDAO
	

	}

	
	@Test
	public void editar() {
		
		ProdutosDAO pdao = new ProdutosDAO();
		Produtos produto = pdao.buscarPorId(2L);
		
		VendasDAO vdao = new VendasDAO();
		Vendas venda = vdao.buscarPorId(2L);
		
		ItensDAO idao = new ItensDAO();
		
		Itens item = idao.buscarPorId(2L);
		item.setQuantidade(100);
		item.setPreco_parcial(78500.00);
		item.setProduto(produto);
		item.setVendas(venda);
		
		
		
			idao.editar(item); 
		

	}

}
