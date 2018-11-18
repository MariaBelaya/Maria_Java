package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;


  public class NavigationHelper extends HelperBase {
    public NavigationHelper(ApplicationManager app) {
      super(app);
    }

    public void manageUser(){
      click(By.linkText("Manage Users"));
    }

    public void goToUserPage(int id) {
      click(By.cssSelector("a[href=\"manage_user_edit_page.php?user_id=" + id + "\"]"));
    }
  }

