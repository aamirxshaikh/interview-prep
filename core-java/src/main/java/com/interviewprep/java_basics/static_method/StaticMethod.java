package com.interviewprep.java_basics.static_method;

/**
 * Static methods belong to the class rather than the instance of the class. They can be accessed without creating an instance of the class.
 *
 * @author aamir on 8/24/24
 */
public class StaticMethod {
  int instanceVariable = 10;

  public static void main(String[] args) {
    int sum = StaticMethod.add(5, 10);
    System.out.println("Sum: " + sum);
  }

  static int add(int a, int b) {
    return a + b;
  }

  static void staticMethod() {
    // System.out.println(instanceVariable); // Uncommenting this line will cause a compilation error
  }
}
