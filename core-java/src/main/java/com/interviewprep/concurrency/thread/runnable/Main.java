package com.interviewprep.concurrency.thread.runnable;

public class Main {
  public static void main(String[] args) {
    Task task = new Task();
    Thread thread = new Thread(task);
    thread.start();

    // Implement runnable using lambda expression
    Runnable runnable = () -> {
      for (int i = 0; i < 5; i++) {
        System.out.println(Thread.currentThread().getName() + " " + i);
      }
    };

    Thread thread2 = new Thread(runnable);
    thread2.start();

    // dynamically print which thread is running
    for (int i = 0; i < 5; i++) {
      System.out.println(Thread.currentThread().getName() + " " + i);
    }
  }
}
