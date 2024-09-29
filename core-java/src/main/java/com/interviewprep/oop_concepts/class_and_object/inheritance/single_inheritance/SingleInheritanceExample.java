package com.interviewprep.oop_concepts.class_and_object.inheritance.single_inheritance;

// Superclass
class Animal {
  void makeSound() {
    System.out.println("Animal makes a sound");
  }
}

// Subclass
class Dog extends Animal {
  void bark() {
    System.out.println("Dog barks");
  }
}

// Main Class
public class SingleInheritanceExample {
  public static void main(String[] args) {
    Dog dog = new Dog();
    dog.makeSound(); // Inherited method
    dog.bark();      // Subclass method
  }
}
