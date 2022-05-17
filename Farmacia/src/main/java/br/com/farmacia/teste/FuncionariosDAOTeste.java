package br.com.farmacia.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.farmacia.DAO.FuncionariosDAO;
import br.com.farmacia.domain.Funcionarios;

public class FuncionariosDAOTeste {

	@Test
	public void salvar() {
		Funcionarios f2 = new Funcionarios();
		
		f2.setCpf("267.634.768-76");
		f2.setFuncao("Assistente");
		f2.setNome("João Carlos da Silveira");
		f2.setSenha("10121523");
		
		FuncionariosDAO fdao = new FuncionariosDAO();

		fdao.salvar(f2);

	}

	@Test
	@Ignore
	public void listar() {
		FuncionariosDAO fdao = new FuncionariosDAO();

		List<Funcionarios> funcionario = fdao.listar();

		for (Funcionarios fun : funcionario) {
			System.out.println(fun);
		}

	}

	@Test
	@Ignore
	public void buscarPorId() {
		FuncionariosDAO fdao = new FuncionariosDAO();
		Funcionarios f1 = fdao.buscarPorId(2L);
		Funcionarios f2 = fdao.buscarPorId(3L);

		System.out.println(f1);
		System.out.println(f2);

	}

	@Test
	@Ignore
	public void deletar() {
		FuncionariosDAO fdao = new FuncionariosDAO();

		Funcionarios funcionario = fdao.buscarPorId(3L); // primeiro efetua uma busca para saber quem deletar

	
			fdao.deletar(funcionario); // depois aplica o deletar da classe DornecedorDAO
	

	}

	
	@Test
	@Ignore
	public void editar() {
		FuncionariosDAO fdao = new FuncionariosDAO();
		

		Funcionarios funcionario = fdao.buscarPorId(1L);
		funcionario.setNome("");
		funcionario.setCpf("");
		funcionario.setFuncao("");
		funcionario.setSenha("456789");
		
		
		
		
			fdao.editar(funcionario); 
		

	}

}
