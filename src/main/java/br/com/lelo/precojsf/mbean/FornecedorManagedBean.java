package br.com.lelo.precojsf.mbean;

import javax.faces.bean.ManagedBean;

import br.com.lelo.precojsf.commons.FacesContextMessageUtil;
import br.com.lelo.precojsf.model.Fornecedor;

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
