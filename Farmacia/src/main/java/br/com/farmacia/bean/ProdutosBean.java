package br.com.farmacia.bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.farmacia.DAO.FornecedoresDAO;
import br.com.farmacia.DAO.ProdutosDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.domain.Produtos;
import br.com.farmacia.util.JFSUtil;

@ManagedBean(name = "MBProdutos")
@ViewScoped
public class ProdutosBean {

	private Produtos produtos;
	private ArrayList<Produtos> itens;
	private ArrayList<Produtos> itensFiltrados;
	private ArrayList<Fornecedores> comboFornecedores;

	public Produtos getProdutos() {
		return produtos;
	}

	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}

	public ArrayList<Produtos> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Produtos> itens) {
		this.itens = itens;
	}

	public ArrayList<Produtos> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Produtos> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public ArrayList<Fornecedores> getComboFornecedores() {
		return comboFornecedores;
	}

	public void setComboFornecedores(ArrayList<Fornecedores> comboFornecedores) {
		this.comboFornecedores = comboFornecedores;
	}

	//@PostConstruct
	public void prepararPesquisa() {
		try {
			ProdutosDAO pdao = new ProdutosDAO();
			itens = (ArrayList<Produtos>) pdao.listar();

		} catch (RuntimeException e) {
			JFSUtil.mensagemErro(e.getMessage());
			e.printStackTrace();
		}

	}

	public void prepararNovo() {

		try {
			produtos = new Produtos();
			FornecedoresDAO fdao = new FornecedoresDAO();
			comboFornecedores = (ArrayList<Fornecedores>) fdao.listar();
		} catch (RuntimeException e) {
			JFSUtil.mensagemErro(e.getMessage());
			e.printStackTrace();
		}

	}

	public void novo() {

		try {
			ProdutosDAO pdao = new ProdutosDAO();
			pdao.salvar(produtos);
			itens = (ArrayList<Produtos>) pdao.listar();

			JFSUtil.mensagemSucesso("Salvo com sucesso!!!");
		} catch (RuntimeException e) {
			JFSUtil.mensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void excluir() {
		try {
			ProdutosDAO pdao = new ProdutosDAO();
			pdao.deletar(produtos);
			
			
			
			JFSUtil.mensagemSucesso("Deletado com sucesso!!!");
		} catch (RuntimeException e) {
			JFSUtil.mensagemErro("Não é posssivel excluir um fornecedor que tenha um produto associado!!!");
			e.printStackTrace();
		}
	}
	public void prepararEditar() {

		try {
			produtos = new Produtos();
			FornecedoresDAO fdao = new FornecedoresDAO();
			comboFornecedores = (ArrayList<Fornecedores>) fdao.listar();
		} catch (RuntimeException e) {
			JFSUtil.mensagemErro(e.getMessage());
			e.printStackTrace();
		}

	}
	
	public void editar() {
		try {
			ProdutosDAO pdao = new ProdutosDAO();
			pdao.editar(produtos);
			
			
			
			JFSUtil.mensagemSucesso("Atualizado com sucesso!!!");
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
				ProdutosDAO fdao = new ProdutosDAO();
				produtos = fdao.buscarPorId(id);
			}
			else {
				produtos = new Produtos();
			}

		} catch (RuntimeException e) {
			JFSUtil.mensagemErro(e.getMessage());
			e.printStackTrace();
		}

	}

}
