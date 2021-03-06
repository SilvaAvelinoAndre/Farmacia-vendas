package br.com.farmacia.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.util.HibernateUtil;

public class FornecedoresDAO {

	public void salvar(Fornecedores fornecedor) {
		// Inicia a sess?o, ou seja a conex?o com o bd
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null; // inicia uma variavel de transa??o com valor nulo

		try {
			transacao = sessao.beginTransaction(); // abrindo a transa??o
			sessao.save(fornecedor);
			transacao.commit(); // Confirma??o da transa??o

		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback(); // desfaz a transa??o
			}

		}

		finally {
			sessao.close();
		}
	}

	
	@SuppressWarnings("unchecked")
	public List<Fornecedores> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<Fornecedores> fornecedor = null;

		try {

			Query consulta = sessao.getNamedQuery("Fornecedores.listar");
			fornecedor = consulta.list();

		} catch (RuntimeException e) {
			throw e;

		}

		finally {
			sessao.close();
		}
		return fornecedor;
	}


	public Fornecedores buscarPorId(Long id) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Fornecedores fornecedor = null;

		try {

			Query consulta = sessao.getNamedQuery("Fornecedores.buscarPorId");
			consulta.setLong("id", id);
			fornecedor =  (Fornecedores) consulta.uniqueResult();

		} catch (RuntimeException e) {
			throw e;

		}

		finally {
			sessao.close();
		}
		return fornecedor;
	}
	public void deletar(Fornecedores fornecedor) {
		// Inicia a sess?o, ou seja a conex?o com o bd
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null; // inicia uma variavel de transa??o com valor nulo

		try {
			transacao = sessao.beginTransaction(); // abrindo a transa??o
			
			sessao.delete(fornecedor);
			transacao.commit(); // Confirma??o da transa??o

		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback(); // desfaz a transa??o
			}

		}

		finally {
			sessao.close();
		}
	}
	
	public void editar(Fornecedores fornecedor) {
		// Inicia a sess?o, ou seja a conex?o com o bd
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null; // inicia uma variavel de transa??o com valor nulo

		try {
			transacao = sessao.beginTransaction(); // abrindo a transa??o
			sessao.update(fornecedor);
			transacao.commit(); // Confirma??o da transa??o

		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback(); // desfaz a transa??o
			}

		}

		finally {
			sessao.close();
		}
	}
}
