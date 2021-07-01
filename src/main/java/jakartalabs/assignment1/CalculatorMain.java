package jakartalabs.assignment1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

class CalculatorMain extends JFrame implements ActionListener {
	// create untuk frame-nya
	static JFrame f;

	// create untuk bagian textfield
	static JTextField l;

	// store operator dan operands
	String s0, s1, s2;

	// default constructor
	CalculatorMain() {
		s0 = s1 = s2 = "";
	}

	// main function
	public static void main(String args[]) {
		// create a frame
		f = new JFrame("calculator - Achmad");

		try {
			// set untuk UI-nya
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		// create a object of class
		CalculatorMain c = new CalculatorMain();

		// create a textfield
		l = new JTextField(16);

		// set the textfield to non editable
		l.setEditable(false);

		// create number buttons and some operators
		JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, ba, bs, bd, bm, be, beq, beq1;

		// create number buttons
		btn0 = new JButton("0");
		btn1 = new JButton("1");
		btn2 = new JButton("2");
		btn3 = new JButton("3");
		btn4 = new JButton("4");
		btn5 = new JButton("5");
		btn6 = new JButton("6");
		btn7 = new JButton("7");
		btn8 = new JButton("8");
		btn9 = new JButton("9");

		// equals button
		beq1 = new JButton("=");

		// create operator buttons
		ba = new JButton("+");
		bs = new JButton("-");
		bd = new JButton("/");
		bm = new JButton("*");
		beq = new JButton("C");

		// create . button
		be = new JButton(".");

		// create a panel
		JPanel p = new JPanel();

		// add action listeners
		bm.addActionListener(c);
		bd.addActionListener(c);
		bs.addActionListener(c);
		ba.addActionListener(c);
		btn9.addActionListener(c);
		btn8.addActionListener(c);
		btn7.addActionListener(c);
		btn6.addActionListener(c);
		btn5.addActionListener(c);
		btn4.addActionListener(c);
		btn3.addActionListener(c);
		btn2.addActionListener(c);
		btn1.addActionListener(c);
		btn0.addActionListener(c);
		be.addActionListener(c);
		beq.addActionListener(c);
		beq1.addActionListener(c);

		// add elements to panel
		p.add(l);
		p.add(ba);
		p.add(btn1);
		p.add(btn2);
		p.add(btn3);
		p.add(bs);
		p.add(btn4);
		p.add(btn5);
		p.add(btn6);
		p.add(bm);
		p.add(btn7);
		p.add(btn8);
		p.add(btn9);
		p.add(bd);
		p.add(be);
		p.add(btn0);
		p.add(beq);
		p.add(beq1);

		// set Background pada panel
		p.setBackground(Color.blue);

		// add panel pada frame
		f.add(p);

		f.setSize(200, 220);
		f.show();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();

		// if the value is a number
		if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
			// if operand is present then add to second no
			if (!s1.equals(""))
				s2 = s2 + s;
			else
				s0 = s0 + s;

			// set the value of text
			l.setText(s0 + s1 + s2);
		} else if (s.charAt(0) == 'C') {
			// clear the one letter
			s0 = s1 = s2 = "";

			// set the value of text
			l.setText(s0 + s1 + s2);
		} else if (s.charAt(0) == '=') {

			double te;

			// store the value in 1st
			if (s1.equals("+"))
				te = (Double.parseDouble(s0) + Double.parseDouble(s2));
			else if (s1.equals("-"))
				te = (Double.parseDouble(s0) - Double.parseDouble(s2));
			else if (s1.equals("/"))
				te = (Double.parseDouble(s0) / Double.parseDouble(s2));
			else
				te = (Double.parseDouble(s0) * Double.parseDouble(s2));

			// set the value of text
			l.setText(s0 + s1 + s2 + "=" + te);

			// convert it to string
			s0 = Double.toString(te);

			s1 = s2 = "";
		} else {
			// if there was no operand
			if (s1.equals("") || s2.equals(""))
				s1 = s;
			// else evaluate
			else {
				double te;

				// store the value in 1st
				if (s1.equals("+"))
					te = (Double.parseDouble(s0) + Double.parseDouble(s2));
				else if (s1.equals("-"))
					te = (Double.parseDouble(s0) - Double.parseDouble(s2));
				else if (s1.equals("/"))
					te = (Double.parseDouble(s0) / Double.parseDouble(s2));
				else
					te = (Double.parseDouble(s0) * Double.parseDouble(s2));

				// convert it to string
				s0 = Double.toString(te);

				// place the operator
				s1 = s;

				// make the operand blank
				s2 = "";
			}

			// set the value of text
			l.setText(s0 + s1 + s2);
		}
	}
}
