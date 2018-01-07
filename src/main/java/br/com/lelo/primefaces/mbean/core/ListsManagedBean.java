package br.com.lelo.primefaces.mbean.core;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.lelo.primefaces.model.Comprador;
import br.com.lelo.primefaces.model.Filial;
import br.com.lelo.primefaces.model.Fornecedor;
import br.com.lelo.primefaces.model.Model;
import br.com.lelo.primefaces.model.Produto;

@ManagedBean(name = "beanLists")
public class ListsManagedBean {

	public List<Model> listAllProdutos() {
		return this.listAll(new Produto());
	}

	public List<Model> listAllComprador() {
		return this.listAll(new Comprador());
	}

	public List<Model> listAllFornecedor() {
		return this.listAll(new Fornecedor());
	}

	public List<Model> listAllFilial() {
		return this.listAll(new Filial());
	}

	private List<Model> listAll(Model model) {
		return model.listAll();
	}

}
