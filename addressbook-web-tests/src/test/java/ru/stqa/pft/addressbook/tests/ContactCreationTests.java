package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() {
    app.goToAddNewContactPage();
    app.initContactCreation();
    app.fillContactForm(new ContactData("Maria", "Belaya", "Moscow", "89123456789", "test@test.ru"));
    app.submitContactCreation();
    app.goToLogout();

  }
}

