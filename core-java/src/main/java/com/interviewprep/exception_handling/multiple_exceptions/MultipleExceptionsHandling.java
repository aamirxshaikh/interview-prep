package com.interviewprep.exception_handling.multiple_exceptions;

public class MultipleExceptionsHandling {
  public static void main(String[] args) {
    try {
      int[] numbers = {1, 2, 3};
      System.out.println(numbers[5]); // ArrayIndexOutOfBoundsException
      String str = null;
      System.out.println(str.length()); // NullPointerException
    } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
      System.out.println("Caught exception: " + e.getMessage());
    }
  }
}
