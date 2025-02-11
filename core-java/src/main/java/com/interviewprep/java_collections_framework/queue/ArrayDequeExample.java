package com.interviewprep.java_collections_framework.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeExample {
  public static void main(String[] args) {
    // 1. Creating an ArrayDeque
    Deque<Integer> deque = new ArrayDeque<>();

    // 2. Adding Elements (Front and Rear)
    deque.addFirst(10); // Throws exception if capacity is full
    deque.addLast(20);
    deque.offerFirst(30); // Returns false if capacity is full
    deque.offerLast(40);

    System.out.println("ArrayDeque after adding elements: " + deque);

    // 3. Retrieving Elements
    System.out.println("First Element (peekFirst): " + deque.peekFirst()); // Returns null if empty
    System.out.println("Last Element (peekLast): " + deque.peekLast()); // Returns null if empty
    System.out.println("First Element (getFirst): " + deque.getFirst()); // Throws exception if empty
    System.out.println("Last Element (getLast): " + deque.getLast()); // Throws exception if empty

    // 4. Removing Elements (Front and Rear)
    System.out.println("Removed First (pollFirst): " + deque.pollFirst()); // Returns null if empty
    System.out.println("Removed Last (pollLast): " + deque.pollLast()); // Returns null if empty
    System.out.println("Removed First (removeFirst): " + deque.removeFirst()); // Throws exception if empty
    System.out.println("Removed Last (removeLast): " + deque.removeLast()); // Throws exception if empty

    System.out.println("ArrayDeque after removal: " + deque);

    // 5. Iterating through ArrayDeque
    System.out.println("Iterating through ArrayDeque:");
    for (Integer num : deque) {
      System.out.println(num);
    }

    // 6. Checking if ArrayDeque is Empty
    System.out.println("Is ArrayDeque Empty? " + deque.isEmpty());

    // 7. ArrayDeque Size
    System.out.println("ArrayDeque Size: " + deque.size());

    // 8. Clearing the ArrayDeque
    deque.clear();
    System.out.println("ArrayDeque after clearing: " + deque);

    // 9. Handling Exceptions
    try {
      deque.removeFirst(); // Throws NoSuchElementException
    } catch (Exception e) {
      System.out.println("Exception on removeFirst() when ArrayDeque is empty: " + e);
    }

    try {
      deque.getFirst(); // Throws NoSuchElementException
    } catch (Exception e) {
      System.out.println("Exception on getFirst() when ArrayDeque is empty: " + e);
    }
  }
}
