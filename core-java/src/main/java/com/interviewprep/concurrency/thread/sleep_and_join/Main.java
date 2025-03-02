package com.interviewprep.concurrency.thread.sleep_and_join;

public class Main {
  public static void main(String[] args) {
    // Create a thread
    Thread workerThread = new Thread(() -> {
      System.out.println(Thread.currentThread().getName() + " is starting...");

      // Simulate some work using sleep()
      try {
        System.out.println(Thread.currentThread().getName() + " is working...");
        Thread.sleep(3000); // Sleep for 3 seconds
      } catch (InterruptedException e) {
        System.out.println(Thread.currentThread().getName() + " was interrupted!");
      }

      System.out.println(Thread.currentThread().getName() + " has finished.");
    }, "WorkerThread");

    // Start the worker thread
    workerThread.start();

    // Main thread continues execution
    System.out.println(Thread.currentThread().getName() + " is running...");

    // Simulate some work in the main thread
    try {
      System.out.println(Thread.currentThread().getName() + " is doing some work...");
      Thread.sleep(1000); // Sleep for 1 second
    } catch (InterruptedException e) {
      System.out.println(Thread.currentThread().getName() + " was interrupted!");
    }

    // Wait for the worker thread to finish using join()
    System.out.println(Thread.currentThread().getName() + " is waiting for " + workerThread.getName() + " to finish...");
    try {
      workerThread.join(); // Wait for workerThread to complete
    } catch (InterruptedException e) {
      System.out.println(Thread.currentThread().getName() + " was interrupted while waiting!");
    }

    // Main thread continues after workerThread finishes
    System.out.println(Thread.currentThread().getName() + " has finished waiting.");
    System.out.println(Thread.currentThread().getName() + " is exiting.");
  }
}
