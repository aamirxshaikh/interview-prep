package com.interviewprep.oop_concepts.class_and_object.inheritance.method_overriding;

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
    System.out.println("Dog barks");
  }
}

// Main Class
public class MethodOverridingExample {
  public static void main(String[] args) {
    Animal animal = new Dog();
    animal.makeSound(); // Dog's overridden method is called
  }
}
