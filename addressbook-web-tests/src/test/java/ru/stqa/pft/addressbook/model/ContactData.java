package ru.stqa.pft.addressbook.model;

public class ContactData {


  private int id = Integer.MAX_VALUE;
  private String name;
  private String surname;
  private String group;
  private String workPhone;
  private String mobilPhone;
  private String homePhone;
  private String allPhones;



  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }
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

  public ContactData withWorkPhone(String work) {
    this.workPhone = work;
    return this;
  }

  public ContactData withHomePhone(String home) {
    this.homePhone = home;
    return this;
  }

  public ContactData withMobilPhone(String mobil) {
    this.mobilPhone = mobil;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }


  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }


  public String getGroup() {
    return group;
  }


  public String getWorkPhone() {
    return workPhone;
  }

  public String getMobilPhone() {
    return mobilPhone;
  }


  public String getHomePhone() {
    return homePhone;
  }

  public String getWithAllPhones() {
    return allPhones;
  }


  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", surname='" + surname + '\'' +
            ", workPhone='" + workPhone + '\'' +
            ", mobilPhone='" + mobilPhone + '\'' +
            ", homePhone='" + homePhone + '\'' +
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
    if (workPhone != null ? !workPhone.equals(that.workPhone) : that.workPhone != null) return false;
    if (mobilPhone != null ? !mobilPhone.equals(that.mobilPhone) : that.mobilPhone != null) return false;
    return homePhone != null ? homePhone.equals(that.homePhone) : that.homePhone == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (surname != null ? surname.hashCode() : 0);
    result = 31 * result + (workPhone != null ? workPhone.hashCode() : 0);
    result = 31 * result + (mobilPhone != null ? mobilPhone.hashCode() : 0);
    result = 31 * result + (homePhone != null ? homePhone.hashCode() : 0);
    return result;
  }
}
