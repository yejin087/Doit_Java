package com.day11;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FriendMain {
	private ArrayList<Friend> f_arr = new ArrayList<Friend>();
	File dir, file;

	public FriendMain() throws IOException, ClassNotFoundException {
		dir = new File("src\\com\\day11_Swing2");
		file = new File(dir, "friends.txt");

		// 파일 없다면 새로 생성
		if (!file.exists()) {
			file.createNewFile();
			return;
		}

		// 파일이 있을 경우
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		f_arr = (ArrayList<Friend>) ois.readObject();
		ois.close();
	}

	private void fileUse() throws IOException {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1.add friend 2.list friends 3.save/exit ");
			int choice = sc.nextInt();
			sc.nextLine();

			if (choice == 1) {
				System.out.println("name >> ");
				String name = sc.nextLine();
				System.out.println("birth >>");
				String birth = sc.nextLine();
				System.out.println("addr >> ");
				String addr = sc.nextLine();
				System.out.println("tel >> ");
				String tel = sc.nextLine();
				Friend f = new Friend();
				f.setName(name);
				f.setBirth(birth);
				f.setAddr(addr);
				f.setTel(tel);
				f_arr.add(f);
			} else if (choice == 2) {
				for (Friend friend : f_arr) {
					System.out.println(friend);
				}
			} else if (choice == 3) {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
				oos.writeObject(f_arr);
			}

		}
	}

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		FriendMain fm = new FriendMain();
		fm.fileUse();
	}

}
