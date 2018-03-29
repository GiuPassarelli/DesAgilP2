package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class AndGate extends Gate{

	private NandGate nand = new NandGate();

	@Override
	public void connect(int pinIndex, Emitter emitter) {
		nand.connect(pinIndex, emitter);
	}
	
	@Override
	public boolean read() {
		System.out.println(nand.read());
		return !(nand.read());
	}
}
