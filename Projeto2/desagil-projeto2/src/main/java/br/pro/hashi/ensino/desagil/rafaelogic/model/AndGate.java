package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class AndGate extends Gate{

	private NandGate nand;
	private NotGate not;
	
	public AndGate() {
		nand = new NandGate();
		not = new NotGate();
		}

	@Override
	public void connect(int pinIndex, Emitter emitter) {
		nand.connect(pinIndex, emitter);
		not.connect(0, nand);
	}
		
	@Override
	public boolean read() {
		return (not.read());
	}
}
