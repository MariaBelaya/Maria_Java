package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {


  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().goToHomePage();
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().selectContact(before - 1);

    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().goToAddNewContactPage();
      app.getContactHelper().createContact(new ContactData("Maria", "Belaya", "Moscow", "89123456789", "test@test.ru", "[none]"));
    }
    app.getContactHelper().openEditContactPage();
    app.getContactHelper().deleteContact();
    app.getContactHelper().returnToHomePageModification();

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before - 1);
  }
}
