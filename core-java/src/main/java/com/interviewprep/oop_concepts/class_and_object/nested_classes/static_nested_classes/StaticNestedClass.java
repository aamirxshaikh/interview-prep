package com.interviewprep.oop_concepts.class_and_object.nested_classes.static_nested_classes;

class OuterClass {
  private static int x = 10;

  static class StaticNestedClass {
    private int y = 20;

    public void printSum() {
      System.out.println("Sum: " + (x + y));
    }
  }
}

public class StaticNestedClass {
  public static void main(String[] args) {
    OuterClass.StaticNestedClass nested = new OuterClass.StaticNestedClass();
    nested.printSum(); // Output: Sum: 30
  }
}