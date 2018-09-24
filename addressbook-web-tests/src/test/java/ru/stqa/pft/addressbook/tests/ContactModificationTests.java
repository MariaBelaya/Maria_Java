package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {


  @Test
  public void testContactModification() {
    app.getNavigationHelper().goToHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().goToAddNewContactPage();
      app.getContactHelper().createContact(new ContactData("Maria", "Belaya", "Moscow", "89123456789", "test@test.ru", "[none]"));
    }
    app.getContactHelper().openEditContactPage();
    app.getContactHelper().deleteContact();
    app.getContactHelper().returnToHomePageModification();
  }
}
