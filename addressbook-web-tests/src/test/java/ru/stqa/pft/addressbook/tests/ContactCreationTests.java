package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

//  @DataProvider
//  public Iterator<Object[]> validContacts() throws IOException {
//    List<Object[]> list = new ArrayList<Object[]>();
//    BufferedReader reader = new BufferedReader(new FileReader((new File("src/test/resources/contacts.csv"))));
//    String line = reader.readLine();
//    while (line != null) {
//      String[] split = line.split(";");
//      list.add(new Object[]{new ContactData().withName(split[0]).withSurname(split[1])
//              .withAddress(split[2]).withHomePhone(split[3]).withEmail1(split[4])});
//      line = reader.readLine();
//    }
//    return list.iterator();
//  }
//
//  @Test (dataProvider = "validContacts")
//  public void testContactCreation(ContactData contact) throws Exception {
//    File photo = new File("src/test/resources/linux.png");
//    Contacts before = app.contact().all();
//    app.contact().goToAddNewContactPage();
//    app.contact().create(contact, true);
//
//    try {
//      Thread.sleep(3000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//
//    System.out.println(app.contact().count());
//    System.out.println(before.size() + 1);
//    assertThat(app.contact().count(), equalTo(before.size() + 1));
//    Contacts after = app.contact().all();
//    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
//  }


  @Test 
  public void testContactCreation() throws Exception {
      File photo = new File("src/test/resources/linux.png");
    ContactData contact = new ContactData().withSurname("Belaya").withName("Maria").withPhoto(photo).withAddress("Moscow")
            .withHomePhone("5467890").withMobilPhone("8948372839").withWorkPhone("687932424").withEmail1("test@test.ru")
            .withEmail2("test1@test.ru").withEmail3("test2@test.ru");
      app.goTo().homePage();
      Contacts before = app.contact().all();
      app.contact().goToAddNewContactPage();
      app.contact().create(contact, true);

      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      System.out.println(app.contact().count());
      System.out.println(before.size() + 1);
      assertThat(app.contact().count(), equalTo(before.size() + 1));
      Contacts after = app.contact().all();
      assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }


  @Test (enabled = false)
  public void testBadContactCreation() throws Exception {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    app.contact().goToAddNewContactPage();
    ContactData contact = new ContactData().withSurname("Belaya").withName("Maria'").withAddress("Moscow")
            .withHomePhone("5467890").withMobilPhone("8948372839").withWorkPhone("687932424").withEmail1("test@test.ru")
            .withEmail2("test1@test.ru").withEmail3("test2@test.ru");
    app.contact().create(contact, true);

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }
}

