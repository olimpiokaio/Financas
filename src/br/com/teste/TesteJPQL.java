package br.com.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.model.Conta;
import br.com.model.Movimentacao;
import br.com.model.TipoMovimentacao;
import br.com.util.JPAUtil;

public class TesteJPQL {
	public static void main(String []args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(4L);
		
		String jpql = "select m from Movimentacao m where m.conta = :pConta" +
				" and m.movimentacao = :pMovimentacao" +
				" order by m.valor desc";
		
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pMovimentacao", TipoMovimentacao.ENTRADA);
		
		List<Movimentacao> listaMovimentacao = query.getResultList();
		
		for (Movimentacao m : listaMovimentacao) {
			System.out.println(m.getMovimentacao());
			System.out.println(m.getValor());
			System.out.println(m.getDescricao());
			System.out.println(m.getConta().getTitular());
			System.out.println("-------------------------\n");
		}
		
		em.getTransaction().commit();
		em.close();
	}
}











