package com.interviewprep.concurrency.thread.lifecycle.states.blocked;

public class SharedResource {
  synchronized void access() {
    System.out.println(Thread.currentThread().getName() + " got the lock.");

    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
