package br.pro.hashi.ensino.desagil.rafaelogic.view;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;

import br.pro.hashi.ensino.desagil.rafaelogic.model.Gate;
import br.pro.hashi.ensino.desagil.rafaelogic.model.Source;

public class GateView extends JPanel implements ItemListener {

	private static final long serialVersionUID = 1L;

	private Gate gate;
	Source source1 = new Source();
	Source source2 = new Source();

	private	JCheckBox porta1Check;
	private	JCheckBox porta2Check;
	private	JCheckBox resultCheck;

	public GateView(Gate gate) {
		this.gate = gate;

		porta1Check = new JCheckBox("Porta 1");
		porta1Check.setMnemonic(KeyEvent.VK_C);
		porta1Check.setSelected(false);
		
		porta2Check = new JCheckBox("Porta 2");
		porta2Check.setMnemonic(KeyEvent.VK_C);
		porta2Check.setSelected(false);
		
		resultCheck = new JCheckBox();
		resultCheck.setMnemonic(KeyEvent.VK_C);

		JLabel portasLabel = new JLabel("Entrada");
		JLabel resultLabel = new JLabel("Saida");

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		add(portasLabel);
		add(porta1Check);
		
		if (gate.getSize()==2){
			add(porta2Check);
		}
		
		add(resultLabel);
		add(resultCheck);

		porta1Check.addItemListener(this);
		porta2Check.addItemListener(this);
		resultCheck.setEnabled(false);
		
		update();
	}
	
	public void itemStateChanged(ItemEvent e) {
		Object event = e.getItemSelectable();
		
		if (event == porta1Check){
			source1.turn(true);
		}
		
		if (event == porta2Check){
			source2.turn(true);
		}
		
		if (e.getStateChange() == ItemEvent.DESELECTED) {
			if (event == porta1Check){
				source1.turn(false);
			}
			
			if (event == porta2Check){
				source2.turn(false);
			}
		}
		update();
	}

	private void update() {
		try {
			if (gate.getSize() == 1){
				gate.connect(0,source1);
			}
			
			else{
				gate.connect(0,source1);
				gate.connect(1,source2); 
			}
		}
		
		catch(NumberFormatException exception) {
			return;
		}
		
		resultCheck.setSelected(gate.read());
	}
}