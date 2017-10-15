package br.com.lelo.precojsf.oo.rules;

import br.com.lelo.precojsf.oo.bean.Funcionario;
import br.com.lelo.precojsf.oo.enums.CargoEnum;
import br.com.lelo.precojsf.oo.enums.GratificadorMetaEnum;
import br.com.lelo.precojsf.oo.implementacao.GratificadorMeta;

public class CalculadoraSalario {

	public static void main(String[] args) {
		GratificadorMeta meta = new GratificadorMeta(GratificadorMetaEnum.META_ALCANCADA);
		CalculadoraSalario calculadora = new CalculadoraSalario();
		calculadora.calcular(new Funcionario("Loeiruso", "418194", CargoEnum.DBA, 1900.00));
		calculadora.calcular(new Funcionario("Loieuurw", "321451", CargoEnum.PROGRAMADOR, 2900.00), meta);
	}

	public double calcular(Funcionario funcionario) {
		return this.calcular(funcionario, null);
	}

	public double calcular(Funcionario funcionario, GratificadorMeta meta) {
		double gratificacao = funcionario.getCargo().calcularGratificacao(funcionario);
		if (meta != null) {
			gratificacao += meta.calcularGratificacao(funcionario);
		}
		return gratificacao;
	}
}
