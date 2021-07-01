package jakartalabs.assignment1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CalculatorUI implements ActionListener {
	JFrame frame = new JFrame("Calcalutor");
	JPanel panel = new JPanel(new FlowLayout());
	JTextArea text = new JTextArea(2, 17);

	// button number
	JButton button1 = new JButton("1");
	JButton button2 = new JButton("2");
	JButton button3 = new JButton("3");
	JButton button4 = new JButton("4");
	JButton button5 = new JButton("5");
	JButton button6 = new JButton("6");
	JButton button7 = new JButton("7");
	JButton button8 = new JButton("8");
	JButton button9 = new JButton("9");
	JButton button0 = new JButton("0");

	// button operations
	JButton buttonAdd = new JButton("+");
	JButton buttonSub = new JButton("-");
	JButton buttonMultiply = new JButton("*");
	JButton buttonDivide = new JButton("/");
	JButton buttonEqual = new JButton("=");
	JButton buttonClear = new JButton("C");

	Double number1, number2, result;
	int addc = 0, subc = 0, multic = 0, divc = 0;

	public void UI() {
		frame.setVisible(true);
		frame.setBounds(300, 300, 220, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(panel);

		panel.add(text);

		panel.add(button7);
		panel.add(button8);
		panel.add(button9);
		panel.add(buttonMultiply);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		panel.add(buttonSub);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(buttonAdd);
		panel.add(buttonClear);
		panel.add(button0);
		panel.add(buttonEqual);
		panel.add(buttonDivide);

		// action button
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		button8.addActionListener(this);
		button9.addActionListener(this);
		button0.addActionListener(this);
		buttonAdd.addActionListener(this);
		buttonSub.addActionListener(this);
		buttonMultiply.addActionListener(this);
		buttonDivide.addActionListener(this);
		buttonEqual.addActionListener(this);
		buttonClear.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == buttonClear) {
			number1 = 0.0;
			number2 = 0.0;
			text.setText("");
		}

		if (source == button1) {
			text.append("1");
		}
		if (source == button2) {
			text.append("2");
		}
		if (source == button3) {
			text.append("3");
		}
		if (source == button4) {
			text.append("4");
		}
		if (source == button5) {
			text.append("5");
		}
		if (source == button6) {
			text.append("6");
		}
		if (source == button7) {
			text.append("7");
		}
		if (source == button8) {
			text.append("8");
		}
		if (source == button9) {
			text.append("9");
		}
		if (source == button0) {
			text.append("0");
		}
		if (source == buttonAdd) {
			number1 = numberReader();
			text.setText("");
			addc = 1;
			subc = 0;
			multic = 0;
			divc = 0;
		}
		if (source == buttonSub) {
			number1 = numberReader();
			text.setText("");
			addc = 0;
			subc = 1;
			multic = 0;
			divc = 0;
		}
		if (source == buttonMultiply) {
			number1 = numberReader();
			text.setText("");
			addc = 0;
			subc = 0;
			multic = 1;
			divc = 0;
		}
		if (source == buttonDivide) {
			number1 = numberReader();
			text.setText("");
			addc = 0;
			subc = 0;
			multic = 0;
			divc = 1;
		}
		if (source == buttonEqual) {
			number2 = numberReader();
			if (addc > 0) {
				result = number1 + number2;
				text.setText(Double.toString(result));
			}
			if (subc > 0) {
				result = number1 - number2;
				text.setText(Double.toString(result));
			}
			if (multic > 0) {
				result = number1 * number2;
				text.setText(Double.toString(result));
			}
			if (divc > 0) {
				result = number1 / number2;
				text.setText(Double.toString(result));
			}
		}

	}

	public double numberReader() {
		Double number1;
		String s;
		s = text.getText();
		number1 = Double.valueOf(s);

		return number1;
	}

}
