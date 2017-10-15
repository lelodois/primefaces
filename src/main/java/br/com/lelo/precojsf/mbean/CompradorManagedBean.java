package br.com.lelo.precojsf.mbean;

import javax.faces.bean.ManagedBean;

import br.com.lelo.precojsf.commons.FacesContextMessageUtil;
import br.com.lelo.precojsf.model.Comprador;

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
