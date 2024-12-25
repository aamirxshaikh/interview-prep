package com.interviewprep.java_collections_framework.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Student> students = new ArrayList<>();
    students.add(new Student("John", 20));
    students.add(new Student("Alice", 22));
    students.add(new Student("Bob", 21));
    students.add(new Student("Li", 18));

    System.out.println("Before sorting:");
    students.forEach(System.out::println);

    // Sort the students by name using an anonymous class
    students.sort(new Comparator<Student>() {
      @Override
      public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
      }
    });

    // Sort the students by name using the StudentNameComparator class
    students.sort(new StudentNameComparator());

    // Sort the students by name using a lambda expression
    Comparator<Student> studentComparator = (s1, s2) -> s1.getName().compareTo(s2.getName());
    students.sort(studentComparator);

    // Sort the students by name using lambda expression method reference
    students.sort(Comparator.comparing(Student::getName));

    // Sort the students by age using lambda expression method reference
    students.sort(Comparator.comparingInt(Student::getAge));

    // Sort the students by age then by name then by name length using lambda expression method reference
    students.sort(Comparator.comparingInt(Student::getAge)
            .thenComparing(Student::getName)
            .thenComparing(s -> s.getName().length()));

    System.out.println("\nAfter sorting by name:");
    students.forEach(System.out::println);

  }
}
