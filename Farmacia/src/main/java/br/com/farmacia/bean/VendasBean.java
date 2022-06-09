package br.com.farmacia.bean;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.farmacia.DAO.FuncionariosDAO;
import br.com.farmacia.DAO.ProdutosDAO;
import br.com.farmacia.DAO.VendasDAO;
import br.com.farmacia.domain.Funcionarios;
import br.com.farmacia.domain.Itens;
import br.com.farmacia.domain.Produtos;
import br.com.farmacia.domain.Vendas;
import br.com.farmacia.util.JFSUtil;

@ManagedBean(name = "MBVendas")
@ViewScoped
public class VendasBean {

	private Produtos produtos;
	private Vendas vendasCadastro;
	private List<Itens> itens;
	private List<Itens> itensFiltrados;
	private List<Produtos> produtosItens;
	private List<Produtos> produtosFiltrados;

	
	
	

	public List<Produtos> getProdutosFiltrados() {
		return produtosFiltrados;
	}

	public void setProdutosFiltrados(List<Produtos> produtosFiltrados) {
		this.produtosFiltrados = produtosFiltrados;
	}

	public Produtos getProdutos() {
		return produtos;
	}

	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}

	public Vendas getVendasCadastro() {
		if(vendasCadastro == null) {
			vendasCadastro = new Vendas();
			vendasCadastro.setPreco_total(0.00);
		}
		return vendasCadastro;
	}

	public void setVendasCadastro(Vendas vendasCadastro) {
		
		this.vendasCadastro = vendasCadastro;
	}
	public List<Itens> getItens() {
		if(itens == null) {
			itens = new ArrayList<>();
		}
		return itens;
	}

	public void setItens(List<Itens> itens) {
		this.itens = itens;
	}

	public List<Itens> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(List<Itens> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public List<Produtos> getProdutosItens() {
		return produtosItens;
	}

	public void setProdutosItens(List<Produtos> produtosItens) {
		this.produtosItens = produtosItens;
	}

	

	public void carregarProdutos() {

		try {

			ProdutosDAO fdao = new ProdutosDAO();
			produtosItens = (List<Produtos>) fdao.listar();

		} catch (RuntimeException e) {
			JFSUtil.mensagemErro(e.getMessage());
			e.printStackTrace();
		}

	}

	public void adicionar(Produtos produto) {

		int itemEncontrado = -1;
		for (int posicao = 0; posicao < itens.size() && itemEncontrado < 0; posicao++) {
			Itens itemTemp = itens.get(posicao);

			if (itemTemp.getProduto().equals(produto)) {
				itemEncontrado = posicao;
			}
		}

		Itens item = new Itens();
		item.setProduto(produto);

		if (itemEncontrado < 0) {
			item.setQuantidade(1);
			item.setPreco_parcial(produto.getPreco());
			itens.add(item);
			
		} else {
			Itens itemTemp = itens.get(itemEncontrado);
			item.setQuantidade(itemTemp.getQuantidade() + 1);
			item.setPreco_parcial(produto.getPreco() * item.getQuantidade());
			itens.set(itemEncontrado, item);
			
			
		}
		
		vendasCadastro.setPreco_total( vendasCadastro.getPreco_total() +  produto.getPreco());
	}

	public void remover(Itens item){
		int itemEncontrado = -1;
		for(int pos = 0; pos < itens.size() && itemEncontrado < 0; pos++) {
			Itens itemTemp = itens.get(pos);
			
			if(itemTemp.getProduto().equals(item.getProduto())) {
				itemEncontrado = pos;
			}
		}
		if(itemEncontrado > -1) {
			itens.remove(itemEncontrado);
			vendasCadastro.setPreco_total(vendasCadastro.getPreco_total() - item.getPreco_parcial());
			
		}
		
	}

	public void carregarDadosVenda() {
		vendasCadastro.setHorario(new Date());
		FuncionariosDAO fdao = new FuncionariosDAO();
		Funcionarios funcionario = fdao.buscarPorId(5L);
		vendasCadastro.setFuncionarios(funcionario);
		
	}
	public void salvar() {
		try {
			VendasDAO vdao = new VendasDAO();
			vdao.salvar(vendasCadastro);
			
			vendasCadastro = new Vendas();
			vendasCadastro.setPreco_total(0.00);
			itens = new ArrayList<Itens>();
		 
		 JFSUtil.mensagemSucesso("Venda Finalizada com sucesso!!!");
		}
		catch(RuntimeException e) {
			JFSUtil.mensagemErro(e.getMessage());
		}
		
	}
	
}
