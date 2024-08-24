package com.interviewprep.java_basics.static_block;

/**
 * Static block is used to initialize the static variables of the class. It is executed before the main method at the time of class loading.
 *
 * @author aamir on 8/24/24
 */
public class StaticBlock {
  static int value;

  static {
    value = 42;
    System.out.println("Static block initialized. Value: " + value);
  }

  static {
    System.out.println("Another static block.");
  }

  public static void main(String[] args) {
    System.out.println("Main method executed. Value: " + value);
  }
}
