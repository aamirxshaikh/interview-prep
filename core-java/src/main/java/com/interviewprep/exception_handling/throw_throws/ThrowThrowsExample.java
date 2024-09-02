package com.interviewprep.exception_handling.throw_throws;

class CustomException extends Exception {
  public CustomException(String message) {
    super(message);
  }
}

public class ThrowThrowsExample {
  public static void validateAge(int age) throws CustomException {
    if (age < 18) {
      throw new CustomException("Age is less than 18.");
    } else {
      System.out.println("Age is valid.");
    }
  }

  public static void main(String[] args) {
    try {
      validateAge(15);
    } catch (CustomException e) {
      System.out.println("Exception caught: " + e.getMessage());
    }
  }
}
