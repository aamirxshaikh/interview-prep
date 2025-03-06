package com.interviewprep.concurrency.thread.lifecycle.states.blocked;

public class Main {
  public static void main(String[] args) throws InterruptedException {
    SharedResource resource = new SharedResource();

    Thread t1 = new Thread(resource::access);
    Thread t2 = new Thread(resource::access);

    t1.start();
    Thread.sleep(100); // Ensure Thread-0 gets the lock first
    t2.start();

    Thread.sleep(100); // Allow time for Thread-1 to be blocked
    System.out.println(t2.getState()); // BLOCKED if t1 is holding the lock
  }
}
