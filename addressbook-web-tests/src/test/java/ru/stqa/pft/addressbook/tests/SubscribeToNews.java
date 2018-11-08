package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.News;

import static org.openqa.selenium.By.cssSelector;

public class SubscribeToNews {
  FirefoxDriver wd;


  @BeforeMethod
  public void TestSubscribeNews()  {
    wd = new FirefoxDriver();
    wd.get("https://www.tsum.ru");
  }


  @Test
  public void SubscribeNewsTest()  {
    clickOnCloseButton();
    goToBusketPage();
    fillSubscribeForm(new News("cfgbdhj@yvgbh.df"));

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    submitSubscribeButton();
  }

  public void clickOnCloseButton() {
    wd.findElement(By.className("geo-popup__close-button")).click();
  }

  public void goToBusketPage() {
    wd.findElement(cssSelector(".header__top .header__basket .header__link_basket")).click();
  }

  public void fillSubscribeForm(News news) {
    type((By.cssSelector(".subscribe__input input")), news.getEmail());
  }

  public void submitSubscribeButton() {
    wd.findElement(By.cssSelector(".subscribe__button button ")).click();
  }

  public void type(By Locator, String text) {
    wd.findElement(Locator).sendKeys(text);
  }
}
