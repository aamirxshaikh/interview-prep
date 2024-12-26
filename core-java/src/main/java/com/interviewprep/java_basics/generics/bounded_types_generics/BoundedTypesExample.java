package com.interviewprep.java_basics.generics.bounded_types_generics;

class Bound<T extends Number> {
  private final T data;

  public Bound(T data) {
    this.data = data;
  }

  public T getData() {
    return data;
  }
}

public class BoundedTypesExample {
  public static void main(String[] args) {
    Bound<Integer> boundInt = new Bound<>(5);
    Bound<Float> boundFloat = new Bound<>(3.14f);
    Bound<Long> boundLong = new Bound<>(1000000000L);

    System.out.println("Integer: " + boundInt.getData());
    System.out.println("Float: " + boundFloat.getData());
    System.out.println("Long: " + boundLong.getData());

    System.out.println("Sum of integers: " + sum(10, 20));
    System.out.println("Sum of doubles: " + sum(5.5, 4.5));
    System.out.println("Sum of floats: " + sum(3.0f, 7.5f));
  }

  // Method that accepts only numbers or subclasses of Number
  public static <T extends Number> double sum(T num1, T num2) {
    return num1.doubleValue() + num2.doubleValue();
  }
}
