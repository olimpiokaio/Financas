package br.com.teste;

import javax.persistence.EntityManager;

import br.com.model.Conta;
import br.com.util.JPAUtil;

public class TesteRemove {
	
	public static void main(String []args) {
		
		Conta conta = new Conta();
		conta.setId(1L);
		conta.setTitular("Olimpio");
		conta.setNumero("123");
		conta.setBanco("Santander");
		conta.setAgencia("123");
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		conta = em.find(Conta.class, 1L);
		em.remove(conta);
		
		em.getTransaction().commit();
		em.close();
	}
	
}
