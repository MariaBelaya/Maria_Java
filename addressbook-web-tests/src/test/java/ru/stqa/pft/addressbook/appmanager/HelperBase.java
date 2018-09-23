package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
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
    if (text != null) {
      String existingText = wd.findElement(Locator).getAttribute("value");
      if (! text.equals(existingText)) {
        wd.findElement(Locator).clear();
        wd.findElement(Locator).sendKeys(text);
      }
    }
  }

 public boolean isAlertPresent() {
  try{
    wd.switchTo().alert();
    return true;
  } catch (NoAlertPresentException e) {
    return false;
  }
  }
 }