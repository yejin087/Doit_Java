package com.day6.ch04;

public class GenericMethod {

  public static <T, V> double makeRec(Point<T, V> p1, Point<T, V> p2) {
    double l = ((Number) p1.getX()).doubleValue();
    double r = ((Number) p2.getX()).doubleValue();
    double t = ((Number) p1.getY()).doubleValue();
    double b = ((Number) p2.getY()).doubleValue();

    double width = r - l;
    double height = b - t;

    return width * height;

  }

  public static void main(String[] args) {
    Point<Integer, Double> p1 = new Point<Integer, Double>(0, 0.0);
    Point<Integer, Double> p2 = new Point<>(10, 10.0);

    double rect = GenericMethod.makeRec(p1, p2);
    System.out.println("two point make rec in size >> " + rect);
  }
}