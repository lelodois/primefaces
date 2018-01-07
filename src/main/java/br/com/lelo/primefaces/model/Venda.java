package br.com.lelo.primefaces.model;

import java.math.BigDecimal;

public class Venda extends Model {

	private static final long serialVersionUID = -6825771001119188909L;

	private ProdutoFilial produtoFilial = new ProdutoFilial();
	private BigDecimal quantidade;
	private BigDecimal valor;
	private BigDecimal custo;

	public BigDecimal getCusto() {
		return custo;
	}

	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}

	public ProdutoFilial getProdutoFilial() {
		return produtoFilial;
	}

	public void setProdutoFilial(ProdutoFilial produtoFilial) {
		this.produtoFilial = produtoFilial;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}