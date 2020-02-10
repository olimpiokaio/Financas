package br.com.model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(query = "select distinct avg(m.valor) from Movimentacao m where m.conta = :pConta"
				+ " and m.movimentacao = :pTipo group by day(m.data)", name = "mediasPorDiaETipo")
public class Movimentacao {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	private BigDecimal valor;

	@Enumerated(EnumType.STRING)
	private TipoMovimentacao movimentacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;

	private String descricao;

	@ManyToOne
	private Conta conta;

	@ManyToMany
	private List<Categoria> categoria;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoMovimentacao getMovimentacao() {
		return movimentacao;
	}

	public void setMovimentacao(TipoMovimentacao movimentacao) {
		this.movimentacao = movimentacao;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public List<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
