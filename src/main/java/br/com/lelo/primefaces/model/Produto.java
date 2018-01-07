package br.com.lelo.primefaces.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

import br.com.lelo.primefaces.commons.ListsUtils;

public class Produto extends Model {

    private static final long serialVersionUID = 1090737057947536147L;

    private Comprador comprador = new Comprador();
    private Fornecedor fornecedor = new Fornecedor();
    private List<ProdutoFilial> filiais = new ArrayList<ProdutoFilial>();
    private String apelido;
    private BigDecimal precoBase = BigDecimal.ZERO;

    public Produto addFilial(ProdutoFilial produtoFilial) {
        this.filiais = new ListsUtils<ProdutoFilial>().initializeSeNull(filiais);
        this.filiais.add(produtoFilial);
        produtoFilial.setProduto(this);
        return this;
    }

    public List<Model> extractFiliais() {
        List<Model> filiaisResult = Lists.newArrayList();
        for (ProdutoFilial produtoFilial : this.filiais) {
            filiaisResult.add(produtoFilial.getFilial());
        }
        return filiaisResult;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

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

    public List<ProdutoFilial> getFiliais() {
        return filiais;
    }

    public BigDecimal getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(BigDecimal precoBase) {
        this.precoBase = precoBase;
    }
}
