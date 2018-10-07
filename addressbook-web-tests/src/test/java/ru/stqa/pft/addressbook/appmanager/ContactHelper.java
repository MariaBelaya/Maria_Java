package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void selectContact() {
    click(By.name("selected[]"));  }

  public void openEditContactPage(int index) {
    wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
  }
  public void openEditContactPageById(int id) {
    wd.findElement(By.xpath("//input[@value='" + id + "']/../../td/a/img[@title='Edit']")).click();
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

  public void returnToHomePageModification() {
    click(By.linkText("home"));

  }

  public void updateContactCreation() {
    click(By.name("update"));
  }


  public void create(ContactData contact) {
    initContactCreation();
    fillContactForm(contact);
    submitContactCreation();
    returnToHomePageModification();
  }


  public void modify(ContactData contact) {
    openEditContactPageById(contact.getId());
    fillContactForm(contact);
    updateContactCreation();
    returnToHomePageModification();
  }

  public void delete(int index) {
    openEditContactPage(index);
    deleteContact();
    returnToHomePageModification();
  }

  public void delete(ContactData contact) {
    openEditContactPageById(contact.getId());
    deleteContact();
    returnToHomePageModification();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("//img[@alt='Edit']"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> List() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));

    for (WebElement element : elements) {
      List<WebElement> tr = element.findElements(By.tagName("td"));

      String name = tr.get(2).getText();
      String surname = tr.get(1).getText();
      String address = tr.get(3).getText();
      String telephone = tr.get(5).getText();
      String email = tr.get(4).getText();
      String group = null;
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData()
              .withId(id).withName(name).withSurname(surname).withAddress(address)
              .withTelephone(telephone).withEmail(email).withGroup(group));
    }
    return contacts;
  }


  public Set<ContactData> all() {
    Set<ContactData> contacts = new HashSet<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));

    for (WebElement element : elements) {
      List<WebElement> tr = element.findElements(By.tagName("td"));

      String name = tr.get(2).getText();
      String surname = tr.get(1).getText();
      String address = tr.get(3).getText();
      String telephone = tr.get(5).getText();
      String email = tr.get(4).getText();
      String group = null;
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData()
              .withId(id).withName(name).withSurname(surname).withAddress(address)
              .withTelephone(telephone).withEmail(email).withGroup(group));
    }
    return contacts;
  }
}
