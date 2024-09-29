package com.interviewprep.oop_concepts.class_and_object.polymorphism.covariant_return_types;

class Vehicle {
  public Vehicle getVehicle() {
    return this;
  }

  public void display() {
    System.out.println("This is a vehicle");
  }
}

class Car extends Vehicle {
  // Overriding method with covariant return type
  @Override
  public Car getVehicle() {
    return this;
  }

  @Override
  public void display() {
    System.out.println("This is a car");
  }
}

public class CovariantReturnTypesExample {
  public static void main(String[] args) {
    Vehicle vehicle = new Vehicle();
    vehicle.getVehicle().display();  // Output: This is a vehicle

    Car car = new Car();
    car.getVehicle().display();      // Output: This is a car
  }
}
