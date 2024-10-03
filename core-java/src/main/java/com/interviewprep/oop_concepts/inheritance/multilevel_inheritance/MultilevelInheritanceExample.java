package com.interviewprep.oop_concepts.inheritance.multilevel_inheritance;

// Base Class
class Animal {
  void eat() {
    System.out.println("Animal eats");
  }
}

// Intermediate Class
class Mammal extends Animal {
  void walk() {
    System.out.println("Mammal walks");
  }
}

// Derived Class
class Dog extends Mammal {
  void bark() {
    System.out.println("Dog barks");
  }
}

// Main Class
public class MultilevelInheritanceExample {
  public static void main(String[] args) {
    Dog dog = new Dog();
    dog.eat();  // Inherited from Animal
    dog.walk(); // Inherited from Mammal
    dog.bark(); // Subclass method
  }
}
