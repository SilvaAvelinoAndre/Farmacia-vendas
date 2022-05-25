package br.com.farmacia.bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.farmacia.DAO.FornecedoresDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.util.JFSUtil;

@ManagedBean(name = "MBFornecedores")
@ViewScoped
public class FornecedoresBean {

	private Fornecedores fornecedores;
	private ArrayList<Fornecedores> itens;
	private ArrayList<Fornecedores> itensFiltrados;

	public Fornecedores getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(Fornecedores fornecedores) {
		this.fornecedores = fornecedores;
	}

	public ArrayList<Fornecedores> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Fornecedores> itens) {
		this.itens = itens;
	}

	public ArrayList<Fornecedores> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Fornecedores> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public void novo() {
		fornecedores = new Fornecedores();
	}

	public void salvar() {

		try {
			
			FornecedoresDAO fdao = new FornecedoresDAO();
			fdao.salvar(fornecedores);
			Fornecedores fornecedores = new Fornecedores();

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

			FornecedoresDAO fdao = new FornecedoresDAO();
			itens = (ArrayList<Fornecedores>) fdao.listar();

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
				FornecedoresDAO fdao = new FornecedoresDAO();
				fornecedores = fdao.buscarPorId(id);
			}
			else {
				fornecedores = new Fornecedores();
			}

		} catch (RuntimeException e) {
			JFSUtil.mensagemErro(e.getMessage());
			e.printStackTrace();
		}

	}

	public void excluir() {
		try {

			FornecedoresDAO fdao = new FornecedoresDAO();
			fdao.deletar(fornecedores);

			JFSUtil.mensagemSucesso("Deletado com sucesso!!!");
		} catch (RuntimeException e) {
			JFSUtil.mensagemErro("Não é posssivel excluir um fornecedor que tenha um produto associado!!!");
			e.printStackTrace();
		}
	}

	public void editar() {
		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			fdao.editar(fornecedores); 

			JFSUtil.mensagemSucesso("Atualizado com sucesso!!!");
		} catch (RuntimeException e) {
			JFSUtil.mensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}

}
