package com.interviewprep.java_collections_framework.set.treeset.with_comparator_custom_object;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Person {
  String name;
  int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return name + ": " + age;
  }
}

public class TreeSetWithComparator {
  public static void main(String[] args) {
    // Create a TreeSet with a custom Comparator to sort by name
    Comparator<Person> nameComparator = (p1, p2) -> p1.name.compareTo(p2.name);
    Set<Person> peopleSet = new TreeSet<>(nameComparator);

    peopleSet.add(new Person("Alice", 30));
    peopleSet.add(new Person("Charlie", 28));
    peopleSet.add(new Person("Bob", 25));

    System.out.println("TreeSet with Comparator (custom object): " + peopleSet);
  }
}
