package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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

//  public void openEditContactPage(int index) {
//    wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
//  }

  public void deleteContact() {
    click(By.xpath("//form[2]/input[2]"));
  }

  public void goToAddNewContactPage() {
    click(By.linkText("add new"));
  }


  public void initContactCreation() {
    click(By.name("firstname"));
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

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getName());
    type(By.name("lastname"), contactData.getSurname());
    attach(By.name("photo"), contactData.getPhoto());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobilPhone());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("email2"), contactData.getEmail2());
    type(By.name("email3"), contactData.getEmail3());

    if (creation) {
      selectDropdown(By.name("new_group"), contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

  }


  public void create(ContactData contactData, boolean group) {
    initContactCreation();
    fillContactForm(contactData, group);
    submitContactCreation();
    returnToHomePageModification();
  }


  public void modify(ContactData contact) {
    openEditContactPageById(contact.getId());
    fillContactForm(contact, false);
    updateContactCreation();
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

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> List() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));

    for (WebElement element : elements) {
      List<WebElement> tr = element.findElements(By.tagName("td"));
      List<String> strings = new ArrayList<String>();
      for (WebElement e : tr) {
        strings.add(e.getText());
      }

      String name = tr.get(2).getText();
      String surname = tr.get(1).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData().withId(id).withName(name).withSurname(surname);
      contacts.add(contact);
    }
    return contacts;
  }


  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> tr = element.findElements(By.tagName("td"));
      List<String> strings = new ArrayList<String>();
      for (WebElement e : tr) {
        strings.add(e.getText());
      }

      String name = tr.get(2).getText();
      String surname = tr.get(1).getText();
      String address = tr.get(3).getText();
      String allEmails = tr.get(4).getText();
      String allPhones = tr.get(5).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData()
              .withId(id).withName(name).withSurname(surname).withAddress(address).withhAllEmails(allEmails).withAllPhones(allPhones));
    }
    return contacts;
  }

  public ContactData infoFromEditForm(ContactData contact) {
    openEditContactPageById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email1 = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withName(firstname)
            .withSurname(lastname).withAddress(address).withEmail1(email1)
            .withEmail2(email2).withEmail3(email3).withHomePhone(home)
            .withMobilPhone(mobile).withWorkPhone(work);
  }

//  private void initContactModificationBiId(int id) {
//    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
//    WebElement element = checkbox.findElement(By.xpath("./../.."));
//    List<WebElement> tr = element.findElements(By.tagName("td"));
//    tr.get(7).findElement(By.tagName("a")).click();
//

  //    wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a", id))).click();
//    wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a", id))).click();
//    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
}

