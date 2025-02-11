package com.interviewprep.java_collections_framework.queue;

import java.util.Deque;
import java.util.LinkedList;

public class LinkedListDequeExample {
  public static void main(String[] args) {
    // 1. Creating a LinkedList as Deque
    Deque<Integer> deque = new LinkedList<>();

    // 2. Adding Elements (Front and Rear)
    deque.addFirst(10); // Throws exception if capacity is full
    deque.addLast(20);
    deque.offerFirst(30); // Returns false if capacity is full
    deque.offerLast(40);

    System.out.println("LinkedList as Deque after adding elements: " + deque);

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

    System.out.println("LinkedList as Deque after removal: " + deque);

    // 5. Iterating through LinkedList as Deque
    System.out.println("Iterating through LinkedList as Deque:");
    for (Integer num : deque) {
      System.out.println(num);
    }

    // 6. Checking if LinkedList as Deque is Empty
    System.out.println("Is LinkedList as Deque Empty? " + deque.isEmpty());

    // 7. LinkedList as Deque Size
    System.out.println("LinkedList as Deque Size: " + deque.size());

    // 8. Clearing the LinkedList as Deque
    deque.clear();
    System.out.println("LinkedList as Deque after clearing: " + deque);

    // 9. Handling Exceptions
    try {
      deque.removeFirst(); // Throws NoSuchElementException
    } catch (Exception e) {
      System.out.println("Exception on removeFirst() when LinkedList as Deque is empty: " + e);
    }

    try {
      deque.getFirst(); // Throws NoSuchElementException
    } catch (Exception e) {
      System.out.println("Exception on getFirst() when LinkedList as Deque is empty: " + e);
    }
  }
}
