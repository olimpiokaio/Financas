package br.com.teste;

import java.util.ArrayList;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.model.Conta;
import br.com.model.Movimentacao;
import br.com.util.JPAUtil;

public class TesteContaMovimentacao {
	public static void main(String []args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 4L);
		
		String dadosConta = String.format("BANCO: %s%nTITULAR: %s%nAGENCIA: %s",
				conta.getBanco(), conta.getTitular(), conta.getAgencia());
		
		ArrayList<Movimentacao> movimentacoes = new ArrayList<>();
		for (Movimentacao mv : conta.getMovimentacao()) {
			movimentacoes.add(mv);
		}
		
		
		System.out.println(dadosConta);
		System.out.println(" -------------------------------- ");
		
		Calendar data;
		for (int i = 0; i < movimentacoes.size(); i++) {
			System.out.println("MOVIMENTAÇÃO: " + movimentacoes.get(i).getMovimentacao());
			System.out.println("VALOR: " + movimentacoes.get(i).getValor());
			
			data = movimentacoes.get(i).getData();
			System.out.printf("DATA: %d/%d/%d %dh%dm%ds%n", 
					data.get(Calendar.DAY_OF_MONTH),
					data.get(Calendar.MONTH) + 1, // m�s no java inicia com zero, por isso e colocado + 1
					data.get(Calendar.YEAR),
					data.get(Calendar.HOUR_OF_DAY),
					data.get(Calendar.MINUTE),
					data.get(Calendar.SECOND));
			
			System.out.println("DESCRIÇÃO: " + movimentacoes.get(i).getDescricao());
			System.out.println(" -------------------------------- ");
		}
		
		em.getTransaction().commit();
		em.close();
	}
}
