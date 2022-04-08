package com.day10_Swing.ch02_Gridlayout;

import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Bank extends JFrame {
	private HashMap<String, Integer> account_hm = new HashMap<String, Integer>();
	private List lst;

	public Bank() {
		setTitle("Bank");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(1, 2));

		JPanel p1 = new JPanel();
		p1.add(new JLabel("name"));
		JTextField tfName = new JTextField(15);
		p1.add(tfName);

		JButton btn = new JButton("create account");

		JPanel p2 = new JPanel();
		p2.add(new JLabel("balance"));
		JTextField tfBalance = new JTextField(15);
		tfBalance.setEditable(false); // ���� False
		p2.add(tfBalance);

		JPanel p3 = new JPanel();
		p3.add(new JLabel("won"));
		JTextField tfMoney = new JTextField(15);
		p3.add(tfMoney);

		JPanel p4 = new JPanel();
		JButton inputBtn = new JButton("input");
		JButton outBtn = new JButton("output");
		JButton fileBtn = new JButton("save file");
		p4.add(inputBtn);
		p4.add(outBtn);
		p4.add(fileBtn);

		// 4�� Panel�� ���� Panel ���� ( ���� )
		JPanel container_left = new JPanel();
		container_left.add(p1);
		container_left.add(btn);
		container_left.add(p2);
		container_left.add(p3);
		container_left.add(p4);

		lst = new List();

		add(container_left);
		add(lst);

		// ActionListener
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String name = tfName.getText().trim();
				if (!name.isEmpty()) {
					lst.add(name);
					account_hm.put(name, 0);
				}

				tfName.setText("");
			}

		});

		inputBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					// ����Ʈ�� ������ �̸� ����
					String name = lst.getSelectedItem().trim();
					// ���� �̸� �ܾ׾� �Ա��� �ݾ��� ���Ѵ�.
					int input_Money = Integer.parseInt(tfMoney.getText());
					int balance = account_hm.get(name);
					balance += input_Money;
					// �ܾ� ����
					tfBalance.setText(Integer.toString(balance));
					// ���� �� ����
					account_hm.put(name, balance);
					// �ݾ� ĭ ����
					tfMoney.setText("");
					tfName.setText("");

				} catch (NumberFormatException nf) {
					new MessageBox("input error", "input number");
				} catch (NullPointerException ne) {
					new MessageBox("account error", "select account");
				}

			}
		});

		outBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					// ����Ʈ�� ������ �̸� ����
					String name = lst.getSelectedItem().trim();
					// ���� �̸� �ܾ��� ��� �ݾ�
					int output_Money = Integer.parseInt(tfMoney.getText());
					// ���� �̸� �ܾ�
					int balance = account_hm.get(name);

					if (output_Money <= balance)
						balance -= output_Money;
					else
//					System.out.println("lack of balance");
//					new MessageBox();
						new MessageBox("lack of balance", name + ", Insufficient balance.");
					// �ܾ� ����
					tfBalance.setText(Integer.toString(balance));
					// ���� �� ����
					account_hm.put(name, balance);
					// �ݾ� ĭ ����
					tfMoney.setText("");
					tfName.setText("");

				} catch (NumberFormatException nf) {
					new MessageBox("output error", "input number");
				} catch (NullPointerException ne) {
					new MessageBox("account error", "select account");
				}
			}
		});

		fileBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				File dir = new File("src\\com\\day10_2_Gridlayout");
				File file = new File(dir, "Bank.txt");

				try {
					FileWriter fw = new FileWriter(file);
					Iterator<String> it = account_hm.keySet().iterator();
					while (it.hasNext()) {
						String name = it.next();
						Integer balance = account_hm.get(name);
						fw.write(name + " ");
						fw.write(balance + "\n");
					}

					fw.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		});

		// list Ŭ�� �̺�Ʈ
		lst.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// input name, balance
				String selected_list = lst.getSelectedItem();
				tfName.setText(selected_list);
				tfBalance.setText(Integer.toString(account_hm.get(selected_list)));
			}
		});

		setSize(500, 400);
		setVisible(true);
		load(); // file read and insert to map

	}

	private void load() {
		File dir = new File("src\\com\\day10_2_Gridlayout");
		File file = new File(dir, "Bank.txt");
		try {
			if (!file.exists()) {
				file.createNewFile();
				return;
			}
			Scanner sc = new Scanner(file);
			while (sc.hasNext()) {
				String name = sc.next();
				int balance = sc.nextInt();
				account_hm.put(name, balance);
				lst.add(name);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Bank();
	}
}
