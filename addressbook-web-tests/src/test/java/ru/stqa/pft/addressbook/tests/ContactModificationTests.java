package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {


  @Test
  public void testContactModification() {
    app.getContactHelper().goToHomePage();
    app.getContactHelper().editContact();
    app.getContactHelper().deleteContact();
    app.getContactHelper().returnToHomePageModification();
  }
}
