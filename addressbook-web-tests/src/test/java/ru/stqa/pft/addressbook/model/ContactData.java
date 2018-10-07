package ru.stqa.pft.addressbook.model;

public class ContactData {


  public ContactData withId(int id) {
    this.id = id;
    return this;
  }


  public ContactData withName(String name) {
    this.name = name;
    return this;

  }

  public ContactData withSurname(String surname) {
    this.surname = surname;
    return this;

  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;

  }

  public ContactData withTelephone(String telephone) {
    this.telephone = telephone;
    return this;

  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;

  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  private  int id = Integer.MAX_VALUE;
  private  String name;
  private  String surname;
  private  String address;
  private  String telephone;
  private  String email;
  private  String group;


  public int getId() {
    return id;
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


  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", surname='" + surname + '\'' +
            ", address='" + address + '\'' +
            ", telephone='" + telephone + '\'' +
            ", email='" + email + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
    if (address != null ? !address.equals(that.address) : that.address != null) return false;
    if (telephone != null ? !telephone.equals(that.telephone) : that.telephone != null) return false;
    return email != null ? email.equals(that.email) : that.email == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (surname != null ? surname.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    return result;
  }
}
