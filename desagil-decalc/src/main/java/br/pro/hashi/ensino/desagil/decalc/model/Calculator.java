package br.pro.hashi.ensino.desagil.decalc.model;

public abstract class Calculator {
	private String name;

	protected Calculator(String name) {
		this.name = name;
	}

	// Quando você ler a classe View, vai entender o nome deste método.
	public String toString() {
		return name;
	}

	public abstract double calculate(double weight, double radius);
}
