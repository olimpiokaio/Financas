package br.com.teste;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import br.com.model.Conta;
import br.com.model.TipoMovimentacao;
import br.com.util.JPAUtil;

public class TesteOrderByGroup {
	public static void main(String []args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(4L);;
		
		String jpql = "select distinct avg(m.valor) from Movimentacao m where m.conta = :conta"
				+ " and m.movimentacao = :tipo"
				+ " group by day(m.data), month(m.data), year(m.data)";
		
		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
		
		query.setParameter("conta", conta);
		query.setParameter("tipo", TipoMovimentacao.SAIDA);
		
		List<Double> lista = query.getResultList();
		
		for (Double res : lista) {
			System.out.println("dia 26: " + res);
			System.out.println("dia 31: " + res);
		}
		
		em.getTransaction().commit();
		em.close();
	}
}