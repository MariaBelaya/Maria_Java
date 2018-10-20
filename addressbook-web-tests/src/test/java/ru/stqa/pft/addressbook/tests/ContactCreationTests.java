package ru.stqa.pft.addressbook.tests;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {


  @DataProvider
  public Iterator<Object[]> validContactsFromXml() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    try (BufferedReader reader = new BufferedReader(new FileReader((new File("src/test/resources/contacts.xml"))))) {
      String xml = "";
      String line = reader.readLine();
      while (line != null) {
        xml += line;
        line = reader.readLine();
      }
      XStream xstream = new XStream();
      xstream.processAnnotations(ContactData.class);
      List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
      return contacts.stream().map((contactData) -> new Object[]{contactData}).collect(Collectors.toList()).iterator();
    }
  }

  @DataProvider
  public Iterator<Object[]> validContactsFromJson() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    try (BufferedReader reader = new BufferedReader(new FileReader((new File("src/test/resources/contacts.json"))))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }

      Gson gson = new Gson();
      List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {
      }.getType());
      return contacts.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();
    }
  }

  @Test(dataProvider = "validContactsFromJson")
  public void testContactCreationJson(ContactData contact) throws Exception {
    Contacts before = app.contact().all();
    app.contact().goToAddNewContactPage();
    app.contact().create(contact, true);

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println(app.contact().count());
    System.out.println(before.size() + 1);
    Contacts after = app.contact().all();
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    assertThat(after, equalTo
            (before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

  }

  @Test
  public void testContactCreation() {
    File photo = new File("src/test/resources/linux.png");
    ContactData contact = new ContactData().withSurname("belaya").withName("maria").withPhoto(photo).withAddress("moscow")
            .withHomePhone("5467890").withMobilPhone("8948372839").withWorkPhone("687932424").withEmail1("test@test.ru")
            .withEmail2("test1@test.ru").withEmail3("test2@test.ru").withGroup("test 0");
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
    Contacts after = app.contact().all();
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    assertThat(after, equalTo
            (before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }


  @Test(enabled = false)
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

    Contacts after = app.contact().all();
    assertThat(app.contact().count(), equalTo(before.size()));
    assertThat(after, equalTo(before));
  }

}

