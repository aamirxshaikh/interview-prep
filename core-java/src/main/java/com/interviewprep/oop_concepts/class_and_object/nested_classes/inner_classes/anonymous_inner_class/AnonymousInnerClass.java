package com.interviewprep.oop_concepts.class_and_object.nested_classes.inner_classes.anonymous_inner_class;

abstract class Animal {
  abstract void sound();
}

public class AnonymousInnerClass {
  public static void main(String[] args) {
    Animal dog = new Animal() {
      @Override
      void sound() {
        System.out.println("Bark");
      }
    };
    dog.sound(); // Output: Abstract method implemented in anonymous class
  }
}