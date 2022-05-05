package br.com.farmacia.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_vendas")
public class Vendas {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name="ven_id")
	private Long id;
	
	@Temporal(value= TemporalType.TIMESTAMP)
	@Column(name="ven_horario", length = 50, nullable = false)
	private Date horario;
	
	
	
	@Column(name="ven_preco_total", nullable = false, scale= 2, precision= 10 )
	private Double preco_total;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="tb_funcionario_fun_id", referencedColumnName = "fun_id", nullable = false)
	private Funcionarios funcionarios;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public Double getPreco_total() {
		return preco_total;
	}

	public void setPreco_total(Double preco_total) {
		this.preco_total = preco_total;
	}

	public Funcionarios getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Funcionarios funcionarios) {
		this.funcionarios = funcionarios;
	}

	
	
}
	