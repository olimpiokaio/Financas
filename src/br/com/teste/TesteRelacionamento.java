package br.com.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.model.Conta;
import br.com.model.Movimentacao;
import br.com.model.TipoMovimentacao;
import br.com.util.JPAUtil;

public class TesteRelacionamento {
	
	public static void main(String []args) {
		
		Conta conta = new Conta();
		conta.setTitular("Olimpio Kaio");
		conta.setBanco("BRB");
		conta.setNumero("1578-12");
		conta.setAgencia("231.784-232");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setDescricao("Churrascaria");
		movimentacao.setMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setValor(new BigDecimal("200.2"));
		
		movimentacao.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(conta);
		em.persist(movimentacao);
		
		em.getTransaction().commit();
		em.close();
	}
	
}












