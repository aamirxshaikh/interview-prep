package com.interviewprep.exception_handling.types;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TypesOfExceptions {
  public static void main(String[] args) {
    // Unchecked Exception (Runtime Exception)
    try {
      int result = 10 / 0; // ArithmeticException
    } catch (ArithmeticException e) {
      System.out.println("Unchecked Exception caught: " + e.getMessage());
    }

    // Checked Exception
    try {
      File file = new File("nonexistentfile.txt");
      Scanner scanner = new Scanner(file); // FileNotFoundException
    } catch (FileNotFoundException e) {
      System.out.println("Checked Exception caught: " + e.getMessage());
    }
  }
}
