package br.pro.hashi.ensino.desagil.rafaelogic.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

import br.pro.hashi.ensino.desagil.rafaelogic.model.Gate;

// A classe JPanel representa um painel da interface gráfica,
// onde você pode adicionar componentes como menus e botões.
// Esta em particular representa o subpainel de uma calculadora.
// A interface ActionListener é explicada melhor mais abaixo.
public class CalculatorView extends JPanel implements ActionListener {

	// Não é necessário entender esta linha, mas se você estiver curioso
	// pode ler http://blog.caelum.com.br/entendendo-o-serialversionuid/.
	private static final long serialVersionUID = 1L;

	private Gate calculator;

	// A classe JTextField representa um componente usado para digitação de texto.
	// https://docs.oracle.com/javase/tutorial/uiswing/components/textfield.html
	private	JCheckBox porta1Check;
	private	JCheckBox porta2Check;
	private	JCheckBox resultCheck;

	public CalculatorView(Gate calculator) {
		this.calculator = calculator;

		porta1Check = new JCheckBox();
		porta2Check = new JCheckBox();
		resultCheck = new JCheckBox();

		// A classe JLabel representa um componente que é simplesmente texto fixo.
		// https://docs.oracle.com/javase/tutorial/uiswing/components/label.html
		JLabel porta1Label = new JLabel("Porta1");
		JLabel porta2Label = new JLabel("Porta2");
		JLabel resultLabel = new JLabel("Resultado");

		// Todo painel precisa de um layout, que estabelece como os componentes
		// são organizados dentro dele. O layout escolhido na linha abaixo é o
		// mais simples possível: simplesmente enfileira todos eles na vertical.
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// Adiciona todas as componentes a este subpainel.
		add(porta1Label);
		add(porta1Check);
		if (calculator.getSize()==2){
			add(porta2Label);
			add(porta2Check);
		}
		add(resultLabel);
		add(resultCheck);

		// Estabelece que este subpainel reage ao usuário digitar nos dois
		// primeiros campos. Isso só pode ser feito se este subpainel for
		// do tipo ActionListener, por isso ele implementa essa interface.
		porta1Check.addActionListener(this);
		porta2Check.addActionListener(this);

		// Estabelece que o terceiro campo está desativado, não é digitável.
		resultCheck.setEnabled(false);

		// Não podemos esquecer de chamar update na inicialização,
		// caso contrário a interface só ficará consistente depois
		// da primeira interação do usuário com os campos de texto.
		// A definição exata do método update é dada logo abaixo.
//		update();
	}


	// Método que lê o peso e o raio dos primeiros campos,
	// calcula a densidade e a escreve no terceiro campo.
//	private void update() {
//		boolean porta1;
//		boolean porta2;

//		try {
//			porta1 = Boolean.parseBoolean(porta1Field.getText());
//			porta2 = Boolean.parseBoolean(porta2Field.getText());
//		}
//		catch(NumberFormatException exception) {
//			resultField.setText("?");
//			return;
//		}

//		boolean result = calculator.read();
//		resultField.setText(Boolean.toString(result));
//	}


	// Método exigido pela interface ActionListener, que representa
	// a reação a uma digitação do usuário nos dois primeiros campos.
	@Override
	public void actionPerformed(ActionEvent event) {
//		update();
	}
}