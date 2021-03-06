package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestBase {

  Logger logger = LoggerFactory.getLogger(TestBase.class);
  protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

  @BeforeSuite
  public void setUp() throws IOException {
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    app.stop();
  }


  @BeforeMethod
  public void LogTestStart(Method m, Object[] p) {
    logger.info("Start test" + m.getName() + " with parameters" + Arrays.asList(p));
  }

  @AfterMethod(alwaysRun = true)
  public void LogTestStop(Method m) {
    logger.info("Stop test" + m.getName());
  }

  public void verifyGroupListInUi() {
    if (Boolean.getBoolean("verifyUi")) {
      Groups dbGroups = app.db().groups();
      Groups uiGroups = app.group().all();
      assertThat(uiGroups, equalTo(dbGroups.stream().map((g) -> new GroupData()
              .withId(g.getId()).withName(g.getName())).collect(Collectors.toSet())));
    }
  }

  public void verifyContactListInUi() {
    if (Boolean.getBoolean("verifyUi")) {
      Contacts dbContacts = app.db().contacts();
      Contacts uiContacts = app.contact().all();
      assertThat(uiContacts, equalTo(dbContacts.stream().map((c) -> new ContactData()
              .withId(c.getId()).withName(c.getName()).withSurname(c.getSurname())
              .withAddress(c.getAddress())).collect(Collectors.toSet())));
    }
  }
}