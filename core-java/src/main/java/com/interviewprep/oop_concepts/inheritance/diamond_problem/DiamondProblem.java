package com.interviewprep.oop_concepts.inheritance.diamond_problem;

interface Drivable {
  default void start() {
    System.out.println("Starting the vehicle.");
  }
}

interface Flyable {
  default void start() {
    System.out.println("Starting the aircraft.");
  }
}

class FlyingCar implements Drivable, Flyable {
  // Resolving the diamond problem by overriding the method
  @Override
  public void start() {
    // Choosing to call one of the interface's methods or providing a new implementation
    Drivable.super.start();  // Calling start() from Drivable
    Flyable.super.start();   // Calling start() from Flyable
    System.out.println("Flying car is starting with both features.");
  }
}

public class DiamondProblem {
  public static void main(String[] args) {
    FlyingCar flyingCar = new FlyingCar();
    flyingCar.start();
  }
}

