package com.day9.day9_5;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

// ActoinListener 구현하는 클래스를 따로 생성
// 컴포넘트 ( 버튼)와 연결해야한다. 

public class PannelTest2 extends JFrame {

	public PannelTest2() {
		setTitle("annonymous class test");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		// 버튼 생성
		JButton bnt1 = new JButton("button1");
		JButton bnt2 = new JButton("button2");
		JButton bnt3 = new JButton("button3");

		// JFrame에 부착
		add(bnt1);
		add(bnt2);
		add(bnt3);

		// ah : ActionPerformed의 위치
		// 내부 클래스 사용
		ActionH ah = new ActionH();
		bnt1.addActionListener(ah);
		bnt2.addActionListener(ah);
		bnt3.addActionListener(ah);
		// 사이즈, 보이기 설정
		setSize(300, 400);
		setVisible(true);

	}

	class ActionH implements ActionListener {

		// ActoinListener 구현하는 클래스를 따로 생성
		// 컴포넘트 ( 버튼)와 연결해야한다. -> 내부 클래스로 생성하면 안해도 됨

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
