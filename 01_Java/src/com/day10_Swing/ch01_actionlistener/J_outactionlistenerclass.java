package com.day10_Swing.ch01_actionlistener;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class J_outactionlistenerclass extends JFrame {

	private JTextField tf;
	private JButton btn;
	private JTextArea ta;
	private JScrollPane jsp;

	public J_outactionlistenerclass() {
		setTitle("multiple , actionlistener class");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		tf = new JTextField(10);
		btn = new JButton("execute");
		ta = new JTextArea(10, 15);
		jsp = new JScrollPane(ta);

		add(tf);
		add(btn);
		add(jsp);

		Inner ic = new Inner(tf, ta);
		btn.addActionListener(ic);

		setSize(300, 300);
		setVisible(true);

	}

	public static void main(String[] args) {
		new J_outactionlistenerclass();
	}

}

class Inner implements ActionListener {

	private JTextField tf;
	private JTextArea ta;

	Inner(JTextField tf, JTextArea ta) {
		this.tf = tf;
		this.ta = ta;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int i = Integer.parseInt(tf.getText());
		ta.setText("");

		for (int j = 1; j <= 9; j++) {
			ta.append(i + "*" + j + " = " + i * j + "\n");
		}
	}
}
