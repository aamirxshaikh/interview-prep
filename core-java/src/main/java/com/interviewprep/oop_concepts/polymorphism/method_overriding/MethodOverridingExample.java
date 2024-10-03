package com.interviewprep.oop_concepts.class_and_object.polymorphism.method_overriding;

class Animal {
  // Base method to be overridden
  public void sound() {
    System.out.println("Animal makes a sound");
  }
}

class Dog extends Animal {
  // Overriding the sound method
  @Override
  public void sound() {
    System.out.println("Dog barks");
  }
}

class Cat extends Animal {
  // Overriding the sound method
  @Override
  public void sound() {
    System.out.println("Cat meows");
  }
}

public class MethodOverridingExample {
  public static void main(String[] args) {
    Animal myAnimal = new Animal();  // Animal reference
    Animal myDog = new Dog();        // Dog object assigned to Animal reference
    Animal myCat = new Cat();        // Cat object assigned to Animal reference

    myAnimal.sound();  // Output: Animal makes a sound
    myDog.sound();     // Output: Dog barks
    myCat.sound();     // Output: Cat meows
  }
}
