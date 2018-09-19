package com.example.tests;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.tests.TestBase;

public class ContactDeletionTests extends TestBase {


  @Test
  public void testContactDeletion(By Locator) {
    app.findElement(Locator).click();
    app.findElement(By.xpath("//img[@alt='Edit']")).click();
    app.findElement(By.xpath("//form[2]/input[2]")).click();
  }
}
