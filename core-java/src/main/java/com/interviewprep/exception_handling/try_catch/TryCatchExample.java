package com.interviewprep.exception_handling.try_catch;

public class TryCatchExample {
  public static void main(String[] args) {
    try {
      String str = null;
      System.out.println(str.length()); // NullPointerException
    } catch (NullPointerException e) {
      System.out.println("Caught exception: " + e.getMessage());
    }
  }
}
