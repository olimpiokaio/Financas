package br.com.teste;

import javax.persistence.EntityManager;

import br.com.dao.MovimentacaoDao;
import br.com.model.Conta;
import br.com.model.TipoMovimentacao;
import br.com.util.JPAUtil;

public class TesteFuncaoJpql {
	public static void main(String []args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		MovimentacaoDao md = new MovimentacaoDao(em);
		
		Conta conta = new Conta();
		conta.setId(4L);
		
		System.out.printf("soma valores SAIDA: %.2f%n", 
			md.getSomaValoresSaida(conta, TipoMovimentacao.SAIDA));
		
		em.getTransaction().commit();
		em.close();
	}
}















