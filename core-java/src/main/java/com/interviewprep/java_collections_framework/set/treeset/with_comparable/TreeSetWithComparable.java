package com.interviewprep.java_collections_framework.set.treeset.with_comparable;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

class Person implements Comparable<Person> {
  private final String name;
  private final int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return name + ": " + age;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return age == person.age && Objects.equals(name, person.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age);
  }

  @Override
  public int compareTo(Person other) {
    return Integer.compare(this.age, other.age);
  }
}

public class TreeSetWithComparable {
  public static void main(String[] args) {
    Set<Person> peopleSet = new TreeSet<>();

    peopleSet.add(new Person("Alice", 30));
    peopleSet.add(new Person("Bob", 25));
    peopleSet.add(new Person("Jane", 30));
    peopleSet.add(new Person("Charlie", 28));

    System.out.println("TreeSet with Comparable (custom object): " + peopleSet);
  }
}
