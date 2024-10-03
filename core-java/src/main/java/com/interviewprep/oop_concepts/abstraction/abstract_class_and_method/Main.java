package com.interviewprep.oop_concepts.abstraction.abstract_class_and_method;

abstract class Animal {
  // Abstract method (no implementation)
  public abstract void sound();

  // Regular method
  public void sleep() {
    System.out.println("Sleeping...");
  }
}

class Dog extends Animal {
  // Providing implementation for abstract method
  @Override
  public void sound() {
    System.out.println("Woof");
  }
}

class Cat extends Animal {
  // Providing implementation for abstract method
  @Override
  public void sound() {
    System.out.println("Meow");
  }
}

public class Main {
  public static void main(String[] args) {
    Animal dog = new Dog();
    dog.sound();  // Output: Woof
    dog.sleep();  // Output: Sleeping...

    Animal cat = new Cat();
    cat.sound();  // Output: Meow
  }
}
