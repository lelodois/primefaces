package br.com.lelo.precojsf.mbean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import br.com.lelo.precojsf.business.ProdutoBusiness;
import br.com.lelo.precojsf.model.Preco;
import br.com.lelo.precojsf.model.Produto;

@ManagedBean(name = "beanPoupupNovoPreco")
@SessionScoped
public class PoupupNovoPrecoManagedBean {

	private ProdutoBusiness business = new ProdutoBusiness();
	private Long codigo;
	private List<Preco> precos = null;
	private Preco preco = new Preco();

	public void adicionarPreco() {
		RequestContext.getCurrentInstance().closeDialog(preco);
	}

	public void adicionarPrecoByFilial() {
		for (Preco preco : precos) {
			preco.save();
		}
		RequestContext.getCurrentInstance().closeDialog(precos);
	}

	public void onShowAdicionarPreco(Produto produtoIndex) {
		this.codigo = produtoIndex.getCodigo();
		RequestContext.getCurrentInstance().openDialog("precoNovo", getMapPoupupPrecoOptions(), null);
	}

	public void onShowAdicionarPrecoByFilial(Produto produtoIndex) {
		this.codigo = produtoIndex.getCodigo();
		this.precos = business.findPrecosByCodigoProduto(codigo);
		Map<String, Object> options = getMapPoupupPrecoOptions();
		options.put("width", 800);
		RequestContext.getCurrentInstance().openDialog("precoNovoByFilial", options, null);
	}

	public void onCloseAdicionarPreco(SelectEvent event) {
		Preco preco = (Preco) event.getObject();
		business.adicionarPrecosByPrecoBase(this.codigo, preco);
	}

	public void onCloseAdicionarPrecoByFilial(SelectEvent event) {
	}

	public Long getCodigo() {
		return codigo;
	}

	public Preco getPreco() {
		return preco;
	}

	public void setPreco(Preco preco) {
		this.preco = preco;
	}

	public List<Preco> getPrecos() {
		return precos;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	private Map<String, Object> getMapPoupupPrecoOptions() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("resizable", false);
		options.put("draggable", false);
		options.put("width", 640);
		options.put("height", 340);
		options.put("contentWidth", "100%");
		options.put("contentHeight", "100%");
		options.put("headerElement", "customheader");
		options.put("modal", true);
		return options;
	}

}
