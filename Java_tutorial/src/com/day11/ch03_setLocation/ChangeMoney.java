package com.day11.ch03_setLocation;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ChangeMoney extends JFrame {

	private int[] unit = { 50000, 10000, 1000, 500, 100, 50, 10, 1 };
	private String[] text = { "오만원", " 만원", " 천원", "오백원", "백원", "오십원", "십원", "일원" };
	private JTextField[] tf = new JTextField[8];
	private JCheckBox[] cb = new JCheckBox[7];

	public ChangeMoney() {
		setTitle("change money");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.lightGray);

		JLabel la = new JLabel("금액");
		la.setSize(50, 20);
		la.setLocation(20, 20);
		add(la);

		JTextField won = new JTextField(30);
		won.setSize(100, 20);
		won.setLocation(80, 20);
		add(won);

		JButton btn = new JButton("계산");
		btn.setSize(70, 20);
		btn.setLocation(200, 20);
		add(btn);

		for (int i = 0; i < text.length; i++) {
			// text array
			la = new JLabel(text[i]);
			la.setSize(50, 20);
			la.setLocation(20, 50 + 20 * i);
			add(la);
			// jtextfield
			tf[i] = new JTextField();
			tf[i].setSize(100, 20);
			tf[i].setLocation(80, 50 + 20 * i);
			add(tf[i]);

			// check box
			if (i == text.length - 1)
				break;
			cb[i] = new JCheckBox();
			cb[i].setSize(30, 20);
			cb[i].setLocation(200, 50 + 20 * i);
			add(cb[i]);
		}

		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ChangeMoney();
	}

}
