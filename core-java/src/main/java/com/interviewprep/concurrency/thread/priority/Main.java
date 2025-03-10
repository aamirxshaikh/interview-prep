package com.interviewprep.concurrency.thread.priority;

public class Main {
  public static void main(String[] args) {
    // Creating threads using Lambda expressions
    Thread lowPriorityThread = new Thread(Main::run, "Low Priority Thread");

    Thread normalPriorityThread = new Thread(Main::run, "Normal Priority Thread");

    Thread highPriorityThread = new Thread(Main::run, "High Priority Thread");

    // Setting different thread priorities
    lowPriorityThread.setPriority(Thread.MIN_PRIORITY);  // 1
    normalPriorityThread.setPriority(Thread.NORM_PRIORITY); // 5
    highPriorityThread.setPriority(Thread.MAX_PRIORITY); // 10

    // Starting threads
    lowPriorityThread.start();
    normalPriorityThread.start();
    highPriorityThread.start();
  }

  private static void run() {
    for (int i = 1; i <= 10; i++) {
      System.out.println(Thread.currentThread().getName() +
              " (Priority: " + Thread.currentThread().getPriority() + ") → " + i);
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        System.out.println("Thread interrupted: " + Thread.currentThread().getName());
        Thread.currentThread().interrupt();
      }
    }
  }
}
