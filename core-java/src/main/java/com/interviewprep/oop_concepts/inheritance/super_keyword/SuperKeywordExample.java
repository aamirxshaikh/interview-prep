package com.interviewprep.oop_concepts.class_and_object.inheritance.super_keyword;

// Superclass
class Animal {
  void makeSound() {
    System.out.println("Animal makes a sound");
  }
}

// Subclass
class Dog extends Animal {
  @Override
  void makeSound() {
    super.makeSound(); // Calling superclass method
    System.out.println("Dog barks");
  }
}

// Main Class
public class SuperKeywordExample {
  public static void main(String[] args) {
    Dog dog = new Dog();
    dog.makeSound(); // Calls both superclass and subclass methods
  }
}

