package com.day9.day9_5;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

// ActoinListener �����ϴ� Ŭ������ ���� ����
// ������Ʈ ( ��ư)�� �����ؾ��Ѵ�. 

public class PannelTest2 extends JFrame {

	public PannelTest2() {
		setTitle("annonymous class test");
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

		// ah : ActionPerformed�� ��ġ
		// ���� Ŭ���� ���
		ActionH ah = new ActionH();
		bnt1.addActionListener(ah);
		bnt2.addActionListener(ah);
		bnt3.addActionListener(ah);
		// ������, ���̱� ����
		setSize(300, 400);
		setVisible(true);

	}

	class ActionH implements ActionListener {

		// ActoinListener �����ϴ� Ŭ������ ���� ����
		// ������Ʈ ( ��ư)�� �����ؾ��Ѵ�. -> ���� Ŭ������ �����ϸ� ���ص� ��

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String str = e.getActionCommand();
			if (str.equals("button1")) {
				getContentPane().setBackground(Color.BLUE);
			} else if (str.equals("button2")) {
				getContentPane().setBackground(Color.red);
			} else if (str.equals("button3")) {
				getContentPane().setBackground(Color.green);
			}
		}

	}

	public static void main(String[] args) {
		new PannelTest2();
	}

}
