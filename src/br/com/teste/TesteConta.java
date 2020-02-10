package br.com.teste;

import javax.persistence.EntityManager;
import br.com.model.Conta;
import br.com.util.JPAUtil;

public class TesteConta {
	public static void main(String []args) {

		Conta conta = new Conta();
		conta.setTitular("Tomas");
		conta.setAgencia("563");
		conta.setBanco("Santander");
		conta.setNumero("456");
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		
		em.close();
	}
}
