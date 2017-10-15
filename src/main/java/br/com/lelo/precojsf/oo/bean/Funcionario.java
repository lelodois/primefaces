package br.com.lelo.precojsf.oo.bean;

import br.com.lelo.precojsf.oo.enums.CargoEnum;

public class Funcionario {

	private String nome;
	private String documento;
	private CargoEnum cargo;
	private double salario;

	public Funcionario(String nome, String documento, CargoEnum cargo, double salario) {
		this.nome = nome;
		this.documento = documento;
		this.cargo = cargo;
		this.salario = salario;
	}

	public String getDocumento() {
		return documento;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public CargoEnum getCargo() {
		return cargo;
	}

	public void setCargo(CargoEnum cargo) {
		this.cargo = cargo;
	}

}
