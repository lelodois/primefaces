package br.com.lelo.precojsf.model;

import java.math.BigDecimal;

public class ProdutoFilial extends Model {

	private static final long serialVersionUID = -2010317548005095731L;

	private Comprador comprador = new Comprador();
	private Fornecedor fornecedor = new Fornecedor();
	private Filial filial = new Filial();
	private Produto produto = new Produto();
	private BigDecimal verba = null;
	private Preco preco = null;

	public Comprador getComprador() {
		return comprador;
	}

	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public BigDecimal getVerba() {
		return verba;
	}

	public Preco getPreco() {
		return preco;
	}

	public void setPreco(Preco preco) {
		this.preco = preco;
	}

	public void setVerba(BigDecimal verba) {
		this.verba = verba;
	}

}
