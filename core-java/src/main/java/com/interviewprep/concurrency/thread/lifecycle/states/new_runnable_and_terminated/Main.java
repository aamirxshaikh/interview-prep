package com.interviewprep.concurrency.thread.lifecycle.states.new_runnable_and_terminated;

public class Main {
  public static void main(String[] args) throws InterruptedException {
// Create a thread (NEW state)
    Thread thread = new Thread(() -> System.out.println("Thread is running..."));

    // Print NEW state
    System.out.println("Thread state after creation: " + thread.getState()); // NEW

    // Start the thread (transition to RUNNABLE)
    thread.start();
    System.out.println("Thread state after start: " + thread.getState()); // RUNNABLE or TERMINATED (if very fast)

    // Wait for the thread to finish
    thread.join();
    System.out.println("Thread state after completion: " + thread.getState()); // TERMINATED
  }
}
