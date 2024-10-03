package com.interviewprep.oop_concepts.abstraction.interface_and_multiple_inheritance;

interface Printable {
  void print();
}

interface Showable {
  void show();
}

// Implementing multiple interfaces
class Document implements Printable, Showable {
  @Override
  public void print() {
    System.out.println("Printing document...");
  }

  @Override
  public void show() {
    System.out.println("Showing document...");
  }
}

public class Main {
  public static void main(String[] args) {
    Document doc = new Document();
    doc.print();  // Output: Printing document...
    doc.show();   // Output: Showing document...
  }
}
