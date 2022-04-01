package com.day10_1_actionlistener;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class J_actionlistener extends JFrame implements ActionListener {

	private JTextField tf;
	private JButton btn;
	private JTextArea ta;

	public J_actionlistener() {
		setTitle("multiple");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		tf = new JTextField(10);
		btn = new JButton("execute");
		ta = new JTextArea(10, 15);
		JScrollPane jsp = new JScrollPane(ta);

		add(tf);
		add(btn);
		add(jsp);

		btn.addActionListener(this);
		tf.addActionListener(this);

		ta.setText(tf.getText());
		setSize(300, 300);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int i = Integer.parseInt(tf.getText());
		ta.setText("");

//		String table = "";
//		for (int j = 1; j <= 9; j++) {
//			table += i + "*" + j + " = " + i * j + "\n";
//		}
//		ta.setText(table);

		for (int j = 0; j <= 9; j++) {
			ta.append(i + "*" + j + " = " + i * j + "\n");
		}
	}

	public static void main(String[] args) {
		new J_actionlistener();
	}

}
