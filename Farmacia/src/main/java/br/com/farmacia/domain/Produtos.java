package br.com.farmacia.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tb_produtos")
@NamedQueries({
@NamedQuery(name= "Produtos.listar", query = "SELECT produto FROM  Produtos produto" ),
@NamedQuery(name= "Produtos.buscarPorId", query = "SELECT produto FROM  Produtos produto WHERE produto.id = :id")
})
public class Produtos {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name="pro_id")
	private Long id;
	
	@NotEmpty(message = "Insira uma Descrição!")
	@Column(name="pro_descricao", length = 50, nullable = false)
	private String descricao;
	
	@NotNull(message = "Insira uma Quantidade!")
	@Column(name="pro_quantidade", nullable = false)
	private Integer quantidade;
	
	@NotNull(message = "Insira o Preço!")
	@Min(value = 0,message = "O valor não pode ser menor que Zero!")
	@Column(name="pro_preco", nullable = false, scale= 2, precision= 10 )
	private Double preco;
	
	@NotNull(message = "Insira um Fornecedor!")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="tb_forncedores_for_id", referencedColumnName = "for_id", nullable = false)
	private Fornecedores fornecedores; 
	
	
	public Produtos() {
		
	}


	public Produtos(Long id, String descricao, Integer quantidade, Double preco, Fornecedores fornecedores) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco;
		this.fornecedores = fornecedores;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}


	public Fornecedores getFornecedores() {
		return fornecedores;
	}


	public void setFornecedores(Fornecedores fornecedores) {
		this.fornecedores = fornecedores;
	}


	@Override
	public String toString() {
		return "Produtos [id=" + id + ", descricao=" + descricao + ", quantidade=" + quantidade + ", preco=" + preco
				+ ", fornecedores=" + fornecedores + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(descricao, fornecedores, id, preco, quantidade);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produtos other = (Produtos) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(fornecedores, other.fornecedores)
				&& Objects.equals(id, other.id) && Objects.equals(preco, other.preco)
				&& Objects.equals(quantidade, other.quantidade);
	}


	
	
}
