package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class NotGate extends Gate{
	private NandGate nand;
	
	public NotGate() {
		super("Not", 1);
		nand = new NandGate();
	}

	@Override
	public void connect(int pinIndex, Emitter emitter) {
		nand.connect(0, emitter);
		nand.connect(1, emitter);
	}
	
	@Override
	public boolean read() {
		return (nand.read());
	}
}
