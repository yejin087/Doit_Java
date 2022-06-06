package com.day9.day9_5;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

// ActoinListener 구현하는 클래스를 따로 생성
// 컴포넘트 ( 버튼)와 연결해야한다. 

public class PannelTest3 extends JFrame {

	public PannelTest3() {
		setTitle("inner class test");
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

		// component 와 ActionListener를 바로 연결.
		// 한개의 ActionListener에 component 별로 구분해서 구현하지 않아도 된다.
		// addActionListener( new _> ctrl,space를 하면 자동으로 생성된다.
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

		// 사이즈, 보이기 설정
		setSize(300, 400);
		setVisible(true);

	}

	public static void main(String[] args) {
		new PannelTest3();
	}

}
