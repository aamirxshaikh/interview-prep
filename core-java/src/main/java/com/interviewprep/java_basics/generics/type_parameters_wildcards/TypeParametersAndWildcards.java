package com.interviewprep.java_basics.generics.type_parameters_wildcards;

import java.util.ArrayList;
import java.util.List;

public class TypeParametersAndWildcards {
  // Method using an upper-bounded wildcard (? extends Number)
  public static void printNumbers(List<? extends Number> list) {
    for (Number number : list) {
      System.out.println("Number: " + number);
    }
  }

  // Method using a lower-bounded wildcard (? super Integer)
  public static void addInteger(List<? super Integer> list) {
    list.add(42); // Adds an Integer to the list
    System.out.println("Added an Integer to the list.");
  }

  public static void main(String[] args) {
    // Using an upper-bounded wildcard with a list of Integers
    List<Integer> intList = List.of(1, 2, 3);
    System.out.println("Printing Numbers:");
    printNumbers(intList);

    // Using a lower-bounded wildcard with a list of Numbers
    List<Number> numList = new ArrayList<>(List.of(1.5, 2.5, 3.5));
    System.out.println("\nBefore adding Integer:");
    printNumbers(numList);

    addInteger(numList); // Modify the list using lower-bounded wildcard
    System.out.println("\nAfter adding Integer:");
    printNumbers(numList);
  }
}
