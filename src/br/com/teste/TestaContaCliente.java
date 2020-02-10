package br.com.teste;

import javax.persistence.EntityManager;

import br.com.model.Cliente;
import br.com.model.Conta;

import br.com.util.JPAUtil;

public class TestaContaCliente {
	public static void main(String []args) {
		
		Conta conta = new Conta();
		conta.setNumero("4568-12");
		conta.setBanco("Santander");
		conta.setAgencia("45875-23");
		conta.setTitular("Olimpio Kaio Rodrigues Silva");
		
		Cliente cliente = new Cliente();
		cliente.setNome("Olimpio Kaio Rodrigues Silva");
		cliente.setEndereco("Cidade fulano, rua 123");
		cliente.setProficao("Analista e desenvolvedor de sistemas");
		cliente.setConta(conta);
				
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(conta);
		em.persist(cliente);
		
		em.getTransaction().commit();
		em.close();
	}
}
























