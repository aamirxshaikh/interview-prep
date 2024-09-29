package com.interviewprep.oop_concepts.class_and_object.class_and_object;

public class DefiningClassAndCreatingObjects {
  // Fields
  private final String name;
  private final int age;

  // Constructor
  public DefiningClassAndCreatingObjects(String name, int age) {
    this.name = name;
    this.age = age;
  }

  // Method to display details
  public void displayDetails() {
    System.out.println("Name: " + name + ", Age: " + age);
  }

  public static void main(String[] args) {
    // Creating an object of the class
    DefiningClassAndCreatingObjects person = new DefiningClassAndCreatingObjects("John", 25);
    person.displayDetails();
  }
}
