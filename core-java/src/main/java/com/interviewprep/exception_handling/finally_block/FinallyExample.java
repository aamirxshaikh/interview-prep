package com.interviewprep.exception_handling.finally_block;

public class FinallyExample {
  public static void main(String[] args) {
    try {
      int[] numbers = {1, 2, 3};
      System.out.println(numbers[5]); // ArrayIndexOutOfBoundsException
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Exception caught: " + e.getMessage());
    } finally {
      System.out.println("This is the finally block, executed regardless of the exception.");
    }
  }
}
