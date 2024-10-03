package com.interviewprep.oop_concepts.encapsulation.immutable_classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Person {

  // Private and final fields
  private final String name;
  private final int age;
  private final LocalDate birthDate; // LocalDate is immutable
  private final List<String> friends; // Mutable list, requires defensive copying

  // Constructor to initialize all fields
  public Person(String name, int age, LocalDate birthDate, List<String> friends) {
    this.name = name;
    this.age = age;
    // No need for a defensive copy, as LocalDate is already immutable
    this.birthDate = birthDate;
    // Defensive copy of mutable list
    this.friends = new ArrayList<>(friends);
  }

  // Getter for 'name'
  public String getName() {
    return name;
  }

  // Getter for 'age'
  public int getAge() {
    return age;
  }

  // Getter for 'birthDate'
  public LocalDate getBirthDate() {
    return birthDate;
  }

  // Getter for 'friends' with defensive copy to prevent external modification
  public List<String> getFriends() {
    return new ArrayList<>(friends);
  }

  // No setter methods to maintain immutability
}