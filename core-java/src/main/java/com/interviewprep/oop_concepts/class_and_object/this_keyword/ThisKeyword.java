package com.interviewprep.oop_concepts.class_and_object.this_keyword;

public class ThisKeyword {
  private final String name;
  private final int age;

  // Constructor using 'this' keyword
  public ThisKeyword(String name, int age) {
    this.name = name;
    this.age = age;
  }

  // Method using 'this' keyword to call another constructor
  public ThisKeyword() {
    this("Default Name", 0);
  }

  // Method to display details
  public void displayDetails() {
    System.out.println("Name: " + this.name + ", Age: " + this.age);
  }

  public static void main(String[] args) {
    ThisKeyword person = new ThisKeyword("Bob", 40);
    person.displayDetails();
  }
}

