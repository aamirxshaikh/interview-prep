package com.interviewprep.exception_handling.custom_exceptions;

class InvalidAgeException extends Exception {
  public InvalidAgeException(String message) {
    super(message);
  }
}

public class CustomExceptions {
  public static void checkAge(int age) throws InvalidAgeException {
    if (age < 18) {
      throw new InvalidAgeException("Age is not valid for voting.");
    } else {
      System.out.println("Welcome to vote.");
    }
  }

  public static void main(String[] args) {
    try {
      checkAge(16);
    } catch (InvalidAgeException e) {
      System.out.println("Caught exception: " + e.getMessage());
    }
  }
}
