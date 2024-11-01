package com.interviewprep.java_collections_framework.list;

import java.util.ArrayList;

public class ArrayListExample {
  public static void main(String[] args) {
    // Create an ArrayList
    ArrayList<String> list = new ArrayList<>();
    list.add("Apple");
    list.add("Banana");
    list.add("Cherry");

    // Access elements
    System.out.println("First element: " + list.getFirst());

    // Insert at index
    list.add(1, "Blueberry");
    System.out.println("After inserting Blueberry at index 1: " + list);

    // Update an element
    list.set(2, "Blackberry");
    System.out.println("After updating element at index 2: " + list);

    // Remove elements
    list.remove("Cherry");
    System.out.println("After removing Cherry: " + list);

    // Iterate over elements
    System.out.println("Iterating over list:");
    for (String fruit : list) {
      System.out.println(fruit);
    }
  }
}
