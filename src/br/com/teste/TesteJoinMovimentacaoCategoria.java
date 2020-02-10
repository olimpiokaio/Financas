package br.com.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.model.Categoria;
import br.com.model.Movimentacao;
import br.com.util.*;

public class TesteJoinMovimentacaoCategoria {
	public static void main(String []args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Categoria categoria = new Categoria();
		categoria.setId(6);
		
		String jpql = "select m from Movimentacao m join m.categoria c where c = :pCategoria";
		Query query = em.createQuery(jpql);
		query.setParameter("pCategoria", categoria);
		
		List<Movimentacao> resultado = query.getResultList();
		
		for (Movimentacao mt : resultado) {
			System.out.println(mt.getDescricao());
			System.out.println(mt.getConta().getId());
			System.out.println("------------------------\n");
		}
		
		em.getTransaction().commit();
		em.close();
	}
}
















