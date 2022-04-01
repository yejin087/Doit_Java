package com.day10_ioswing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextRW2 extends JFrame implements ActionListener {
	private JTextField tf;
	private JButton readBtn;
	private JButton writeBtn;
	private JTextArea ta;
	private JScrollPane jsp;

	public TextRW2() {
		setTitle("file read and write 2");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		tf = new JTextField(20);
		tf.setEditable(false);
		readBtn = new JButton("read");
		writeBtn = new JButton("write");
		ta = new JTextArea(20, 40);
		jsp = new JScrollPane(ta);

		add(tf);
		add(readBtn);
		add(writeBtn);
		add(jsp);

		readBtn.addActionListener(this);
		writeBtn.addActionListener(this);

		setSize(500, 500);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton btn = (JButton) e.getSource();

		if (btn == readBtn) {
			JFileChooser fc = new JFileChooser();
			// return 선택하면 0, 안하면 1
			// this는 file explore를 부른 곳, 지금 현재 클래스
//			int returnNum = fc.showOpenDialog(this);
//			if (returnNum == 1)
//				return;
			if (fc.showOpenDialog(this) == JFileChooser.CANCEL_OPTION)
				return;

			File f = fc.getSelectedFile();
			tf.setText(f.getName());

//			Scanner sc;
//			try {
//				sc = new Scanner(f);
//				while (sc.hasNext()) {
//					ta.append(sc.nextLine() + "\n");
//				}
//				sc.close();
//			
//			} catch (FileNotFoundException e1) {
//
//				e1.printStackTrace();
//			}

			BufferedReader br = null;
			FileReader fr;
			try {
				fr = new FileReader(f); // char로 읽어들인다.
				br = new BufferedReader(fr);
				String str;

				while ((str = br.readLine()) != null) {
					ta.append(str + "\n");
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		} else {
			JFileChooser fileChooser = new JFileChooser();
			if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				try {
					FileWriter fw = new FileWriter(file);
					fw.write(ta.getText());
					fw.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}

			ta.setText("");
		}
	}

	public static void main(String[] args) {
		new TextRW2();
	}

}
