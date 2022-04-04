package com.day11.ch02_Memo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Memo extends JFrame {

	JTextArea ta;
	String fileName;
	String filePath;

	public Memo(String Title) {

		setTitle(Title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar mb = new JMenuBar();

		JMenu mfile = new JMenu("File");
		JMenuItem mOpen = new JMenuItem("Open");
		JMenuItem mNew = new JMenuItem("new file");
		JMenuItem mSave = new JMenuItem("save file");
		JMenuItem mSaveAs = new JMenuItem("save as..");
		JMenuItem mExit = new JMenuItem("Exit");

		mfile.add(mOpen);
		mfile.add(mNew);
		mfile.add(mSave);
		mfile.add(mSaveAs);
		mfile.addSeparator();
		mfile.add(mExit);

		mb.add(mfile);
		setJMenuBar(mb); // JFrame에 JMenuBar 추가

		ta = new JTextArea();
		add(ta);
		JScrollPane jsp = new JScrollPane(ta);
		add(jsp);

		mOpen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JFileChooser fc = new JFileChooser();
				if (fc.showOpenDialog(Memo.this) == JFileChooser.CANCEL_OPTION)
					return;

				File f = fc.getSelectedFile();
				fileName = f.getName();
				filePath = f.getPath();
				setTitle(fileName);
				fileRead(filePath);
			}
		});

		mNew.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText("");
				setTitle("제목 없음");
			}
		});

		mSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (getTitle().equals("제목 없음")) {
//					JFileChooser fileChooser = new JFileChooser();
//					if (fileChooser.showSaveDialog(Memo.this) == JFileChooser.APPROVE_OPTION) {
//						File file = fileChooser.getSelectedFile();
//						filePath = file.getPath();
//						setTitle(file.getName());
//						fileSave(filePath);
					mSaveAs.doClick();
				} else {
					fileSave(filePath);
				}
			}

		});

		mSaveAs.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				if (fileChooser.showSaveDialog(Memo.this) == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					filePath = file.getPath();
					setTitle(file.getName());
					fileSave(filePath);
				}
			}
		});

		mExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		setSize(500, 400);
		setVisible(true);
	}

	private void fileRead(String filepath) {
		try {
			FileReader fr = new FileReader(filepath);
			StringWriter sw = new StringWriter();
			int ch;
			while ((ch = fr.read()) != -1) {
				sw.write(ch);
			}

			ta.setText(sw.toString());
			sw.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void fileSave(String savefilePath) {
		try {
			PrintStream ps = new PrintStream(savefilePath);
			ps.println(ta.getText());
			ps.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new Memo("제목 없음");
	}
}
