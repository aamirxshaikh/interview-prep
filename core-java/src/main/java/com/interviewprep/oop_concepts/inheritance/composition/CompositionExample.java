package com.interviewprep.oop_concepts.inheritance.composition;

class Engine {
  void start() {
    System.out.println("Engine starts");
  }
}

class Car {
  // Composition - Car has an Engine
  private Engine engine;

  public Car() {
    engine = new Engine();
  }

  void drive() {
    engine.start(); // Using the composed object
    System.out.println("Car drives");
  }
}

// Main Class
public class CompositionExample {
  public static void main(String[] args) {
    Car car = new Car();
    car.drive();
  }
}

