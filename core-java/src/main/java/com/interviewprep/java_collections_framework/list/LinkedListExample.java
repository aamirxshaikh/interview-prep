package com.interviewprep.java_collections_framework.list;

import java.util.LinkedList;

public class LinkedListExample {
  public static void main(String[] args) {
    // Create a LinkedList
    LinkedList<String> list = new LinkedList<>();
    list.add("Dog");
    list.add("Cat");
    list.add("Rabbit");

    System.out.println("list = " + list);
    
    // Access elements
    System.out.println("First element: " + list.getFirst());
    System.out.println("Last element: " + list.getLast());

    // Insert at start and end
    list.addFirst("Elephant");
    list.addLast("Horse");
    System.out.println("After adding Elephant and Horse: " + list);

    // Insert at specific index
    list.add(2, "Lion");
    System.out.println("After inserting Lion at index 2: " + list);

    // Remove elements
    list.removeFirst();
    list.removeLast();
    System.out.println("After removing first and last element: " + list);

    // Remove element at index
    list.remove(1);
    System.out.println("After removing element at index 1: " + list);
    
    // Iterate over elements
    System.out.println("Iterating over list:");
    for (String animal : list) {
      System.out.println(animal);
    }
  }
}
