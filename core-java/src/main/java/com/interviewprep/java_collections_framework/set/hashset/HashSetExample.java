
package com.interviewprep.java_collections_framework.set.hashset;

import java.util.HashSet;

public class HashSetExample {
  public static void main(String[] args) {
    HashSet<String> set = new HashSet<>();

    // Adding elements
    set.add("Apple");
    set.add("Banana");
    set.add("Cherry");
    set.add(null); // HashSet allows null values
    set.add("Apple"); // Duplicate, will not be added

    System.out.println("HashSet: " + set);

    // Removing an element
    set.remove("Banana");
    System.out.println("After removing 'Banana': " + set);

    // Checking if an element exists
    System.out.println("Contains 'Cherry': " + set.contains("Cherry"));

    // Iterating through the HashSet
    System.out.println("Iterating through HashSet:");
    for (String fruit : set) {
      System.out.println(fruit);
    }

    // HashSet size
    System.out.println("Size of HashSet: " + set.size());
  }
}
