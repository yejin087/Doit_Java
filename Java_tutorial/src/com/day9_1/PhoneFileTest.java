package com.day9_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class PhoneFileTest {
  // BufferedReader br = new BufferedReader(new
  // FileReader("src\\com\\day9_1\\phone.txt"));
  private HashMap<String, String> hm = new HashMap<>();
  Scanner sc = null;
  File file = null;
  String filepath = "src\\com\\day9_1\\phone.txt";

  public void load() throws FileNotFoundException {
    file = new File(filepath);
    sc = new Scanner(file);

    while (sc.hasNext()) {
      String name = sc.next();
      String phoneNum = sc.next();
      hm.put(name, phoneNum);
    }

    System.out.println(hm.size() + " phone num exist");

  }

  public void search() {
    String search_name;
    String match_phonenum;
    sc = new Scanner(System.in);
    search_name = sc.next();

    if (hm.containsKey(search_name)) {
      match_phonenum = hm.get(search_name);
      System.out.println(search_name + "'s phone number : " + match_phonenum);
    } else {
      System.out.println("There is no name like " + search_name);
    }
  }

  public void save() throws IOException {
    hm.put("java", "010-3333-4444");
    hm.put("db", "010-2222-4444");
    FileWriter fw = new FileWriter(filepath);
    Set<String> hm_key_set = hm.keySet();
    Iterator<String> it = hm_key_set.iterator();

    while (it.hasNext()) {
      String key = it.next();
      String value = hm.get(key);
      fw.write(key + " ");
      fw.write(value + " ");

    }

    fw.close();
  }

  public static void main(String[] args) throws IOException {
    PhoneFileTest pt = new PhoneFileTest();
    pt.load();
    pt.search();
    pt.save();
  }
}
