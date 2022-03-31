package com.day7_1;

import java.util.ArrayList;

import com.day2.Arrya;

class Aniaml {
  public void move() {
    System.out.println("aimal move");
  }

}

class Human extends Aniaml {
  @Override
  public void move() {
    System.out.println("human walks");
  }

  public void readbook() {
    System.out.println("human reads");
  }

}

class Tiger extends Aniaml {
  public void move() {
    System.out.println("tiger runs");

  }

  public void hunting() {
    System.out.println("tiger hunts");

  }
}

class Eagle extends Aniaml {
  public void move() {
    System.out.println("ealge flies");
  }

  public void flying() {
    System.out.println("elage files");
  }
}

public class AnimalCastingTest {

  ArrayList<Aniaml> arr = new ArrayList<>();

  public void add() {
    arr.add(new Human());
    arr.add(new Tiger());
    arr.add(new Eagle());

    for (Aniaml animal : arr) {
      animal.move();
    }
  }

  public void testCating() {
    for (int i = 0; i < arr.size(); i++) {
      Aniaml ano = arr.get(i);

      if (ano instanceof Human) {
        ((Human) ano).readbook();
      } else if (ano instanceof Tiger) {
        ((Tiger) ano).hunting();
      } else if (ano instanceof Eagle) {
        ((Eagle) ano).flying();
      } else {
        System.out.println("not supported class type");
      }

    }
  }

  public static void main(String[] args) {

  }
}