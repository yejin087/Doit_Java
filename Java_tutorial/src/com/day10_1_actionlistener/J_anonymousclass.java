package com.day10_1_actionlistener;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class J_anonymousclass extends JFrame {

	private JTextField tf;
	private JButton btn;
	private JTextArea ta;
	private JScrollPane jsp;

	public J_anonymousclass() {
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

		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i = Integer.parseInt(tf.getText());
				ta.setText("");

				for (int j = 1; j <= 9; j++) {
					ta.append(i + "*" + j + " = " + i * j + "\n");
				}
			}
		});

		tf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i = Integer.parseInt(tf.getText());
				ta.setText("");

				for (int j = 1; j <= 9; j++) {
					ta.append(i + "*" + j + " = " + i * j + "\n");
				}
			}
		});

		setSize(300, 300);
		setVisible(true);

	}

	public static void main(String[] args) {
		new J_anonymousclass();
	}

}
