package br.pro.hashi.ensino.desagil.decalc.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import br.pro.hashi.ensino.desagil.decalc.model.Calculator;

// A classe JPanel representa um painel da interface gráfica,
// onde você pode adicionar componentes como menus e botões.
// Esta classe especificamente representa o painel principal.
// A interface ActionListener é explicada melhor mais abaixo.
public class View extends JPanel implements ActionListener {

	// Não é necessário entender esta linha, mas se você estiver curioso
	// pode ler http://blog.caelum.com.br/entendendo-o-serialversionuid/.
	private static final long serialVersionUID = 1L;


	// As duas componentes do painel principal:
	// o menu e o subpainel de uma calculadora.
	private JComboBox<Calculator> menu;
	private CalculatorView calculatorView;


	public View(LinkedList<Calculator> model) {

		// A classe JComboBox representa um componente que pode ser usado como menu:
		// https://docs.oracle.com/javase/tutorial/uiswing/components/combobox.html.
		menu = new JComboBox<>();

		// Os itens do menu são instâncias de Calculator. O texto exibido para cada
		// item é a String devolvida pelo método toString, por isso demos esse nome.
		for(Calculator calculator: model) {
			menu.addItem(calculator);
		}

		// Todo painel precisa de um layout, que estabelece como os componentes
		// são organizados dentro dele. O layout escolhido na linha abaixo é o
		// mais simples possível: simplesmente enfileira todos eles na vertical.
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// Adiciona o menu a este painel.
		add(menu);

		// Adiciona o subpainel da primeira calculadora a este painel.
		addCalculatorView(0);

		// Estabelece que este painel reage a mudanças no menu.
		// Isso só pode ser feito se este painel for do tipo
		// ActionListener, por isso ele implementa essa interface.
		menu.addActionListener(this);
	}


	// Adiciona o subpainel de uma calculadora a este painel.
	private void addCalculatorView(int index) {
		Calculator calculator = menu.getItemAt(index);
		calculatorView = new CalculatorView(calculator);
		add(calculatorView);
	}


	// Método exigido pela interface ActionListener, que representa a reação a uma
	// mudança no menu: remover o subpainel de calculadora que está atualmente neste
	// painel e adicionar o subpainel correspondente à calculadora selecionada no menu.
	@Override
	public void actionPerformed(ActionEvent event) {
		remove(calculatorView);
		int index = menu.getSelectedIndex();
		addCalculatorView(index);

		// Linha necessária para evitar um bug gráfico. Não se preocupe em entendê-la.
		((JFrame) SwingUtilities.getRoot(this)).pack();
	}
}
