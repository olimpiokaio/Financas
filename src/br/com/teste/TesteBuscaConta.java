package br.com.teste;

import javax.persistence.EntityManager;

import br.com.model.Conta;
import br.com.util.JPAUtil;

public class TesteBuscaConta {

	public static void main(String []args) {
		
		// inicio do entityManager
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		// find -> BUSCA UMA ENTIDADE ATRAVES DE SUA CLASSE E SEU ID
		Conta conta = em.find(Conta.class, 1L);
		conta.setNumero("123");
		conta.setTitular("Olimpio");
		
		System.out.println(conta.getTitular());
		
		em.getTransaction().commit();
		em.close();
		// inicio do entityManager
		
		
		// inicio do 2 entityManager
		EntityManager em2 = new JPAUtil().getEntityManager();
		em2.getTransaction().begin();
		
		conta.setTitular("Olimpio");
		em2.merge(conta);
		System.out.println(conta.getTitular());
		
		em2.getTransaction().commit();
		em2.close();
		// fim do 2 entityManager
		
	}
	
}