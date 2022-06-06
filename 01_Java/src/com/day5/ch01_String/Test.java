package com.day5.ch01_String;

public class Test {
	public static void main(StringTest[] args) {
		BookMG bm = new BookMG();
//		Scanner sc = new Scanner(System.in);
		while (true) {
			BookMG.showMenu();
			int menu = bm.sc.nextInt();
			// enter ����.
			bm.sc.nextLine();

			switch (menu) {
			case 1:
				bm.bookInsert();
				break;
			case 2:
				bm.bookList();
				break;
			case 3:
				System.out.println("exit");
				System.exit(0);
			default:
				System.out.println("input error");

			}

			System.out.println("=============");

		}
	}
}
