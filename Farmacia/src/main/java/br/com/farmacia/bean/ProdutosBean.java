package br.com.farmacia.bean;

import java.util.ArrayList;
import java.util.List;

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
	private String acao;
	private Long id;
	private List<Fornecedores> listaFornecedores;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	
	

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
	
	public List<Fornecedores> getListaFornecedores() {
		return listaFornecedores;
	}

	public void setListaFornecedores(List<Fornecedores> listaFornecedores) {
		this.listaFornecedores = listaFornecedores;
	}

	public void novo() {
		produtos = new Produtos();
	}

	public void salvar() {

		try {
			
			ProdutosDAO pdao = new ProdutosDAO();
			pdao.salvar(produtos);
			
			Produtos produtos = new Produtos();

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

			ProdutosDAO fdao = new ProdutosDAO();
			itens = (ArrayList<Produtos>) fdao.listar();

		} catch (RuntimeException e) {
			JFSUtil.mensagemErro(e.getMessage());
			e.printStackTrace();
		}

	}

	public void carregarCadastro() {

		try {
			
			
			if (id != null) {
				
				
				ProdutosDAO fdao = new ProdutosDAO();
				produtos = fdao.buscarPorId(id); // atribuir a busca por id do bd a variavel produtos
			}
			else {
				produtos = new Produtos();
			}

			FornecedoresDAO fdao = new FornecedoresDAO();
			setListaFornecedores(fdao.listar()); // setar a lista buscada no bd na variavel listaFornecedores, o método acima faz a mesma coisa que este
			
			
		} catch (RuntimeException e) {
			JFSUtil.mensagemErro(e.getMessage());
			e.printStackTrace();
		}

	}

	public void excluir() {
		try {

			ProdutosDAO fdao = new ProdutosDAO();
			fdao.deletar(produtos);

			JFSUtil.mensagemSucesso("Produto deletado com sucesso!!!");
		} catch (RuntimeException e) {
			JFSUtil.mensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}

	public void editar() {
		try {
			ProdutosDAO fdao = new ProdutosDAO();
			fdao.editar(produtos); 

			JFSUtil.mensagemSucesso("Atualizado com sucesso!!!");
		} catch (RuntimeException e) {
			JFSUtil.mensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}

	
	
	

}
