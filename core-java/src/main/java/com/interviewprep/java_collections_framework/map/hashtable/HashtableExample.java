package com.interviewprep.java_collections_framework.map.hashtable;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashtableExample {
  public static void main(String[] args) {
    // 1. Creating a Hashtable
    Hashtable<Integer, String> hashtable = new Hashtable<>();

    // 2. Adding Key-Value Pairs
    hashtable.put(1, "Alice");
    hashtable.put(2, "Bob");
    hashtable.put(3, "Charlie");
    hashtable.put(4, "David");

    System.out.println("Initial Hashtable: " + hashtable);

    // 3. Accessing Elements
    System.out.println("Value for key 2: " + hashtable.get(2));

    // 4. Checking if a Key or Value Exists
    System.out.println("Does key 3 exist? " + hashtable.containsKey(3));
    System.out.println("Does value 'Eve' exist? " + hashtable.containsValue("Eve"));

    // 5. Removing an Element
    hashtable.remove(4);
    System.out.println("After Removing Key 4: " + hashtable);

    // 6. Iterating Through Hashtable
    System.out.println("Iterating through Hashtable using keys:");
    for (Integer key : hashtable.keySet()) {
      System.out.println("Key: " + key + ", Value: " + hashtable.get(key));
    }

    System.out.println("Iterating through Hashtable using Enumeration:");
    Enumeration<Integer> keys = hashtable.keys();
    while (keys.hasMoreElements()) {
      Integer key = keys.nextElement();
      System.out.println("Key: " + key + ", Value: " + hashtable.get(key));
    }

    // 7. Hashtable Properties
    System.out.println("Size of Hashtable: " + hashtable.size());
    System.out.println("Is Hashtable empty? " + hashtable.isEmpty());

    // 8. Working with Null Keys and Values
    try {
      hashtable.put(null, "NullKey"); // Throws NullPointerException
    } catch (NullPointerException e) {
      System.out.println("Cannot add null key: " + e.getMessage());
    }

    try {
      hashtable.put(5, null); // Throws NullPointerException
    } catch (NullPointerException e) {
      System.out.println("Cannot add null value: " + e.getMessage());
    }

    // 9. Synchronization Example
    synchronized (hashtable) {
      System.out.println("Iterating through synchronized block:");
      for (Integer key : hashtable.keySet()) {
        System.out.println("Key: " + key + ", Value: " + hashtable.get(key));
      }
    }

    // 10. Cloning a Hashtable
    Hashtable<Integer, String> clonedHashtable = (Hashtable<Integer, String>) hashtable.clone();
    System.out.println("Cloned Hashtable: " + clonedHashtable);

    // 11. Clearing the Hashtable
    hashtable.clear();
    System.out.println("After Clearing: " + hashtable);
  }
}

