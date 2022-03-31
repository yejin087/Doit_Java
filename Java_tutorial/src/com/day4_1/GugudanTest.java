package com.day4_1;

class Gugudan {

  private int dan;
  private int tot;

  public Gugudan(int dan) {
    this.dan = dan;
  }

  public void print() {
    for (int i = 1; i < 10; i++) {
      System.out.printf("%d * %d = %d\n", dan, i, dan * i);
      tot += dan * i;
    }

  }

  public int getTot() {
    return tot;
  }

}

public class GugudanTest {
  public static void main(String[] args) {
    Gugudan g1 = new Gugudan(3);
    g1.print();

    Gugudan g2 = new Gugudan(7);
    g2.print();

    Gugudan g3 = new Gugudan(9);
    g3.print();

    System.out.println("total gugudan  :" + (g1.getTot() + g2.getTot() + g3.getTot()));
  }
}