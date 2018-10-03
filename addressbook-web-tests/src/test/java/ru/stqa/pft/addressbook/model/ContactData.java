package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String id;
  private final String name;
  private final String surname;
  private final String address;
  private final String telephone;
  private final String email;
  private final String group;


  public ContactData(String name, String surname, String address, String telephone, String email, String group) {
    this.id = null;
    this.name = name;
    this.surname = surname;
    this.address = address;
    this.telephone = telephone;
    this.email = email;
    this.group = group;
  }


  public ContactData(String id, String name, String surname, String address, String telephone, String email, String group) {
    this.id = id;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
    if (address != null ? !address.equals(that.address) : that.address != null) return false;
    if (telephone != null ? !telephone.equals(that.telephone) : that.telephone != null) return false;
    return email != null ? email.equals(that.email) : that.email == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (surname != null ? surname.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    return result;
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

  public String getId() {
    return id;
  }

}
