package com.interviewprep.concurrency.thread.thread_class;

public class Printer extends Thread {
  public Printer(String name) {
    super(name);
  }

  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      System.out.println(Thread.currentThread().getName() + " " + i);
    }
  }
}
