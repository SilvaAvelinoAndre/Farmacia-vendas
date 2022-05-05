package br.com.farmacia.teste;

import org.junit.Test;

import br.com.farmacia.util.HibernateUtil;

public class GerarTabelasJUnit {
	
	@Test
	public void gerar() {
		
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
		
	}

}
