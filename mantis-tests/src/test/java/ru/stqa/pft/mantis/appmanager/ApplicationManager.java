package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.regex.MatchResult;

public class ApplicationManager {
  private final Properties properties;
  private WebDriver wd;
  private String browser;
  private RegistrationHelper registrationHelper;
  private FtpHelper ftp;
  private MailHelper mailHelper;
  private JamesHelper jamesHelper;
  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private UserManagmentHelper userManagmentHelper;
  private DbHelper dbHelper;
  private SoapHelper soapHelper;
  private UserHelper userHelper;


  public ApplicationManager(String browser) {
    this.browser = browser;
    properties = new Properties();
  }

  public void init() throws Exception {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
    dbHelper = new DbHelper();
  }

  public void logout() {
    wd.findElement(By.linkText("Logout")).click();
  }


  public void stop() {
    if (wd != null) {
      wd.quit();
    }
  }

  public HttpSession newSession() {
    return new HttpSession(this);
  }

  public String getProperty(String key) {
    return properties.getProperty(key);
  }

  public RegistrationHelper registration() {
    if (registrationHelper == null) {
      registrationHelper = new RegistrationHelper(this);
    }
    return registrationHelper;
  }

  public WebDriver getDriver() {
    if (wd == null) {
      if (browser.equals(BrowserType.FIREFOX)) {
        wd = new FirefoxDriver();
      } else if (browser.equals(BrowserType.CHROME)) {
        wd = new ChromeDriver();
      } else if (browser.equals(BrowserType.IE)) {
        wd = new InternetExplorerDriver();
      }
      wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      wd.get(properties.getProperty("web.baseUrl"));
    }
    return wd;
  }

  public FtpHelper ftp(){
    if(ftp == null){
      ftp = new FtpHelper(this);
    }
    return ftp;
  }

  public MailHelper mail(){
    if(mailHelper == null){
      mailHelper = new MailHelper(this);
    }
    return mailHelper;
  }

  public JamesHelper james (){
    if (jamesHelper == null){
      jamesHelper = new JamesHelper(this);
    }
    return jamesHelper;
  }

  public SessionHelper session(){
    if(sessionHelper == null){
      sessionHelper = new SessionHelper(this);
    }
    return sessionHelper;
  }

  public NavigationHelper goTo(){
    if(navigationHelper == null){
      navigationHelper = new NavigationHelper(this);
    }
    return navigationHelper;
  }

  public UserManagmentHelper user(){
    if(userManagmentHelper == null){
      userManagmentHelper = new UserManagmentHelper(this);
    }
    return userManagmentHelper;
  }

  public DbHelper db(){
    return dbHelper;
  }

  public SoapHelper soap() {
    if (soapHelper == null) {
      soapHelper = new SoapHelper(this);
    }
    return soapHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public void setNavigationHelper(NavigationHelper navigationHelper) {
    this.navigationHelper = navigationHelper;
  }

  public UserHelper getUserHelper() {
    return userHelper;
  }

  public void setUserHelper(UserHelper userHelper) {
    this.userHelper = userHelper;
  }
}