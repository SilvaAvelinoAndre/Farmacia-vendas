package br.com.farmacia.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name="tb_funcionarios")
@NamedQueries({
@NamedQuery(name= "Funcionarios.listar", query = "SELECT funcionario FROM  Funcionarios funcionario" ),
@NamedQuery(name= "Funcionarios.buscarPorId", query = "SELECT funcionario FROM  Funcionarios funcionario WHERE funcionario.id = :id")
})
public class Funcionarios {
	

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name="fun_id")
	private Long id;
	
	@NotEmpty(message = "Insira um Nome!")
	@Column(name="fun_nome", length = 50, nullable = false )
	private String nome;
	
	@CPF(message = "CPF Incorreto!")
	@Column(name="fun_cpf", length = 14, nullable = false, unique = true )
	private String cpf;
	
	@NotEmpty(message = "Insira uma Senha!")
	@Size(min = 5, max  = 8, message = "A senha deve conter de 5 a 8 caracteres!")
	@Column(name="fun_senha", length = 50, nullable = false  )
	private String senha;
	
	@NotEmpty(message = "Insira um Cargo!")
	@Column(name="fun_funcao", length = 50, nullable = false  )
	private String funcao;

	public Funcionarios() {
		
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	@Override
	public String toString() {
		return "Id do funcinário: " + id + ", nome: " + nome + ", cpf: " + cpf + ", senha: " + senha + ", cargo: " + funcao + ".";
	}


	@Override
	public int hashCode() {
		return Objects.hash(cpf, funcao, id, nome, senha);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionarios other = (Funcionarios) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(funcao, other.funcao) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(senha, other.senha);
	}

	
	
}
