package br.com.lelo.precojsf.mbean.core;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "beanLinks")
public class LinksManagedBean {

    public String toFilial() {
        return getFormName("filial", true);
    }

    public String toProduto() {
        return getFormName("produto", true);
    }

    public String toComprador() {
        return getFormName("comprador", false);
    }

    public String toFornecedor() {
        return getFormName("fornecedor", true);
    }

    private String getFormName(String form, boolean redirect) {
        return redirect ? form + "?faces-redirect=true" : form;
    }
}
