package com.day5.ch01_String;

import java.util.Scanner;

public class BookMG {
	Scanner sc = new Scanner(System.in);
	Book[] books = new Book[50];
	int cnt;

	public static void showMenu() {
		System.out.println("~ select ~");
		System.out.println("1.input data");
		System.out.println("2.show all");
		System.out.println("3.exit");
	}

	public void bookInsert() {
		System.out.println("input data");
		System.out.println("input title : ");
		String title = sc.nextLine();
		System.out.println("input author :");
		String author = sc.nextLine();
		books[cnt++] = new Book(title, author);

	}

	public void bookList() {

		for (Book book : books) {
			if (book != null) {
				System.out.println("book title : " + book.getTitle());
				System.out.println("book author : " + book.getAuthor());

			}
		}

	}
}
