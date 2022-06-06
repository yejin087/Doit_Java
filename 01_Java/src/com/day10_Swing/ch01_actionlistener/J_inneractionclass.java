package com.day10_Swing.ch01_actionlistener;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class J_inneractionclass extends JFrame {

	private JTextField tf;
	private JButton btn;
	private JTextArea ta;
	private JScrollPane jsp;

	public J_inneractionclass() {
		setTitle("multiple , inner class");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		tf = new JTextField(10);
		btn = new JButton("execute");
		ta = new JTextArea(10, 15);
		jsp = new JScrollPane(ta);

		add(tf);
		add(btn);
		add(jsp);

		ActionB ab = new ActionB();
		btn.addActionListener(ab);
		tf.addActionListener(ab);

		setSize(300, 300);
		setVisible(true);

	}

	class ActionB implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			int i = Integer.parseInt(tf.getText());
			ta.setText("");

			for (int j = 1; j <= 9; j++) {
				ta.append(i + "*" + j + " = " + i * j + "\n");
			}
		}

	}

	public static void main(String[] args) {
		new J_inneractionclass();
	}

}
