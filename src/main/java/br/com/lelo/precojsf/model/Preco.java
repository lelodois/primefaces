package br.com.lelo.precojsf.model;

import java.math.BigDecimal;
import java.util.Date;

public class Preco extends Model {

    private static final long serialVersionUID = 8773819872330698674L;
    private ProdutoFilial produtoFilial = new ProdutoFilial();
    private BigDecimal preco;
    private Date inicioVigencia;
    private Date fimVigencia;
    private boolean precoPromocional;

    public ProdutoFilial getProdutoFilial() {
        return produtoFilial;
    }

    public void setProdutoFilial(ProdutoFilial produtoFilial) {
        this.produtoFilial = produtoFilial;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Date getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(Date inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public Date getFimVigencia() {
        return fimVigencia;
    }

    public boolean isPrecoPromocional() {
        return precoPromocional;
    }

    public void setPrecoPromocional(boolean precoPromocional) {
        this.precoPromocional = precoPromocional;
    }

    public void setFimVigencia(Date fimVigencia) {
        this.fimVigencia = fimVigencia;
    }

}
