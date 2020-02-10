package br.com.teste;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.model.Categoria;
import br.com.model.Conta;
import br.com.model.Movimentacao;
import br.com.model.TipoMovimentacao;

import br.com.util.JPAUtil;

public class TesteMovimentacaoComCategoria {
	
	public static void main(String []args) {
		
		Categoria categoria1 = new Categoria("Vendas");
		Categoria categoria2 = new Categoria("Compras");
		
		Movimentacao movimentacao1 = new Movimentacao();
		movimentacao1.setData(Calendar.getInstance()); // hoje
		movimentacao1.setDescricao("App Comercial");
		movimentacao1.setValor(new BigDecimal("3570.0"));
		movimentacao1.setCategoria(Arrays.asList(categoria1));
		movimentacao1.setMovimentacao(TipoMovimentacao.ENTRADA);
		
		
		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setData(Calendar.getInstance()); // hoje
		movimentacao2.setDescricao("Play Station 5");
		movimentacao2.setValor(new BigDecimal(2300.0));
		movimentacao2.setCategoria(Arrays.asList(categoria2));
		movimentacao2.setMovimentacao(TipoMovimentacao.SAIDA);
		
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 10L);
		movimentacao1.setConta(conta);
		movimentacao2.setConta(conta);
		
		em.persist(categoria1);
		em.persist(categoria2);
		
		em.persist(movimentacao1);
		em.persist(movimentacao2);
		
		em.getTransaction().commit();
		em.close();
	}
	
}













