package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String name;
  private final String surname;
  private final String address;
  private final String telephone;
  private final String email;
  private String group;

  public ContactData(String name, String surname, String address, String telephone, String email, String group) {
    this.name = name;
    this.surname = surname;
    this.address = address;
    this.telephone = telephone;
    this.email = email;
    this.group = group;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public String getAddress() {
    return address;
  }

  public String getTelephone() {
    return telephone;
  }

  public String getEmail() {
    return email;
  }

  public String getGroup() {
    return group;
  }
}
