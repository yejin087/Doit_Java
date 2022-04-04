package com.day9.day9_5;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PannelTest extends JFrame implements ActionListener {

	public PannelTest() {
		setTitle("swing test");
		// ���� �� �޸� �󿡼��� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ��-�� -> �� -�� ������ ����
		setLayout(new FlowLayout());

		JButton bnt1 = new JButton("button1");
		JButton bnt2 = new JButton("button2");
		JButton bnt3 = new JButton("button3");

		// JFrame�� ����
		add(bnt1);
		add(bnt2);
		add(bnt3);

		// this : ActionPerformed�� ��ġ
		bnt1.addActionListener(this);
		bnt2.addActionListener(this);
		bnt3.addActionListener(this);

		setSize(300, 400);
		setVisible(true);
	}

	@Override
	// ��ư�� ������ ���ڵȴ�.
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand(); // action�� �߻���Ų ���� �̸�
		if (str.equals("button1")) {
//			System.out.println("button1 cliked");
			getContentPane().setBackground(Color.BLUE);
		} else if (str.equals("button2")) {
//			System.out.println("butto2 cliked");
			getContentPane().setBackground(Color.red);
		} else if (str.equals("button3")) {
//			System.out.println("button3 cliked");
			getContentPane().setBackground(Color.green);
		}
		System.out.println(str + "cliked");
//		System.out.println("event accur");
	}

	public static void main(String[] args) {
		new PannelTest();
	}

}
