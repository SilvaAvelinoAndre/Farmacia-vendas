package br.com.farmacia.teste;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.farmacia.DAO.FuncionariosDAO;
import br.com.farmacia.DAO.ProdutosDAO;
import br.com.farmacia.DAO.VendasDAO;
import br.com.farmacia.domain.Funcionarios;
import br.com.farmacia.domain.Produtos;
import br.com.farmacia.domain.Vendas;

public class VendasDAOTeste {

	@Test
	public void salvar() {
		
		FuncionariosDAO fdao = new FuncionariosDAO();  // para poder fazer operações  no banco de dados
		Funcionarios funcionario = fdao.buscarPorId(2L); // fazer uma busca do id do fornecedor para passar como parametro de chave estrangeira
		
		
		
		Vendas v1 = new Vendas();
		
		v1.setHorario(new Date());
		v1.setPreco_total(78500.00);
		v1.setFuncionarios(funcionario); // parametro de chave estrangeira, recebido da busca feita acima. 
		
		VendasDAO venda = new VendasDAO();
		

		venda.salvar(v1);

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
		
		FuncionariosDAO fdao = new FuncionariosDAO();
		Funcionarios funcionario = fdao.buscarPorId(2L);
		
		VendasDAO vdao = new VendasDAO();
		

		Vendas venda = vdao.buscarPorId(3L);
		venda.setHorario(new Date());
		venda.setPreco_total(0.0);
		venda.setFuncionarios(funcionario);
		
		
			vdao.editar(venda); 
		

	}

}
