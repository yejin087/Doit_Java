package com.day9.day9_5;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

// ActoinListener �����ϴ� Ŭ������ ���� ����
// ������Ʈ ( ��ư)�� �����ؾ��Ѵ�. 

public class PannelTest3 extends JFrame {

	public PannelTest3() {
		setTitle("inner class test");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		// ��ư ����
		JButton bnt1 = new JButton("button1");
		JButton bnt2 = new JButton("button2");
		JButton bnt3 = new JButton("button3");

		// JFrame�� ����
		add(bnt1);
		add(bnt2);
		add(bnt3);

		// component �� ActionListener�� �ٷ� ����.
		// �Ѱ��� ActionListener�� component ���� �����ؼ� �������� �ʾƵ� �ȴ�.
		// addActionListener( new _> ctrl,space�� �ϸ� �ڵ����� �����ȴ�.
		bnt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().setBackground(Color.GRAY);

			}
		});

		bnt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().setBackground(Color.PINK);

			}
		});

		bnt3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().setBackground(Color.magenta);

			}
		});

		// ������, ���̱� ����
		setSize(300, 400);
		setVisible(true);

	}

	public static void main(String[] args) {
		new PannelTest3();
	}

}
