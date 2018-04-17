package br.pro.hashi.ensino.desagil.rafaelogic.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;

import br.pro.hashi.ensino.desagil.rafaelogic.model.Gate;
import br.pro.hashi.ensino.desagil.rafaelogic.model.Source;

public class GateView extends SimplePanel implements ItemListener, MouseListener {

	private static final long serialVersionUID = 1L;

	private Gate gate;
	Source source1 = new Source();
	Source source2 = new Source();

	private	JCheckBox porta1Check;
	private	JCheckBox porta2Check;
	private	JCheckBox resultCheck;
	
	private Color color;
	private Color newColor;
	private Image image;

	public GateView(Gate gate) {
		super(300, 230);
		
		newColor = Color.RED;
		
		this.gate = gate;

		porta1Check = new JCheckBox("Porta 1");
		porta1Check.setMnemonic(KeyEvent.VK_C);
		porta1Check.setSelected(false);
		
		porta2Check = new JCheckBox("Porta 2");
		porta2Check.setMnemonic(KeyEvent.VK_C);
		porta2Check.setSelected(false);
		
		resultCheck = new JCheckBox();
		resultCheck.setMnemonic(KeyEvent.VK_C);
		
		if (gate.getSize()==1){
			add(porta1Check, 12, 105, 20, 20);
		}
		
		if (gate.getSize()==2){
			add(porta1Check, 12, 65, 20, 20);
			add(porta2Check, 12, 145, 20, 20);
		}

		porta1Check.addItemListener(this);
		porta2Check.addItemListener(this);
		resultCheck.setEnabled(false);
		
		update();
		
		String path = "/" + gate.toString() + ".png";
		URL url = getClass().getResource(path);
		image = new ImageIcon(url).getImage();
		
		addMouseListener(this);
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
				gate.connect(0, source1);
			}
			
			else{
				gate.connect(0, source1);
				gate.connect(1, source2); 
			}
		}
		
		catch(NumberFormatException exception) {
			return;
		}
		
		resultCheck.setSelected(gate.read());
		
		if (resultCheck.isSelected()){
			if (newColor == Color.RED){
				color = Color.RED;
			}
			else{
				color = newColor;
			}
			repaint();
		}
		
		else{
			color = Color.BLACK;
			repaint();
		}
	}
	
	public void actionPerformed(ActionEvent event) {
		update();
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {

		int x = event.getX();
		int y = event.getY();

		if (color !=  Color.BLACK){
			if(Math.pow(x-280, 2)+Math.pow(y-115, 2)<=100) {

				newColor = JColorChooser.showDialog(this, null, color);
				color = newColor;
				repaint();
			}
		}
		
	}
	@Override
	public void mousePressed(MouseEvent event) {
	}
	@Override
	public void mouseReleased(MouseEvent event) {
	}
	@Override
	public void mouseEntered(MouseEvent event) {
	}
	@Override
	public void mouseExited(MouseEvent event) {
	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.drawImage(image, 30, 30, 240, 170, null);
		
		g.setColor(color);
	    g.fillOval(270, 105, 20, 20);

		getToolkit().sync();
    }
}