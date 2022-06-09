package br.com.farmacia.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.farmacia.domain.Vendas;
import br.com.farmacia.util.HibernateUtil;

public class VendasDAO {

	public Long salvar(Vendas vendas) {
		// Inicia a sess�o, ou seja a conex�o com o bd
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null; // inicia uma variavel de transa��o com valor nulo

		Long id = null;
		try {
			transacao = sessao.beginTransaction(); // abrindo a transa��o
			id = (Long) sessao.save(vendas);
			transacao.commit(); // Confirma��o da transa��o

		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback(); // desfaz a transa��o
			}

		}

		finally {
			sessao.close();
		}
		return id;
	}

	
	@SuppressWarnings("unchecked")
	public List<Vendas> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<Vendas> vendas = null;

		try {

			Query consulta = sessao.getNamedQuery("Vendas.listar");
			vendas = consulta.list();

		} catch (RuntimeException e) {
			throw e;

		}

		finally {
			sessao.close();
		}
		return vendas;
	}


	public Vendas buscarPorId(Long id) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Vendas vendas = null;

		try {

			Query consulta = sessao.getNamedQuery("Vendas.buscarPorId");
			consulta.setLong("id", id);
			vendas =  (Vendas) consulta.uniqueResult();

		} catch (RuntimeException e) {
			throw e;

		}

		finally {
			sessao.close();
		}
		return vendas;
	}
	public void deletar(Vendas vendas) {
		// Inicia a sess�o, ou seja a conex�o com o bd
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null; // inicia uma variavel de transa��o com valor nulo

		try {
			transacao = sessao.beginTransaction(); // abrindo a transa��o
			
			sessao.delete(vendas);
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
	
	public void editar(Vendas vendas) {
		// Inicia a sess�o, ou seja a conex�o com o bd
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null; // inicia uma variavel de transa��o com valor nulo

		try {
			transacao = sessao.beginTransaction(); // abrindo a transa��o
			sessao.update(vendas);
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
