package br.com.farmacia.bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.farmacia.DAO.FuncionariosDAO;
import br.com.farmacia.domain.Funcionarios;
import br.com.farmacia.util.JFSUtil;

@ManagedBean(name = "MBFuncionarios")
@ViewScoped
public class FuncionariosBean {

	private Funcionarios funcionarios;
	private ArrayList<Funcionarios> itens;
	private ArrayList<Funcionarios> itensFiltrados;

	public Funcionarios getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Funcionarios funcionarios) {
		this.funcionarios = funcionarios;
	}

	public ArrayList<Funcionarios> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Funcionarios> itens) {
		this.itens = itens;
	}

	public ArrayList<Funcionarios> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Funcionarios> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public void novo() {
		funcionarios = new Funcionarios();
	}

	public void salvar() {

		try {
			
			FuncionariosDAO fdao = new FuncionariosDAO();
			fdao.salvar(funcionarios);
			Funcionarios funcionarios = new Funcionarios();

			JFSUtil.mensagemSucesso("Salvo com sucesso!!!");

		} catch (RuntimeException e) {
			JFSUtil.mensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}

	// @PostConstruct // usado para iniciar o método ao abrir a tela, não sendo
	// usado neste método pois na paginaPesquisa sendo usado um <f:event
	public void prepararPesquisa() {
		
		try {

			FuncionariosDAO fdao = new FuncionariosDAO();
			itens = (ArrayList<Funcionarios>) fdao.listar();

		} catch (RuntimeException e) {
			JFSUtil.mensagemErro(e.getMessage());
			e.printStackTrace();
		}

	}

	public void carregarCadastro() {

		try {
			String valor = JFSUtil.getParam("forId");
			if (valor != null) {
				Long id = Long.parseLong(valor);
				FuncionariosDAO fdao = new FuncionariosDAO();
				funcionarios = fdao.buscarPorId(id);
			}
			else {
				funcionarios = new Funcionarios();
			}

		} catch (RuntimeException e) {
			JFSUtil.mensagemErro(e.getMessage());
			e.printStackTrace();
		}

	}

	public void excluir() {
		try {

			FuncionariosDAO fdao = new FuncionariosDAO();
			fdao.deletar(funcionarios);

			JFSUtil.mensagemSucesso("Deletado com sucesso!!!");
		} catch (RuntimeException e) {
			JFSUtil.mensagemErro("Não é posssivel excluir um fornecedor que tenha um produto associado!!!");
			e.printStackTrace();
		}
	}

	public void editar() {
		try {
			FuncionariosDAO fdao = new FuncionariosDAO();
			fdao.editar(funcionarios); 

			JFSUtil.mensagemSucesso("Atualizado com sucesso!!!");
		} catch (RuntimeException e) {
			JFSUtil.mensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}

}
