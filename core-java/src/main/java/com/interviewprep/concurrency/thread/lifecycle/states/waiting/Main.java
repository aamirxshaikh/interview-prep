package com.interviewprep.concurrency.thread.lifecycle.states.waiting;

public class Main {
  public static void main(String[] args) throws InterruptedException {
    WaitingExample obj = new WaitingExample();

    Thread t1 = new Thread(obj::waitingMethod);
    t1.start();

    // Give some time for the thread to go into WAITING state
    Thread.sleep(1000);
    System.out.println("Thread state: " + t1.getState()); // WAITING

    Thread t2 = new Thread(obj::notifyingMethod);
    t2.start();

    t1.join(); // Ensure t1 completes
    System.out.println("Thread state after completion: " + t1.getState()); // TERMINATED
  }
}

