package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);
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
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobilPhone());
    type(By.name("work"), contactData.getWorkPhone());
  }

  public void fillContactFormWithPhone(ContactData contactData) {
    type(By.name("firstname"), contactData.getName());
    type(By.name("lastname"), contactData.getSurname());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobilPhone());
    type(By.name("work"), contactData.getWorkPhone());
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
    contactCache = null;
    returnToHomePageModification();
  }


  public void modify(ContactData contact) {
    openEditContactPageById(contact.getId());
    fillContactFormWithPhone(contact);
    updateContactCreation();
    contactCache = null;
    returnToHomePageModification();
  }

  public void delete(ContactData contact) {
    openEditContactPageById(contact.getId());
    deleteContact();
    contactCache = null;
    returnToHomePageModification();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("//img[@alt='Edit']"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> List() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));

    for (WebElement element : elements) {
      List<WebElement> tr = element.findElements(By.tagName("td"));

      String name = tr.get(2).getText();
      String surname = tr.get(1).getText();
      String group = null;
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData()
              .withId(id).withName(name).withSurname(surname));
    }
    return contacts;
  }


  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }

    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));

    for (WebElement element : elements) {
      List<WebElement> tr = element.findElements(By.tagName("td"));

      String name = tr.get(2).getText();
      String surname = tr.get(1).getText();
      String allPhones = tr.get(5).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData()
              .withId(id).withName(name).withSurname(surname).withAllPhones(allPhones));
    }
    return new Contacts(contactCache);
  }

  public ContactData infoFromEditForm(ContactData contactData) {
    openEditContactPageById(contactData.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();
    return new ContactData()
            .withId(contactData.getId()).withName(firstname)
            .withSurname(lastname).withHomePhone(home)
            .withMobilPhone(mobile).withWorkPhone(work);
  }
  private void initContactModificationBiId(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement element = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> tr = element.findElements(By.tagName("td"));
    tr.get(7).findElement(By.tagName("a")).click();


    //    wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a", id))).click();
//    wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a", id))).click();
//    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }
}
