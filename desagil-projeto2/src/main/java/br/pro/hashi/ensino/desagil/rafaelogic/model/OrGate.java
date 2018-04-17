package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class OrGate extends Gate {
	private NotGate not1;
	private NotGate not2;
	private NandGate nand;
	
	public OrGate(){
		super("Or", 2);
		not1 = new NotGate();
		not2 = new NotGate();
		nand = new NandGate();
		nand.connect(0, not1);
		nand.connect(1, not2);
	}

	@Override
	public void connect(int pinIndex, Emitter emitter) {
		if (pinIndex == 0){
			not1.connect(0, emitter);
		}
		else if(pinIndex == 1){
			not2.connect(0, emitter);
		}
	}
	
	@Override
	public boolean read() {	
		return nand.read();
	}
}
