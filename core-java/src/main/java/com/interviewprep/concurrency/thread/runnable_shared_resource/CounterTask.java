package com.interviewprep.concurrency.thread.runnable_shared_resource;

public class CounterTask implements Runnable {
  private final SharedCounter sharedCounter;

  public CounterTask(SharedCounter sharedCounter) {
    this.sharedCounter = sharedCounter;
  }

  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      sharedCounter.increment();

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        System.out.println(Thread.currentThread().getName() + " interrupted");
        Thread.currentThread().interrupt();
      }
    }
  }
}
