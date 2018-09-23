package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HelperBase {
  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  public void click(By Locator) {
    wd.findElement(Locator).click();
  }

  protected boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return  true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }

  public void type(By Locator, String text) {
    click(Locator);
    wd.findElement(Locator).clear();
    wd.findElement(Locator).sendKeys(text);
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}