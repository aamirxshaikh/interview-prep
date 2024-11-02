package com.interviewprep.java_collections_framework.generics.bounded_types_generics;

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
    System.out.println("Data: " + boundInt.getData());
  }
}
