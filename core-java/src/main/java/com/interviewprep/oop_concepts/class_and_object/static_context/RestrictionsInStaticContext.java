package com.interviewprep.oop_concepts.class_and_object.static_context;

public class RestrictionsInStaticContext {
  private final String instanceField = "Instance Field";

  // Static method cannot access non-static fields directly
  public static void invalidAccess() {
    // Uncommenting below line will cause a compile-time error
    // System.out.println(instanceField);
  }

  public static void main(String[] args) {
    invalidAccess();
  }
}
