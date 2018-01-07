package br.com.lelo.primefaces.business;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import br.com.lelo.primefaces.model.Comprador;
import br.com.lelo.primefaces.model.Model;

public class CompradorBusiness {

	public Comprador findByLogin(String email) {
		for (Model model : listAll()) {
			Comprador item = (Comprador) model;
			if (email.equalsIgnoreCase(item.getEmail())) {
				return item;
			}
		}
		return null;
	}

	public boolean isBlank(Comprador comprador) {
		return StringUtils.isBlank(comprador.getEmail()) || StringUtils.isBlank(comprador.getPassword());
	}

	public boolean isEmptyList() {
		return listAll().isEmpty();
	}

	private List<Model> listAll() {
		return new Comprador().listAll();
	}

}
