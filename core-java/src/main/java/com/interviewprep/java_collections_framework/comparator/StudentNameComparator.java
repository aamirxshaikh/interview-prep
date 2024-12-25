package com.interviewprep.java_collections_framework.comparator;

import java.util.Comparator;

public class StudentNameComparator implements Comparator<Student> {
  /**
   * Compares its two arguments for order. Returns a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
   * Sorts the students by name.
   *
   * @param s1 the first object to be compared.
   * @param s2 the second object to be compared.
   * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
   */
  @Override
  public int compare(Student s1, Student s2) {
    return s1.getName().compareTo(s2.getName());
  }
}
