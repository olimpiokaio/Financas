package br.com.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.model.Conta;
import br.com.util.JPAUtil;

public class TesteTodasMovimentacaoComContas {
	public static void main(String []args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		String jpql = "select distinct c from Conta c left join fetch c.movimentacao";
		Query query = em.createQuery(jpql);
		
		List<Conta> res = query.getResultList();
		
		for (Conta c : res) {
			System.out.println(c.getTitular());
			System.out.println(c.getMovimentacao());
		}
		
		em.getTransaction().commit();
		em.close();
	}
}



























