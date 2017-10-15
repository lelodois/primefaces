package br.com.lelo.precojsf.oo.enums;

import br.com.lelo.precojsf.oo.bean.Funcionario;
import br.com.lelo.precojsf.oo.especificacao.Gratificador;
import br.com.lelo.precojsf.oo.implementacao.GratificadorDba;
import br.com.lelo.precojsf.oo.implementacao.GratificadorProgramador;
import br.com.lelo.precojsf.oo.implementacao.GratificadorQa;

public enum CargoEnum {

	PROGRAMADOR(new GratificadorProgramador()), DBA(new GratificadorDba()), QA(new GratificadorQa());

	private Gratificador salario;

	private CargoEnum(Gratificador event) {
		this.salario = event;
	}

	public double calcularGratificacao(Funcionario funcionario) {
		return salario.calcularGratificacao(funcionario);
	}
}
