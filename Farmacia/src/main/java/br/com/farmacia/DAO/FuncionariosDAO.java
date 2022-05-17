package br.com.farmacia.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.farmacia.domain.Funcionarios;
import br.com.farmacia.util.HibernateUtil;

public class FuncionariosDAO {

	public void salvar(Funcionarios funcionario) {
		// Inicia a sess�o, ou seja a conex�o com o bd
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null; // inicia uma variavel de transa��o com valor nulo

		try {
			transacao = sessao.beginTransaction(); // abrindo a transa��o
			sessao.save(funcionario);
			transacao.commit(); // Confirma��o da transa��o

		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback(); // desfaz a transa��o
			}

		}

		finally {
			sessao.close();
		}
	}

	
	@SuppressWarnings("unchecked")
	public List<Funcionarios> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<Funcionarios> funcionario = null;

		try {

			Query consulta = sessao.getNamedQuery("Funcionarios.listar");
			funcionario = consulta.list();

		} catch (RuntimeException e) {
			throw e;

		}

		finally {
			sessao.close();
		}
		return funcionario;
	}


	public Funcionarios buscarPorId(Long id) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Funcionarios funcionario = null;

		try {

			Query consulta = sessao.getNamedQuery("Funcionarios.buscarPorId");
			consulta.setLong("id", id);
			funcionario =  (Funcionarios) consulta.uniqueResult();

		} catch (RuntimeException e) {
			throw e;

		}

		finally {
			sessao.close();
		}
		return funcionario;
	}
	public void deletar(Funcionarios funcionario) {
		// Inicia a sess�o, ou seja a conex�o com o bd
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null; // inicia uma variavel de transa��o com valor nulo

		try {
			transacao = sessao.beginTransaction(); // abrindo a transa��o
			
			sessao.delete(funcionario);
			transacao.commit(); // Confirma��o da transa��o

		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback(); // desfaz a transa��o
			}

		}

		finally {
			sessao.close();
		}
	}
	
	public void editar(Funcionarios funcionario) {
		// Inicia a sess�o, ou seja a conex�o com o bd
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null; // inicia uma variavel de transa��o com valor nulo

		try {
			transacao = sessao.beginTransaction(); // abrindo a transa��o
			sessao.update(funcionario);
			transacao.commit(); // Confirma��o da transa��o

		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback(); // desfaz a transa��o
			}

		}

		finally {
			sessao.close();
		}
	}
}
