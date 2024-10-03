package com.interviewprep.oop_concepts.polymorphism.method_overloading;

class Calculator {
  // Method overloading with different parameter types
  public int add(int a, int b) {
    return a + b;
  }

  public double add(double a, double b) {
    return a + b;
  }

  public int add(int a, int b, int c) {
    return a + b + c;
  }
}

public class MethodOverloadingExample {
  public static void main(String[] args) {
    Calculator calc = new Calculator();
    System.out.println("Sum (int): " + calc.add(5, 10));        // 15
    System.out.println("Sum (double): " + calc.add(5.5, 4.5));  // 10.0
    System.out.println("Sum (3 int): " + calc.add(5, 10, 15));  // 30
  }
}
