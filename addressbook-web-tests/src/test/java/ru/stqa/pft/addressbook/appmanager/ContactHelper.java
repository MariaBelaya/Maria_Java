package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {


  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void selectContact() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void deleteContact() {
    click(By.xpath("//form[2]/input[2]"));
  }

  public void goToAddNewContactPage() {
    click(By.linkText("add new"));
  }


  public void initContactCreation() {
    click(By.name("firstname"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getName());
    type(By.name("lastname"), contactData.getSurname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getTelephone());
    type(By.name("email"), contactData.getEmail());
  }

  public void type(By Locator, String text) {
    wd.findElement(Locator).click();
    wd.findElement(Locator).clear();
    wd.findElement(Locator).sendKeys(text);
  }

  public void submitContactCreation() {
    click(By.xpath("//input[21]"));
  }


  public void click(By Locator) {
    wd.findElement(Locator).click();
  }

  public void goToHomePage() {
    click(By.linkText("home"));
  }
}