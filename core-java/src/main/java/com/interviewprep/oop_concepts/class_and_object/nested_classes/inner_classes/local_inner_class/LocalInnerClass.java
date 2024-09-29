package com.interviewprep.oop_concepts.class_and_object.nested_classes.inner_classes.local_inner_class;

class OuterClass {
  private int x = 10;

  void outerMethod() {
    int y = 20;

    class LocalInnerClass {
      public void printProduct() {
        System.out.println("Product: " + (x * y));
      }
    }

    LocalInnerClass inner = new LocalInnerClass();
    inner.printProduct(); // Output: Product: 200
  }
}

public class LocalInnerClass {
  public static void main(String[] args) {
    OuterClass outer = new OuterClass();
    outer.outerMethod();
  }
}