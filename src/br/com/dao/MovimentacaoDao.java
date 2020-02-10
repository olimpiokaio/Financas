package br.com.dao;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.model.Conta;
import br.com.model.TipoMovimentacao;

public class MovimentacaoDao {

	private EntityManager em;

	public MovimentacaoDao(EntityManager em) {
		this.em = em;
	}

	public BigDecimal getSomaValoresSaida(Conta conta, TipoMovimentacao tipo) {
		/*
		 * ou spql = select avg(m.valor) from Movimentacao m where m.conta = conta and
		 * m.movimentacao = :tipo retorna a média em double
		 */
		String jpql = "select sum(m.valor) from Movimentacao m where m.conta = :conta" + " and m.movimentacao = :tipo";

		Query query = em.createQuery(jpql);
		query.setParameter("conta", conta);
		query.setParameter("tipo", tipo);

		return (BigDecimal) query.getSingleResult();
	}

}
