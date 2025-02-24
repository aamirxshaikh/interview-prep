package com.interviewprep.concurrency.thread.thread_class;

public class Main {
  public static void main(String[] args) {
    Printer printer = new Printer();
    printer.start();

    for (int i = 0; i < 5; i++) {
      System.out.println(Thread.currentThread().getName() + " " + i);
    }
  }
}
