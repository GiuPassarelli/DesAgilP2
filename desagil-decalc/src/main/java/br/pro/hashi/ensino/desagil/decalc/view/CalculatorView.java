package br.pro.hashi.ensino.desagil.decalc.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.pro.hashi.ensino.desagil.decalc.model.Calculator;

// A classe JPanel representa um painel da interface gráfica,
// onde você pode adicionar componentes como menus e botões.
// Esta em particular representa o subpainel de uma calculadora.
// A interface ActionListener é explicada melhor mais abaixo.
public class CalculatorView extends JPanel implements ActionListener {

	// Não é necessário entender esta linha, mas se você estiver curioso
	// pode ler http://blog.caelum.com.br/entendendo-o-serialversionuid/.
	private static final long serialVersionUID = 1L;

	private Calculator calculator;

	// A classe JTextField representa um componente usado para digitação de texto.
	// https://docs.oracle.com/javase/tutorial/uiswing/components/textfield.html
	private	JTextField weightField;
	private	JTextField radiusField;
	private JTextField resultField;

	public CalculatorView(Calculator calculator) {
		this.calculator = calculator;

		weightField = new JTextField();
		radiusField = new JTextField();
		resultField = new JTextField();

		// A classe JLabel representa um componente que é simplesmente texto fixo.
		// https://docs.oracle.com/javase/tutorial/uiswing/components/label.html
		JLabel weightLabel = new JLabel("Weight");
		JLabel radiusLabel = new JLabel("Radius");
		JLabel resultLabel = new JLabel("Result");

		// Todo painel precisa de um layout, que estabelece como os componentes
		// são organizados dentro dele. O layout escolhido na linha abaixo é o
		// mais simples possível: simplesmente enfileira todos eles na vertical.
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// Adiciona todas as componentes a este subpainel.
		add(weightLabel);
		add(weightField);
		add(radiusLabel);
		add(radiusField);
		add(resultLabel);
		add(resultField);

		// Estabelece que este subpainel reage ao usuário digitar nos dois
		// primeiros campos. Isso só pode ser feito se este subpainel for
		// do tipo ActionListener, por isso ele implementa essa interface.
		weightField.addActionListener(this);
		radiusField.addActionListener(this);

		// Estabelece que o terceiro campo está desativado, não é digitável.
		resultField.setEnabled(false);

		// Não podemos esquecer de chamar update na inicialização,
		// caso contrário a interface só ficará consistente depois
		// da primeira interação do usuário com os campos de texto.
		// A definição exata do método update é dada logo abaixo.
		update();
	}


	// Método que lê o peso e o raio dos primeiros campos,
	// calcula a densidade e a escreve no terceiro campo.
	private void update() {
		double weight;
		double radius;

		try {
			weight = Double.parseDouble(weightField.getText());
			radius = Double.parseDouble(radiusField.getText());
		}
		catch(NumberFormatException exception) {
			resultField.setText("?");
			return;
		}

		double result = calculator.calculate(weight, radius);
		resultField.setText(Double.toString(result));
	}


	// Método exigido pela interface ActionListener, que representa
	// a reação a uma digitação do usuário nos dois primeiros campos.
	@Override
	public void actionPerformed(ActionEvent event) {
		update();
	}
}