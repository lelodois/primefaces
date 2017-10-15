package br.com.lelo.precojsf.mbean;

import javax.faces.bean.ManagedBean;

import br.com.lelo.precojsf.commons.FacesContextMessageUtil;
import br.com.lelo.precojsf.model.Filial;

@ManagedBean(name = "beanFilial")
public class FilialManagedBean{

	private Filial model = new Filial();

	public void save() {
	    model.save();
        FacesContextMessageUtil.addInfoMessage("Filial Adicionada.");
        model = new Filial();
	}

	public String novaFilial() {
		return "filial";
	}

	public Filial getModel() {
		return model;
	}

}
