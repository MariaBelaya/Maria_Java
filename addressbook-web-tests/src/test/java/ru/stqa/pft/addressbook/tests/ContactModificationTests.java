package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void esurePreconditions() {
    app.goTo().homePage();

    if (app.contact().List().size() == 0) {
      app.contact().goToAddNewContactPage();
      app.contact().create(new ContactData().withName("Maria"));
    }
  }

  @Test
  public void testContactModification() {

    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withSurname("Belaya").withName("Maria")
            .withAddress("Moscow").withTelephone("8948372839").withEmail("test@test.ru").withGroup(null);
    app.contact().modify(contact);


    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }


    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());


    before.remove (modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}
