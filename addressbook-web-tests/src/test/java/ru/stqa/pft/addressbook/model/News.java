package ru.stqa.pft.addressbook.model;

import org.testng.annotations.Test;


public class News {
  public String email;


  public News(String email) {
    this.email = email;
  }


  public News withEmail(String email) {
    this.email = email;
    return this;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String toString() {
    return "News{" +
            "email='" + email + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    News news = (News) o;

    return email != null ? email.equals(news.email) : news.email == null;
  }

  @Override
  public int hashCode() {
    return email != null ? email.hashCode() : 0;
  }
}