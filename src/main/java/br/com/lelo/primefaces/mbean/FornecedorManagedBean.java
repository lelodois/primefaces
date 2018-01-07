package br.com.lelo.primefaces.mbean;

import javax.faces.bean.ManagedBean;

import br.com.lelo.primefaces.commons.FacesContextMessageUtil;
import br.com.lelo.primefaces.model.Fornecedor;

@ManagedBean(name = "beanFornecedor")
public class FornecedorManagedBean {

    private Fornecedor model = new Fornecedor();

    public void save() {
        model.save();
        FacesContextMessageUtil.addInfoMessage("Fornecedor Adicionado.");
        model = new Fornecedor();
    }

    public Fornecedor getModel() {
        return model;
    }

}
