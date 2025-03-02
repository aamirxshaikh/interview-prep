package com.interviewprep.concurrency.thread.sleep_and_join;

public class Task extends Thread {
  @Override
  public void run() {
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
    System.out.println("Task started");
  }
}
