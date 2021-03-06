package br.com.farmacia.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@javax.persistence.Entity
@Table(name="tb_fornecedores")
@NamedQueries({
@NamedQuery(name= "Fornecedores.listar", query = "SELECT fornecedor FROM  Fornecedores fornecedor" ),
@NamedQuery(name= "Fornecedores.buscarPorId", query = "SELECT fornecedor FROM  Fornecedores fornecedor WHERE fornecedor.id = :id")
})
public class Fornecedores {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="for_id")
	private Long id;
	
	
	@javax.validation.constraints.NotEmpty(message = "Insira uma Descri??o!")
	@Column(name="for_descricao", length =50, nullable =false)
	private String descricao;
	
	
	public Fornecedores() {
		
	}


	public Fornecedores(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
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
	
	@Override
	public String toString() {
		return "Id do Fornecedor = " + id + ", Descricao = " + descricao + "!";
	}


	@Override
	public int hashCode() {
		return Objects.hash(descricao, id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedores other = (Fornecedores) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(id, other.id);
	}

}
