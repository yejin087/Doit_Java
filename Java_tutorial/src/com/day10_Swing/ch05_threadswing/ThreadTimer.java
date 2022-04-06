package com.day10_Swing.ch05_threadswing;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThreadTimer extends JFrame {
	JLabel timerLabel;

	public ThreadTimer() {
		setTitle("timer");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		timerLabel = new JLabel("TIMER");
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 20));
		add(timerLabel);
		new InnerThreadTimer().start();

		setSize(300, 150);
		setVisible(true);
	}

	class InnerThreadTimer extends Thread {
		@Override
		public void run() {
			int n = 0;
			while (true) {
				timerLabel.setText(Integer.toString(n));
				n++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		new ThreadTimer();
	}
}
