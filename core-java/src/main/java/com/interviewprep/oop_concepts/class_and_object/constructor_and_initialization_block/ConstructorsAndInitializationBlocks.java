package com.interviewprep.oop_concepts.class_and_object.constructor_and_initialization_block;

public class ConstructorsAndInitializationBlocks {
  private final String name;
  private final int age;

  // Initialization block
  {
    System.out.println("Initialization Block");
  }

  // Constructor
  public ConstructorsAndInitializationBlocks(String name, int age) {
    this.name = name;
    this.age = age;
  }

  // Method to display details
  public void displayDetails() {
    System.out.println("Name: " + name + ", Age: " + age);
  }

  public static void main(String[] args) {
    ConstructorsAndInitializationBlocks person = new ConstructorsAndInitializationBlocks("Alice", 30);
    person.displayDetails();
  }
}
