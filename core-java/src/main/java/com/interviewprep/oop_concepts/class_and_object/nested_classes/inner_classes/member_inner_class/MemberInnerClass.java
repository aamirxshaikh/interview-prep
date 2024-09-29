package com.interviewprep.oop_concepts.class_and_object.nested_classes.inner_classes.member_inner_class;

class OuterClass {
  private int x = 10;

  class InnerClass {
    private int y = 20;

    public void printSum() {
      System.out.println("Sum: " + (x + y));
    }
  }
}

public class MemberInnerClass {
  public static void main(String[] args) {
    OuterClass outer = new OuterClass();
    OuterClass.InnerClass inner = outer.new InnerClass();
    inner.printSum(); // Output: Sum: 30
  }
}