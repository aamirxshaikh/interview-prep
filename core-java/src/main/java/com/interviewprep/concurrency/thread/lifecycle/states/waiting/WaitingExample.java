package com.interviewprep.concurrency.thread.lifecycle.states.waiting;

public class WaitingExample {
  synchronized void waitingMethod() {
    try {
      System.out.println(Thread.currentThread().getName() + " is waiting...");
      wait(); // Thread enters WAITING state
      System.out.println(Thread.currentThread().getName() + " resumed...");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  synchronized void notifyingMethod() {
    notify(); // Notify the waiting thread
    System.out.println("Thread notified...");
  }
}
