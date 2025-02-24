package com.interviewprep.concurrency.thread.runnable_shared_resource;

public class Main {
  public static void main(String[] args) {
    SharedCounter sharedCounter = new SharedCounter();

    // Create multiple threads that share the same counter
    Thread thread1 = new Thread(new CounterTask(sharedCounter), "Thread-1");
    Thread thread2 = new Thread(new CounterTask(sharedCounter), "Thread-2");
    Thread thread3 = new Thread(new CounterTask(sharedCounter), "Thread-3");

    // Start the threads
    thread1.start();
    thread2.start();
    thread3.start();

    // Wait for all threads to finish
    try {
      thread1.join();
      thread2.join();
      thread3.join();
    } catch (InterruptedException e) {
      System.out.println("Main thread interrupted");
      Thread.currentThread().interrupt();
    }

    // Print the final counter value
    System.out.println("Final counter value: " + sharedCounter.getCount());
  }
}
