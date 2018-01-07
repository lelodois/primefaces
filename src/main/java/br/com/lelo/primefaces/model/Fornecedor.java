package br.com.lelo.primefaces.model;

import org.apache.commons.lang.StringUtils;

import br.com.lelo.primefaces.model.enums.TipoPessoaEnum;

public class Fornecedor extends Model {

	private static final long serialVersionUID = 1945815914554995525L;
	private String documento;
	private TipoPessoaEnum tipoPessoa;

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		if (documento != null) {
			documento = StringUtils.replace(documento, ",", "");
			documento = StringUtils.replace(documento, ".", "");
			documento = StringUtils.replace(documento, "-", "");
		}
		this.documento = documento;
	}

	public TipoPessoaEnum getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoaEnum tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

}