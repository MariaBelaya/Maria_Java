package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testPointOne() {
    Point a = new Point(2, 2);
    Assert.assertEquals(a.Math(), 4.0);
  }

  @Test
  public void testPointTwo() {
    Point b = new Point(5, 5);
    Assert.assertEquals(b.Math(), 25.0);
  }
}