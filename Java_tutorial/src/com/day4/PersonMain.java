package com.day4;

public class PersonMain {

  Person arr[] = new Person[10];
  static int cnt;

  public void insertPerson(String name, int age, String dept) {
    arr[cnt] = new Person(name, age, dept);
    cnt++;
  }

  public void print() {
    int sum = 0;

    // for (int i = 0; i < cnt; i++) {
    // System.out.print(arr[i].getName());
    // System.out.println(arr[i].getAge());
    // sum += arr[i].getAge();
    // }

    for (Person person : arr) {
      if (person == null)
        break;
      System.out.println(person.getName());
      System.out.println(person.getAge());
    }

    System.out.println("age total : " + (sum));
    System.out.println("age avg : " + (sum) / cnt);
  }
}