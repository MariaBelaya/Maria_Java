package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBase {
  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  public void click(By Locator) {
    wd.findElement(Locator).click();
  }

  public void type(By Locator, String text) {
    click(Locator);
    wd.findElement(Locator).clear();
    wd.findElement(Locator).sendKeys(text);
  }
}
