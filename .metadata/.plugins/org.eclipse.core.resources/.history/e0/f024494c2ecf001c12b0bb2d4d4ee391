package br.com.farmacia.DAO;

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

}
