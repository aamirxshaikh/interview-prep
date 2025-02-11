package com.interviewprep.java_collections_framework.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {
  public static void main(String[] args) {
    // 1. Creating a PriorityQueue (Min-Heap by default)
    Queue<Integer> pq = new PriorityQueue<>();

    // 2. Adding Elements (Enqueue)
    pq.offer(30);
    pq.offer(10);
    pq.offer(20);
    pq.offer(40);

    System.out.println("PriorityQueue after adding elements: " + pq);

    // 3. Retrieving Elements
    System.out.println("Front Element (peek): " + pq.peek()); // Returns null if empty
    System.out.println("Front Element (element): " + pq.element()); // Throws exception if empty

    // 4. Removing Elements (Dequeue - always removes smallest element)
    System.out.println("Removed Element (poll): " + pq.poll()); // Returns null if empty
    System.out.println("Removed Element (remove): " + pq.remove()); // Throws exception if empty

    System.out.println("PriorityQueue after removal: " + pq);

    // 5. Iterating through PriorityQueue
    System.out.println("Iterating through PriorityQueue:");
    for (Integer num : pq) {
      System.out.println(num);
    }

    // 6. Checking if PriorityQueue is Empty
    System.out.println("Is PriorityQueue Empty? " + pq.isEmpty());

    // 7. PriorityQueue Size
    System.out.println("PriorityQueue Size: " + pq.size());

    // 8. Clearing the PriorityQueue
    pq.clear();
    System.out.println("PriorityQueue after clearing: " + pq);

    // 9. Handling Exceptions
    try {
      pq.remove(); // Throws NoSuchElementException
    } catch (Exception e) {
      System.out.println("Exception on remove() when PriorityQueue is empty: " + e);
    }

    try {
      pq.element(); // Throws NoSuchElementException
    } catch (Exception e) {
      System.out.println("Exception on element() when PriorityQueue is empty: " + e);
    }

    // 10. Demonstrating Max-Heap using Custom Comparator
    Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    maxHeap.offer(30);
    maxHeap.offer(10);
    maxHeap.offer(20);
    maxHeap.offer(40);

    System.out.println("Max-Heap PriorityQueue: " + maxHeap);
    System.out.println("Max-Heap Front Element (peek): " + maxHeap.peek());
    System.out.println("Max-Heap Removed Element (poll): " + maxHeap.poll());
    System.out.println("Max-Heap after removal: " + maxHeap);

  }
}
