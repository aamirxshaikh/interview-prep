package com.interviewprep.java_collections_framework.generics.generic_classes_interfaces;

// Define a generic interface
interface Container<T> {
  T get();
}

// Implement the generic interface in the Box class
class Box<T> implements Container<T> {
  private final T value;

  public Box(T value) {
    this.value = value;
  }

  // Implementing the get method from Container
  @Override
  public T get() {
    return value;
  }
}

// Main class to test the generic class and interface
public class GenericClassesAndInterfaces {
  public static void main(String[] args) {
    Box<Integer> integerBox = new Box<>(10);
    System.out.println("Box contains: " + integerBox.get()); // Using the get() method from Container
  }
}
