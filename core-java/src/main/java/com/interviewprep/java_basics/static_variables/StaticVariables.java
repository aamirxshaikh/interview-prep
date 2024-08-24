package com.interviewprep.java_basics.static_variables;

/**
 * Static variables are shared among all instances of a class. They are initialized only once at the start of the execution.
 *
 * @author aamir on 8/24/24
 */
public class StaticVariables {
  static int counter = 0;

  public StaticVariables() {
    counter++;
  }

  public static void main(String[] args) {
    StaticVariables obj1 = new StaticVariables();
    StaticVariables obj2 = new StaticVariables();
    StaticVariables obj3 = new StaticVariables();

    System.out.println("Number of instances created: " + counter);
  }
}
