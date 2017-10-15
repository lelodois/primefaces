package br.com.lelo.precojsf.oo.enums;

public enum GratificadorMetaEnum {

	META_SUPERADA(0.78), META_ALCANCADA(0.68);

	private double percentualAcrescimo = 0.0;

	private GratificadorMetaEnum(double percentualAcrescimo) {
		this.percentualAcrescimo = percentualAcrescimo;
	}

	public double getPercentualAcrescimo() {
		return percentualAcrescimo;
	}
}
