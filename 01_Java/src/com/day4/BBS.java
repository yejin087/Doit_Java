package com.day4;

public class BBS {
  private String name, data, title, content;
  private static int num;

  public BBS(String name, String data, String title, String content) {
    this.name = name;
    this.data = data;
    this.title = title;
    this.content = content;
  }

  public void print() {
    System.out.println("no." + ++BBS.num);
    System.out.println("name  :" + name);
    System.out.println("data  : " + data);
    System.out.println("title : " + title);
    System.out.println("content : " + content);
    System.out.println();
  }

}