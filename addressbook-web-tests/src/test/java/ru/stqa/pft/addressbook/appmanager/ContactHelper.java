package ru.stqa.pft.addressbook.appmanager;

import javafx.scene.shape.CircleBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void openEditContactPage() {
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

    boolean creation = true;
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
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

  public void returnToHomePageModification() {
    click(By.linkText("home"));

  }

  public void createContact(ContactData contact) {
    initContactCreation();
    fillContactForm(contact);
    submitContactCreation();
    returnToHomePageModification();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("//img[@alt='Edit']"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));

    for (WebElement element : elements) {
      String firstname = element.getText();
      ContactData contact = new ContactData(firstname,null,null,null,null,null);
      contacts.add(contact);
    }
    return contacts;
  }
}
