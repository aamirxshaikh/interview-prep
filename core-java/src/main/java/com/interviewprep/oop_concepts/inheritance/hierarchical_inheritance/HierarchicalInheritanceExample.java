package com.interviewprep.oop_concepts.class_and_object.inheritance.hierarchical_inheritance;

// Superclass
class Animal {
  void makeSound() {
    System.out.println("Animal makes a sound");
  }
}

// Subclass 1
class Dog extends Animal {
  void bark() {
    System.out.println("Dog barks");
  }
}

// Subclass 2
class Cat extends Animal {
  void meow() {
    System.out.println("Cat meows");
  }
}

// Main Class
public class HierarchicalInheritanceExample {
  public static void main(String[] args) {
    Dog dog = new Dog();
    Cat cat = new Cat();

    dog.makeSound(); // Inherited from Animal
    dog.bark();      // Specific to Dog

    cat.makeSound(); // Inherited from Animal
    cat.meow();      // Specific to Cat
  }
}

