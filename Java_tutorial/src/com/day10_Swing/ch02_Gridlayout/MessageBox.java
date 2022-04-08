package com.day10_Swing.ch02_Gridlayout;

import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MessageBox extends JFrame {
	public MessageBox(String title, String msg) {
		setTitle(title);
		setLayout(new FlowLayout());

		JButton close_btn = new JButton("close");

		add(new Label(msg));
		add(close_btn);

		close_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				 ���� â�� �ݴ´�.
				dispose();

			}
		});
		setSize(300, 100);
		setVisible(true);
	}

}
