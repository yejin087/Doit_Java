package com.day4_1;

import java.util.Scanner;

public class Test {
  public static void main(String[] args) {

    // Drink d1 = new Drink("coffee", 3000, 3);
    // Drink d2 = new Drink("tea", 3500, 5);
    // Drink d3 = new Drink("latte", 5000, 7);

    // d1.printDrink();
    // d2.printDrink();
    // d3.printDrink();

    // Drink[] arr = new Drink[50];
    // arr[0] = new Drink("coffee", 3000, 3);
    // arr[1] = new Drink("tea", 3500, 5);
    // arr[2] = new Drink("latte", 5000, 7);
    // int sum = 0;

    // for (int i = 0; i < arr.length; i++) {
    // if (arr[i] == null)
    // break;
    // arr[i].printDrink();
    // sum += arr[i].getTotal();
    // }

    // System.out.println(sum);

    // PersonMain pm = new PersonMain();
    // pm.insertPerson("hong", 30, "market");
    // pm.insertPerson("lee", 25, "hr");
    // pm.insertPerson("gang", 30, "develope");
    // pm.print();

    // TwoDemScore teacher = new TwoDemScore();
    // Scanner sc = new Scanner(System.in);

    // while (true) {

    // teacher.showMenu();
    // int menu = sc.nextInt();

    // switch (menu) {
    // case 1:
    // teacher.inputData();
    // break;
    // case 2:
    // teacher.viewData();
    // System.exit(0);
    // break;
    // default:
    // System.out.println("input error");
    // }

    // }

    // Teacher teacher = new Teacher();
    // Scanner sc = new Scanner(System.in);

    // while (true) {

    // teacher.showMenu();
    // int menu = sc.nextInt();

    // switch (menu) {
    // case 1:
    // teacher.inputData();
    // break;
    // case 2:
    // teacher.rankmethod();
    // teacher.viewData();
    // System.exit(0);
    // break;
    // default:
    // System.out.println("input error");
    // }
    // }

    // BBS b1 = new BBS("hong", "2021", "title1", "content1");
    // BBS b2 = new BBS("lee", "2022", "title2", "content2");

    // b1.print();
    // b2.print();

    Book2[] library = new Book2[5];

    library[0] = new Book2("태백산맥", "조정래");
    library[1] = new Book2("태백산맥1", "조정래1");
    library[2] = new Book2("태백산맥2", "조정래2");
    library[3] = new Book2("태백산맥3", "조정래3");
    library[4] = new Book2("태백산맥4", "조정래4");

    for (int i = 0; i < library.length; i++) {
      System.out.println(library[i]);
    }
    for (int i = 0; i < library.length; i++) {
      library[i].showBookInfo();
    }

  }

}
