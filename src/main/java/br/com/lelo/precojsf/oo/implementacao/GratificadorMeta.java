package br.com.lelo.precojsf.oo.implementacao;

import br.com.lelo.precojsf.oo.bean.Funcionario;
import br.com.lelo.precojsf.oo.enums.GratificadorMetaEnum;
import br.com.lelo.precojsf.oo.especificacao.Gratificador;

public class GratificadorMeta implements Gratificador {

	private GratificadorMetaEnum meta = null;

	public GratificadorMeta(GratificadorMetaEnum meta) {
		this.meta = meta;
	}

	@Override
	public double calcularGratificacao(Funcionario funcionario) {
		return funcionario.getSalario() * meta.getPercentualAcrescimo();
	}

}
