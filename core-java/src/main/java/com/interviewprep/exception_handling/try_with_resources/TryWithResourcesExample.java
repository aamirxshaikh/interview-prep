package com.interviewprep.exception_handling.try_with_resources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesExample {
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new FileReader("example.txt"))) {
      String line;
      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException e) {
      System.out.println("Caught exception: " + e.getMessage());
    }
  }
}
