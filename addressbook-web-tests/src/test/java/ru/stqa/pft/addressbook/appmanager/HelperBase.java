package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelperBase {
  protected FirefoxDriver wd;

  public HelperBase(FirefoxDriver wd) {
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
