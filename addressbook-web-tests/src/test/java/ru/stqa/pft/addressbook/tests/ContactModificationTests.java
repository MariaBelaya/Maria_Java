package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {


  @Test
  public void testContactModification() {
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().openEditContactPage();
    app.getContactHelper().deleteContact();
    app.getContactHelper().returnToHomePageModification();
  }
}
