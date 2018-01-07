package br.com.lelo.primefaces.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.DualListModel;

import br.com.lelo.primefaces.business.ProdutoBusiness;
import br.com.lelo.primefaces.commons.FacesContextMessageUtil;
import br.com.lelo.primefaces.model.Filial;
import br.com.lelo.primefaces.model.Model;
import br.com.lelo.primefaces.model.Produto;
import ch.lambdaj.Lambda;

import com.google.common.collect.Lists;

@ManagedBean(name = "beanProduto")
public class ProdutoManagedBean {

	private Produto model = new Produto();
	private ProdutoBusiness business = new ProdutoBusiness();
	private List<Produto> produtos = null;
	private DualListModel<String> filiais;
	private Long codigo;

	@PostConstruct
	public void init() {
		loadDualList(new ArrayList<Model>());
	}

	public void save() {
		business.save(model, filiais.getTarget());
		this.listAllProdutos();
		FacesContextMessageUtil.addInfoMessage("Produto Adicionado.");
		model = new Produto();
		this.loadDualList(Lists.newArrayList());
	}

	public void load(Produto produto) {
		model = produto;
		this.loadDualList(produto.extractFiliais());
	}

	public List<Produto> listAll() {
		if (this.produtos == null) {
			this.listAllProdutos();
		}
		return this.produtos;
	}

	public void loadByCodigo() {
		this.model = new Produto();
		this.model.setCodigo(codigo);
		this.model = (Produto) this.model.getByCodigo();
	}

	public Produto getModel() {
		return model;
	}

	public DualListModel<String> getFiliais() {
		return filiais;
	}

	public void setFiliais(DualListModel<String> filiais) {
		this.filiais = filiais;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	private void loadDualList(List<Model> target) {
		List<String> source = Lambda.extract(new Filial().listAll(), Lambda.on(Filial.class).getNome());
		List<String> targetString = Lambda.extract(target, Lambda.on(Filial.class).getNome());
		source.removeAll(targetString);
		this.filiais = new DualListModel<String>(source, targetString);
	}

	private void listAllProdutos() {
		this.produtos = Lists.newArrayList();
		for (Model model : new Produto().listAll()) {
			this.produtos.add((Produto) model);
		}
	}

}
