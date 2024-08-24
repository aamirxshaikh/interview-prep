package com.interviewprep.java_basics.static_nested_class;

/**
 * Static nested classes are used to group classes that are only used in one place. They can access static members of the outer class.
 *
 * @author aamir on 8/24/24
 */
public class StaticNestedClass {
  private static String outerMessage = "Outer class message";
  private String outerInstanceMessage = "Outer class instance variable message";

  static class NestedClass {
    private static String nestedMessage = "Nested class message";

    void display() {
      System.out.println("This is a static nested class.");
      System.out.println(outerMessage);  // Accessing static variable from outer class
      System.out.println(nestedMessage); // Accessing static variable from nested class
//      System.out.println(outerInstanceMessage); // Uncommenting this line will result in a compilation error
    }
  }

  public static void main(String[] args) {
    StaticNestedClass.NestedClass nested = new StaticNestedClass.NestedClass();
    nested.display();
  }
}
