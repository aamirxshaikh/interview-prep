package com.interviewprep.oop_concepts.class_and_object.static_context;

public class AccessingStaticMembers {
  private static final String staticField = "Static Field";

  public static void displayStatic() {
    System.out.println("Accessing: " + staticField);
  }

  public static void main(String[] args) {
    AccessingStaticMembers.displayStatic();
  }
}
