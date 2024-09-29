package com.interviewprep.oop_concepts.class_and_object.encapsulation.immutable_classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
// Mutable list of friends
    List<String> friendsList = new ArrayList<>();
    friendsList.add("Alice");
    friendsList.add("Bob");

    // Creating a Person object
    Person person = new Person("John Doe", 30, LocalDate.of(1990, 5, 15), friendsList);

    // Try to modify the original list after the Person object is created
    friendsList.add("Charlie");  // This won't affect the person's list of friends

    // Printing details
    System.out.println("Friends of " + person.getName() + ": " + person.getFriends());

    // Try to modify the returned list from getFriends() method
    List<String> retrievedFriends = person.getFriends();
    retrievedFriends.add("David");  // This won't modify the original friends list

    // Printing details again to see if the internal list is unchanged
    System.out.println("Friends after external modification attempt: " + person.getFriends());
  }
}
