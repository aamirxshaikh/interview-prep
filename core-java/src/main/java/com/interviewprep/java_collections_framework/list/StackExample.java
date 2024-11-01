package com.interviewprep.java_collections_framework.list;

import java.util.Iterator;
import java.util.Stack;

public class StackExample {
  public static void main(String[] args) {
    // Create a Stack
    Stack<String> stack = new Stack<>();
    stack.push("Red");
    stack.push("Green");
    stack.push("Blue");

    // Print stack
    System.out.println("stack = " + stack);

    // Access top element without removing
    System.out.println("Top element: " + stack.peek());

    // Remove top element
    stack.pop();
    System.out.println("After pop: " + stack);

    // Check if stack is empty
    System.out.println("Is stack empty? " + stack.isEmpty());

    // Iterate over elements (LIFO order)
    System.out.println("Iterating over stack:");
    for (String color : stack) {
      System.out.println(color);
    }
  }
}
