package com.interviewprep.concurrency.thread.lifecycle.states.all;

public class MyThread extends Thread {
  @Override
  public void run() {
    System.out.println("Thread is running...");

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      System.out.println("Thread interrupted");
      Thread.currentThread().interrupt();
    }

    // Simulate waiting for a lock (BLOCKED state)
    synchronized (MyThread.class) {
      System.out.println("Thread acquired the lock and is running...");
    }
  }
}
