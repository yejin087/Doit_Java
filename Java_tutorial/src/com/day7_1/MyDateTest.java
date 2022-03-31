package com.day7_1;

class MyDate {
  int day;
  int month;
  int year;

  public MyDate(int day, int month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof MyDate) {
      MyDate md = (MyDate) obj;
      // this.day = (MyDate)obj.day; // errorR ???
      if (this.day == md.day & this.month == md.month & this.year == md.year)
        return true;

    }

    return false;
  }

  @Override
  public int hashCode() {

    return day * 10 + month * 101 + year * 102;
  }
}

public class MyDateTest {
  public static void main(String[] args) {
    MyDate m1 = new MyDate(9, 18, 2004);
    MyDate m2 = new MyDate(9, 18, 2004);

    if (m1.equals(m2))
      System.out.println("same");
    else
      System.out.println("diff");
  }
}
