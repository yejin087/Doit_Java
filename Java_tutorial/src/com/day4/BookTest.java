package com.day4;

public class BookTest {
  public static void main(String[] args) {
    Book b1 = new Book("little prince", "ST");
    Book b2 = new Book("Chun");

    System.out.println("book title : " + b1.getTitle());
    System.out.println("author : " + b1.getAuthor());

    System.out.println("book title : " + b2.getTitle());
    System.out.println("author : " + b2.getAuthor());

  }
}
