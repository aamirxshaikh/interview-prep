package com.interviewprep.exception_handling.exception_propagation;

public class ExceptionPropagation {
  public static void main(String[] args) {
    ExceptionPropagation example = new ExceptionPropagation();
    example.method3();
  }

  public void method1() {
    int result = 10 / 0; // ArithmeticException
  }

  public void method2() {
    method1();
  }

  public void method3() {
    try {
      method2();
    } catch (ArithmeticException e) {
      System.out.println("Exception propagated to method3: " + e.getMessage());
    }
  }
}
