package com.day9_1;

import java.io.File;
import java.io.IOException;

public class FileTest {
  public static void main(String[] args) throws IOException {
    String filepath = "src\\com\\day9_1\\fileTest.txt";
    File file = new File(filepath);
    // File file = null;
    file.createNewFile();
    System.out.println(file.isFile());
    System.out.println(file.isDirectory());
    System.out.println(file.getName());
    System.out.println(file.getAbsolutePath());
    System.out.println(file.canRead());
    System.out.println(file.canWrite());

    file.delete();
  }
}
