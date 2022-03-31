package com.day4_1;

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

  // 총점메소드
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

  // 석차 rank 1 증가
  public void setRank() {
    this.rank++;
  }

}
