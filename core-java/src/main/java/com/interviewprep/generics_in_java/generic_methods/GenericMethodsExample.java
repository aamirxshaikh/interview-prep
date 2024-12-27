package com.interviewprep.generics_in_java.generic_methods;

public class GenericMethodsExample {
  public static <T> void displayArray(T[] array) {
    for (T element : array) {
      System.out.print(element + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Integer[] intArray = {1, 2, 3, 4};
    displayArray(intArray);
  }
}
