package br.com.lelo.primefaces.mbean;

import javax.faces.bean.ManagedBean;

import br.com.lelo.primefaces.commons.FacesContextMessageUtil;
import br.com.lelo.primefaces.model.Comprador;

@ManagedBean(name = "beanComprador")
public class CompradorManagedBean {

	private Comprador model = new Comprador();

	public void save() { 
	    model.save();
        FacesContextMessageUtil.addInfoMessage("Comprador Adicionado.");
        model = new Comprador();
	}

	public Comprador getModel() {
        return model;
    }

}
