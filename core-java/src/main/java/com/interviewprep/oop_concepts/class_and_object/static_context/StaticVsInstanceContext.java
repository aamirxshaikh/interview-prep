package com.interviewprep.oop_concepts.class_and_object.static_context;

public class StaticVsInstanceContext {
  private static int staticCounter = 0;
  private int instanceCounter = 0;

  public StaticVsInstanceContext() {
    staticCounter++;
    instanceCounter++;
  }

  public void displayCounters() {
    System.out.println("Static Counter: " + staticCounter);
    System.out.println("Instance Counter: " + instanceCounter);
  }

  public static void main(String[] args) {
    StaticVsInstanceContext obj1 = new StaticVsInstanceContext();
    StaticVsInstanceContext obj2 = new StaticVsInstanceContext();

    obj1.displayCounters();
    obj2.displayCounters();
  }
}
