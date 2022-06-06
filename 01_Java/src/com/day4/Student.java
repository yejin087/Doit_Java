package com.day4;

public class Student {
  private String id;
  private int kor, eng, math;
  private int rank = 1;

  public Student(String id, int kor, int eng, int math) {
    this.id = id;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
  }

  public String getId() {
    return id;
  }

  public int getKor() {
    return kor;
  }

  public int getEng() {
    return eng;
  }

  public int getMath() {
    return math;
  }

  public int getRank() {
    return rank;
  }

  // ì´ì ë©”ì†Œ?“œ
  public int getTotal() {
    return kor + eng + math;
  }

  public double getAvg() {
    return getTotal() / 3;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setKor(int kor) {
    this.kor = kor;
  }

  public void setEng(int eng) {
    this.eng = eng;
  }

  public void setMath(int math) {
    this.math = math;
  }

  // ?„ì°? rank 1 ì¦ê?
  public void setRank() {
    this.rank++;
  }

}
