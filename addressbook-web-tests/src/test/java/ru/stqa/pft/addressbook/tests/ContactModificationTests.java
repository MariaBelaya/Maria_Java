package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();

    if (app.contact().List().size() == 0) {
      app.contact().goToAddNewContactPage();
      app.contact().create(new ContactData(), true);
    }
  }

  @Test
  public void testContactModification() {

    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withSurname("Belaya").withName("Maria")
            .withAddress("From Moscow")
            .withHomePhone("5467890").withMobilPhone("8948372839").withWorkPhone("687932424").withEmail1("test@test.ru")
            .withEmail2("test1@test.ru").withEmail3("test2@test.ru");
    app.contact().modify(contact);

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }
}
