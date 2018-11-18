package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.io.File;

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
      String existingTest = wd.findElement(Locator).getAttribute("value");
      if (!text.equals(existingTest)) {
        wd.findElement(Locator).clear();
        wd.findElement(Locator).sendKeys(text);
      }
    }
  }

  public void selectDropdown(By Locator, String text) {
    click(Locator);
    if (text != null) {
      String existingTest = wd.findElement(Locator).getAttribute("value");
      if (!text.equals(existingTest)) {
        wd.findElement(Locator).sendKeys(text);
      }
    }
  }

  public void attach(By Locator, File file) {
    if (file != null) {
      wd.findElement(Locator).sendKeys(file.getAbsolutePath());
    }
  }


  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  protected boolean isElementPresent(By Locator) {
    try {
      wd.findElement(Locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }
}


