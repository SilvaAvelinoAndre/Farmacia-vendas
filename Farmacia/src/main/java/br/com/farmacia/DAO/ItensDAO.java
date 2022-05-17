package br.com.farmacia.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.farmacia.domain.Itens;
import br.com.farmacia.util.HibernateUtil;

public class ItensDAO {

	public void salvar(Itens itens) {
		// Inicia a sessão, ou seja a conexão com o bd
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null; // inicia uma variavel de transação com valor nulo

		try {
			transacao = sessao.beginTransaction(); // abrindo a transação
			sessao.save(itens);
			transacao.commit(); // Confirmação da transação

		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback(); // desfaz a transação
			}

		}

		finally {
			sessao.close();
		}
	}

	
	@SuppressWarnings("unchecked")
	public List<Itens> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<Itens> itens = null;

		try {

			Query consulta = sessao.getNamedQuery("Itens.listar");
			itens = consulta.list();

		} catch (RuntimeException e) {
			throw e;

		}

		finally {
			sessao.close();
		}
		return itens;
	}


	public Itens buscarPorId(Long id) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Itens itens = null;

		try {

			Query consulta = sessao.getNamedQuery("Itens.buscarPorId");
			consulta.setLong("id", id);
			itens =  (Itens) consulta.uniqueResult();

		} catch (RuntimeException e) {
			throw e;

		}

		finally {
			sessao.close();
		}
		return itens;
	}
	public void deletar(Itens itens) {
		// Inicia a sessão, ou seja a conexão com o bd
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null; // inicia uma variavel de transação com valor nulo

		try {
			transacao = sessao.beginTransaction(); // abrindo a transação
			
			sessao.delete(itens);
			transacao.commit(); // Confirmação da transação

		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback(); // desfaz a transação
			}

		}

		finally {
			sessao.close();
		}
	}
	
	public void editar(Itens itens) {
		// Inicia a sessão, ou seja a conexão com o bd
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null; // inicia uma variavel de transação com valor nulo

		try {
			transacao = sessao.beginTransaction(); // abrindo a transação
			sessao.update(itens);
			transacao.commit(); // Confirmação da transação

		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback(); // desfaz a transação
			}

		}

		finally {
			sessao.close();
		}
	}
}
