
package com.interviewprep.java_collections_framework.set.linkedhashset;

import java.util.LinkedHashSet;

public class LinkedHashSetExample {
  public static void main(String[] args) {
    LinkedHashSet<String> set = new LinkedHashSet<>();

    // Adding elements
    set.add("Apple");
    set.add("Banana");
    set.add("Cherry");
    set.add(null); // LinkedHashSet allows null values
    set.add("Apple"); // Duplicate, will not be added

    System.out.println("LinkedHashSet: " + set);

    // Removing an element
    set.remove("Banana");
    System.out.println("After removing 'Banana': " + set);

    // Checking if an element exists
    System.out.println("Contains 'Cherry': " + set.contains("Cherry"));

    // Iterating through the LinkedHashSet
    System.out.println("Iterating through LinkedHashSet:");
    for (String fruit : set) {
      System.out.println(fruit);
    }

    // LinkedHashSet size
    System.out.println("Size of LinkedHashSet: " + set.size());
  }
}
