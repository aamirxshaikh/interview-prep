package com.interviewprep.concurrency.thread.lifecycle.states.timed_waiting;

public class Main {
  public static void main(String[] args) throws InterruptedException {
    Thread t1 = new Thread(() -> {
      try {
        System.out.println("Thread is sleeping...");
        Thread.sleep(3000); // Thread enters TIMED_WAITING for 3 sec
        System.out.println("Thread woke up...");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    t1.start();

    // Give some time for the thread to go into TIMED_WAITING state
    Thread.sleep(1000);
    System.out.println("Thread state: " + t1.getState()); // TIMED_WAITING

    t1.join();
    System.out.println("Thread state after completion: " + t1.getState()); // TERMINATED
  }
}
