package com.day10_Swing.ch04_ioswing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.day10_Swing.ch02_Gridlayout.*;

public class TextRW extends JFrame implements ActionListener {
  private JTextField tf;
  private JButton readBtn;
  private JButton writeBtn;
  private JTextArea ta;
  private JScrollPane jsp;

  public TextRW() {
    setTitle("file read and write");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new FlowLayout());

    tf = new JTextField(20);
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
    String str = e.getActionCommand();
    File file = new File(tf.getText());
    if (str.equals("read")) {
      Scanner sc;
      try {
        sc = new Scanner(file);
        while (sc.hasNext()) {
          ta.append(sc.nextLine() + "\n");
        }
      } catch (FileNotFoundException e1) {
        new MessageBox("File read error", "File doesn't exist");
      }

    } else {
      try {
        FileWriter fw = new FileWriter(file);
        fw.write(ta.getText());
        fw.close();
      } catch (IOException e2) {
        e2.printStackTrace();
      }

    }
  }

  public static void main(String[] args) {
    new TextRW();
  }

}
