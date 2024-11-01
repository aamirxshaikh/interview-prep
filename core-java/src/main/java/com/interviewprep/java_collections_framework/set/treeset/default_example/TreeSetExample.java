
package com.interviewprep.java_collections_framework.set.treeset.default_example;

import java.util.TreeSet;

public class TreeSetExample {
  public static void main(String[] args) {
    TreeSet<String> set = new TreeSet<>();

    // Adding elements
    set.add("Apple");
    set.add("Cherry");
    set.add("Banana");
    // set.add(null); // TreeSet does not allow null values, will throw NullPointerException

    System.out.println("TreeSet (Sorted): " + set);

    // Removing an element
    set.remove("Banana");
    System.out.println("After removing 'Banana': " + set);

    // Checking if an element exists
    System.out.println("Contains 'Cherry': " + set.contains("Cherry"));

    // Iterating through the TreeSet
    System.out.println("Iterating through TreeSet:");
    for (String fruit : set) {
      System.out.println(fruit);
    }

    // TreeSet size
    System.out.println("Size of TreeSet: " + set.size());

    // Accessing first and last elements
    System.out.println("First Element: " + set.first());
    System.out.println("Last Element: " + set.last());
  }
}
