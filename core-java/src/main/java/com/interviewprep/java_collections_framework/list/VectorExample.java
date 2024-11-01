package com.interviewprep.java_collections_framework.list;

import java.util.Vector;

public class VectorExample {
  public static void main(String[] args) {
    // Create a Vector
    Vector<Integer> vector = new Vector<>();
    vector.add(1);
    vector.add(2);
    vector.add(3);

    // Access elements
    System.out.println("Element at index 0: " + vector.get(0));

    // Insert at index
    vector.add(1, 4);
    System.out.println("After inserting 4 at index 1: " + vector);

    // Update an element
    vector.set(2, 5);
    System.out.println("After updating element at index 2: " + vector);

    // Remove elements
    vector.remove(Integer.valueOf(1));
    System.out.println("After removing 1: " + vector);

    // Iterate over elements
    System.out.println("Iterating over vector:");
    for (Integer number : vector) {
      System.out.println(number);
    }
  }
}
