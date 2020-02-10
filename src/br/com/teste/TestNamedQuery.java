package br.com.teste;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import br.com.model.Conta;
import br.com.model.TipoMovimentacao;
import br.com.util.JPAUtil;

public class TestNamedQuery {
	
	public static void main(String []args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(4L);
		
		TypedQuery<Double> query = em.createNamedQuery("mediasPorDiaETipo", Double.class);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		List<Double> lista = query.getResultList();
		
		for (Double res : lista) {
			System.out.println("dia 26: " + res);
			System.out.println("dia 31: " + res);
		}
		
		em.getTransaction().commit();
		em.close();
	}
	
}
