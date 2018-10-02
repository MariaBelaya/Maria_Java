package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {


  @Test
  public void testContactModification() {
    app.getNavigationHelper().goToHomePage();

    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().goToAddNewContactPage();
      app.getContactHelper().createContact(new ContactData("Maria", "Belaya", "Moscow", "89123456789", "test@test.ru", null));
    }
    List<ContactData> before = app.getContactHelper().getContactList();

    app.getContactHelper().selectContact(before.size() - 1);
    ContactData contact = new ContactData("Maria", "Belaya", "Moscow", "89123456789", "test@test.ru", null);
    app.getContactHelper().openEditContactPage();
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().returnToHomePageModification();


    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }


    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());


    before.remove (before.size() - 1);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
