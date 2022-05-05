package br.com.farmacia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_itens")
public class Itens {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name="Ite_id")
	private Long id;
	
	
	@Column(name="Ite_quantidade", nullable = false)
	private Integer quantidade;
	
	@Column(name="Ite_preco_parcial",  nullable = false, scale= 2, precision= 10 )
	private Double preco_parcial;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="tb_produtos_pro_id", referencedColumnName = "pro_id", nullable = false)
	private Produtos produtos;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="tb_vendas_ven_id", referencedColumnName = "ven_id", nullable = false)
	private Vendas vendas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco_parcial() {
		return preco_parcial;
	}

	public void setPreco_parcial(Double preco_parcial) {
		this.preco_parcial = preco_parcial;
	}

	public Produtos getProdutos() {
		return produtos;
	}

	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}

	public Vendas getVendas() {
		return vendas;
	}

	public void setVendas(Vendas vendas) {
		this.vendas = vendas;
	}
	
	
	
}