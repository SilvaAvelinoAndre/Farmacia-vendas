package br.com.farmacia.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.farmacia.domain.Produtos;
import br.com.farmacia.util.HibernateUtil;

public class ProdutosDAO {

	public void salvar(Produtos produto) {
		// Inicia a sess�o, ou seja a conex�o com o bd
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null; // inicia uma variavel de transa��o com valor nulo

		try {
			transacao = sessao.beginTransaction(); // abrindo a transa��o
			sessao.save(produto);
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
	public List<Produtos> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<Produtos> produto = null;

		try {

			Query consulta = sessao.getNamedQuery("Produtos.listar");
			produto = consulta.list();

		} catch (RuntimeException e) {
			throw e;

		}

		finally {
			sessao.close();
		}
		return produto;
	}


	public Produtos buscarPorId(Long id) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Produtos produto = null;

		try {

			Query consulta = sessao.getNamedQuery("Produtos.buscarPorId");
			consulta.setLong("id", id);
			produto =  (Produtos) consulta.uniqueResult();

		} catch (RuntimeException e) {
			throw e;

		}

		finally {
			sessao.close();
		}
		return produto;
	}
	public void deletar(Produtos produto) {
		// Inicia a sess�o, ou seja a conex�o com o bd
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null; // inicia uma variavel de transa��o com valor nulo

		try {
			transacao = sessao.beginTransaction(); // abrindo a transa��o
			
			sessao.delete(produto);
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
	
	public void editar(Produtos produto) {
		// Inicia a sess�o, ou seja a conex�o com o bd
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null; // inicia uma variavel de transa��o com valor nulo

		try {
			transacao = sessao.beginTransaction(); // abrindo a transa��o
			sessao.update(produto);
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
