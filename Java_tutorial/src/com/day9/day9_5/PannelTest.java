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
		// 닫을 때 메모리 상에서도 제거
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 상-하 -> 왼 -오 순서로 생성
		setLayout(new FlowLayout());

		JButton bnt1 = new JButton("button1");
		JButton bnt2 = new JButton("button2");
		JButton bnt3 = new JButton("button3");

		// JFrame에 부착
		add(bnt1);
		add(bnt2);
		add(bnt3);

		// this : ActionPerformed의 위치
		bnt1.addActionListener(this);
		bnt2.addActionListener(this);
		bnt3.addActionListener(this);

		setSize(300, 400);
		setVisible(true);
	}

	@Override
	// 버튼을 누르면 실핸된다.
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand(); // action을 발생시킨 것의 이름
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
