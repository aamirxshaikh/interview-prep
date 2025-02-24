package com.interviewprep.concurrency.thread.runnable_shared_resource;

public class SharedCounter {
  private int count = 0;

  public synchronized void increment() {
    count++;
    System.out.println(Thread.currentThread().getName() + " incremented counter to: " + count);
  }

  public synchronized int getCount() {
    return count;
  }
}
