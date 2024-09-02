package com.interviewprep.exception_handling.introduction;

public class IntroductionToExceptions {
  public static void main(String[] args) {
    try {
      int result = 10 / 0; // This will cause an ArithmeticException
    } catch (ArithmeticException e) {
      System.out.println("Exception caught: " + e.getMessage());
    }
  }
}
