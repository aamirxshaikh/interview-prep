package com.interviewprep.java_collections_framework.queue;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListQueueExample {
  public static void main(String[] args) {
    // 1. Creating a LinkedList as Queue
    Queue<Integer> queue = new LinkedList<>();

    // 2. Adding Elements (Enqueue)
    queue.offer(10); // Returns true if successful
    queue.add(20);   // Throws an exception if it fails
    queue.offer(30);
    queue.add(40);

    System.out.println("Queue after adding elements: " + queue);

    // 3. Retrieving Elements
    System.out.println("Front Element (peek): " + queue.peek()); // Returns null if empty
    System.out.println("Front Element (element): " + queue.element()); // Throws exception if empty

    // 4. Removing Elements (Dequeue)
    System.out.println("Removed Element (poll): " + queue.poll()); // Returns null if empty
    System.out.println("Removed Element (remove): " + queue.remove()); // Throws exception if empty

    System.out.println("Queue after removal: " + queue);

    // 5. Iterating through Queue
    System.out.println("Iterating through Queue:");
    for (Integer num : queue) {
      System.out.println(num);
    }

    // 6. Checking if Queue is Empty
    System.out.println("Is Queue Empty? " + queue.isEmpty());

    // 7. Queue Size
    System.out.println("Queue Size: " + queue.size());

    // 8. Clearing the Queue
    queue.clear();
    System.out.println("Queue after clearing: " + queue);

    // 9. Handling Exceptions
    try {
      queue.remove(); // Throws NoSuchElementException
    } catch (Exception e) {
      System.out.println("Exception on remove() when queue is empty: " + e);
    }

    try {
      queue.element(); // Throws NoSuchElementException
    } catch (Exception e) {
      System.out.println("Exception on element() when queue is empty: " + e);
    }
  }
}
