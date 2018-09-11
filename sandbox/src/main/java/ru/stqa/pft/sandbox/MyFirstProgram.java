package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Maria");


//    Square s = new Square(5);
//    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());
//
//    Rectangle r = new Rectangle(4, 6);
//    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

    Point a = new Point(5, 10);
    Point b = new Point(4, 11);

    System.out.println("Расстояние между двумя точками = " + a.distance(b));

    System.out.println("Расстояние между двумя точками = " + distance(a, b));

  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!!!");
  }

  public static double distance(Point p1, Point p2) {
    return Math.sqrt(Math.pow(p2.getX() - p1.getX(),2) + Math.pow(p1.getY() - p2.getY(),2));
  }
}
