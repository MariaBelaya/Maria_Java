package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {
  @XStreamOmitField


  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;

  @Column(name = "firstname")
  private String name;

  @Column(name = "lastname")
  private String surname;

  @Transient
  private String address;

  @Transient
  private String allPhones;

  @Column(name = "work")
  @Type(type = "text")
  private String workPhone;

  @Column(name = "mobile")
  @Type(type = "text")
  private String mobilPhone;

  @Column(name = "home")
  @Type(type = "text")
  private String homePhone;

  @Transient
  private String allEmails;

  @Transient
  private String email;

  @Transient
  private String email2;

  @Transient
  private String email3;

  @Column(name = "photo")
  @Type(type = "text")
  private String photo;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "address_in_groups",
          joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
  private Set<GroupData> groups = new HashSet<GroupData>();

//  @ManyToMany(fetch = FetchType.EAGER)
//  @JoinTable(name = "address_in_groups",
//          joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
//  private Set<GroupData> groups = new HashSet<GroupData>();



  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

  public File getPhoto() {
    return new File(photo);
  }

    public ContactData inGroup(GroupData group) {
      groups.add(group);
      return this;
  }

  public Groups getGroups() {
    return new Groups(groups);
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withhAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withEmail1(String email) {
    this.email = email;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
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

  public ContactData withMobilPhone(String mobile) {
    this.mobilPhone = mobile;
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

  public String getAllEmails() {
    return allEmails;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getAddress() {
    return address;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", surname='" + surname + '\'' +
            ", groups=" + groups +
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
    return groups != null ? groups.equals(that.groups) : that.groups == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (surname != null ? surname.hashCode() : 0);
    result = 31 * result + (groups != null ? groups.hashCode() : 0);
    return result;
  }
}
