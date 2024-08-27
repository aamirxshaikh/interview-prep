package com.interviewprep.data_types_and_variables.constants;

/**
 * @author aamir on 8/26/24
 */
public class Constants {
  public static void main(String[] args) {
    final int MAX_HEIGHT = 180;
    System.out.println("Max Height: " + MAX_HEIGHT);

    // MAX_HEIGHT = 200; // Compilation error: cannot assign a value to final variable

    final int number;
    number = 10; // Allowed
    // number = 20; // Compilation error: cannot assign a second value to final variable

    System.out.println("number = " + number);
  }
}
