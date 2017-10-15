package br.com.lelo.precojsf.oo.implementacao;

import br.com.lelo.precojsf.oo.bean.Funcionario;
import br.com.lelo.precojsf.oo.especificacao.Gratificador;

public class GratificadorProgramador implements Gratificador {

	@Override
	public double calcularGratificacao(Funcionario funcionario) {
		return funcionario.getSalario() * 0.05;
	}

}