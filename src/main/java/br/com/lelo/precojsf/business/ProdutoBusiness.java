package br.com.lelo.precojsf.business;

import java.util.Iterator;
import java.util.List;

import br.com.lelo.precojsf.model.Comprador;
import br.com.lelo.precojsf.model.Filial;
import br.com.lelo.precojsf.model.Fornecedor;
import br.com.lelo.precojsf.model.Model;
import br.com.lelo.precojsf.model.Preco;
import br.com.lelo.precojsf.model.Produto;
import br.com.lelo.precojsf.model.ProdutoFilial;

import com.google.common.collect.Lists;

public class ProdutoBusiness {

	public Produto save(Produto produto, List<String> filiaisNames) {
		produto.setApelido(produto.getNome());
		if (produto.getComprador().getId() != null) {
			produto.setComprador((Comprador) produto.getComprador().get());
		}
		if (produto.getFornecedor().getId() != null) {
			produto.setFornecedor((Fornecedor) produto.getFornecedor().get());
		}

		List<Model> allFiliais = new Filial().listAll();
		for (String filial : filiaisNames) {
			for (Model model : allFiliais) {
				if (filial.equals(model.getNome())) {
					ProdutoFilial produtoFilial = new ProdutoFilial();
					produtoFilial.setFilial((Filial) model);
					produto.addFilial(produtoFilial);
				}
			}
		}
		return (Produto) produto.save();
	}

	public void adicionarPrecosByPrecoBase(Long codigoProduto, Preco preco) {
		Produto produto = (Produto) new Produto().getByCodigo(codigoProduto);
		produto.setPrecoBase(preco.getPreco());
		produto.save();

		for (Iterator<Model> iterator = preco.listAll().iterator(); iterator.hasNext();) {
			Preco model = (Preco) iterator.next();
			if (model.getProdutoFilial().getProduto().getId().equals(produto.getId())) {
				model.remove();
			}
		}

		for (ProdutoFilial produtoFilial : produto.getFiliais()) {
			Preco produtoFilialPreco = new Preco();
			produtoFilialPreco.setCodigo(produto.getCodigo() * produtoFilial.getFilial().getCodigo());
			produtoFilialPreco.setNome("Pre�o Permanente");
			produtoFilialPreco.setInicioVigencia(preco.getInicioVigencia());
			produtoFilialPreco.setFimVigencia(preco.getFimVigencia());
			produtoFilialPreco.setPreco(preco.getPreco());
			produtoFilialPreco.setProdutoFilial(produtoFilial);
			produtoFilialPreco.save();
		}
	}

	public List<Preco> findPrecosByCodigoProduto(Long codigoProduto) {
		List<Preco> precos = Lists.newArrayList();
		for (Model model : new Preco().listAll()) {
			Preco preco = (Preco) model;
			if (preco.getProdutoFilial().getProduto().getCodigo().equals(codigoProduto)) {
				precos.add(preco);
			}
		}
		return precos;
	}
}
