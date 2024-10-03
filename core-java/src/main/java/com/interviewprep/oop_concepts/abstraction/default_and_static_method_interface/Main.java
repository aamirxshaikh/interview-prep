package com.interviewprep.oop_concepts.abstraction.default_and_static_method_interface;

interface Vehicle {
  void start();  // Abstract method

  // Default method
  default void stop() {
    System.out.println("Vehicle stopped.");
  }

  // Static method
  static int calculateSpeed(int distance, int time) {
    return distance / time;
  }
}

class Car implements Vehicle {
  @Override
  public void start() {
    System.out.println("Car started.");
  }
}

public class Main {
  public static void main(String[] args) {
    // Using the default method
    Car car = new Car();
    car.start(); // Output: Car started.
    car.stop();  // Output: Vehicle stopped.

    // Using the static method from the interface
    int speed = Vehicle.calculateSpeed(100, 2);
    System.out.println("Speed: " + speed + " km/h");  // Output: Speed: 50 km/h
  }
}
