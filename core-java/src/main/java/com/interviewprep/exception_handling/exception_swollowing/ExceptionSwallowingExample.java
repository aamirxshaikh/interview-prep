package com.interviewprep.exception_handling.exception_swollowing;

/**
 * @author aamir on 9/2/24
 */
public class ExceptionSwallowingExample {
  public static void main(String[] args) {
    try {
      int result = divide(10, 0);
    } catch (ArithmeticException e) {
      // Swallowing the exception by doing nothing
    }
    System.out.println("Program continues...");
  }

  public static int divide(int a, int b) {
    return a / b; // This will throw ArithmeticException
  }
}

