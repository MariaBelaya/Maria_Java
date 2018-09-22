package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().goToAddNewContactPage();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Maria", "Belaya", "Moscow", "89123456789", "test@test.ru"));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().goToHomePage();
  }
}

