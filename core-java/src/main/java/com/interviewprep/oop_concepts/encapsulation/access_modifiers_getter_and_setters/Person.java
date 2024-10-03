package com.interviewprep.oop_concepts.class_and_object.encapsulation.access_modifiers_getter_and_setters;

public class Person {
  private String name;         // Private: accessible only within this class. Hidden data.
  protected int age;           // Protected: accessible within package and subclasses
  public String gender;        // Public: accessible from anywhere
  String country;              // Default: accessible within the package

  public Person(String name, int age, String gender, String country) {
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.country = country;
  }

  private void displayPrivateInfo() {
    System.out.println("Private Info: Name: " + name);
  }

  protected void displayProtectedInfo() {
    System.out.println("Protected Info: Age: " + age);
  }

  public void displayPublicInfo() {
    System.out.println("Public Info: Gender: " + gender);
  }

  void displayDefaultInfo() {
    System.out.println("Default Info: Country: " + country);
  }

  // Getters and Setters
  // Controlled access to hidden data
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }
}

