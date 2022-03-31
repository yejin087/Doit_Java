package com.day9_1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable {
  private String name;
  private String job;

  public Person(String name, String job) {
    this.name = name;
    this.job = job;

  }

  public String toString() {
    return name + " " + job;
  }

}

public class SerializeTest {
  public static void main(String[] args) throws IOException, ClassNotFoundException {

    Person personA = new Person("ahn", "ceo");
    Person personK = new Person("kim", "leader");
    String filepath = "src\\com\\day9_1\\serialize.txt";

    FileOutputStream fos = new FileOutputStream(filepath);
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(personA);
    oos.writeObject(personK);

    FileInputStream fis = new FileInputStream(filepath);
    ObjectInputStream ois = new ObjectInputStream(fis);
    Person p1 = (Person) ois.readObject();
    Person p2 = (Person) ois.readObject();
    System.out.println(p1);
    System.out.println(p2);
  }
}