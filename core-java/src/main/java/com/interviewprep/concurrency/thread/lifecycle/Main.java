package com.interviewprep.concurrency.thread.lifecycle;

public class Main {
  public static void main(String[] args) throws InterruptedException {
    // Create a thread
    MyThread thread = new MyThread();

    // Print initial state (NEW)
    System.out.println("Thread state after creation: " + thread.getState());

    // Start the thread (transition to RUNNABLE)
    thread.start();
    System.out.println("Thread state after start: " + thread.getState());

    // Simulate main thread waiting for a short time
    Thread.sleep(100);
    System.out.println("Thread state after sleep: " + thread.getState());

    // Simulate blocking by acquiring a lock
    synchronized (MyThread.class) {
      System.out.println("Main thread acquired the lock...");

      // Let the thread try to acquire the lock (BLOCKED state)
      Thread.sleep(2000);
      System.out.println("Thread state while waiting for lock: " + thread.getState());
    }

    // Wait for the thread to finish (TERMINATED state)
    thread.join();
    System.out.println("Thread state after completion: " + thread.getState());
  }
}
