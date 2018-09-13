package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testPointOne() {
    Point a = new Point(2, 2);
    Point b = new Point(3,3);
    Assert.assertEquals(a.distance(b), 1.4142135623730951);
  }

  @Test
  public void testPointTwo() {
    Point b = new Point(5, 5);
    Assert.assertEquals(b.distance(b), 0.0);
  }
}