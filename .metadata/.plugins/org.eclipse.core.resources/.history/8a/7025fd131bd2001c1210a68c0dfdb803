package br.com.farmacia.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.util.HibernateUtil;

public class FornecedoresDAO {

	public void salvar(Fornecedores fornecedor) {
		// Inicia a sessão, ou seja a conexão com o bd
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null; // inicia uma variavel de transação com valor nulo

		try {
			transacao = sessao.beginTransaction(); // abrindo a transação
			sessao.save(fornecedor);
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
	
	@SuppressWarnings({ "unchecked", "finally" })
	public List<Fornecedores> listar(){
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
		
	}


