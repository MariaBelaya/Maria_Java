package ru.stqa.pft.sandbox;

public class Point {

  double x;
  double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;

  }

  public double distance(Point to) {
    return Math.sqrt(Math.pow(to.getX() - this.getX(),2) + Math.pow(this.getY() - to.getY(),2));
  }

  public double getY() {
    return y;
  }

  public double getX() {
      return x;
  }

}