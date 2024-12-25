package com.interviewprep.java_collections_framework.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    // Create a list of students
    List<Student> students = new ArrayList<>();
    students.add(new Student("John", 20));
    students.add(new Student("Alice", 22));
    students.add(new Student("Bob", 21));
    students.add(new Student("Li", 18));

    // Print the list of students before sorting
    System.out.println("Before sorting:");
    students.forEach(System.out::println);

    // Sort the list of students by age using the sort method of the Collections class
    Collections.sort(students);

    // Sort the list of students by age using the sort method of the List interface
//    students.sort(null);

    // Print the list of students after sorting
    System.out.println("\nAfter sorting by age:");
    students.forEach(System.out::println);
  }
}
