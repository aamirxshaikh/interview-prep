package com.interviewprep.java_collections_framework.map.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
  public static void main(String[] args) {
    // 1. Maintaining Insertion Order
    System.out.println("Example 1: Insertion Order");
    LinkedHashMap<Integer, String> insertionOrderMap = new LinkedHashMap<>();
    insertionOrderMap.put(1, "Apple");
    insertionOrderMap.put(2, "Banana");
    insertionOrderMap.put(3, "Cherry");

    System.out.println("Original Map: " + insertionOrderMap);

    // Iterate through the map
    for (Map.Entry<Integer, String> entry : insertionOrderMap.entrySet()) {
      System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
    }

    // 2. Maintaining Access Order
    System.out.println("\nExample 2: Access Order");
    LinkedHashMap<Integer, String> accessOrderMap = new LinkedHashMap<>(16, 0.75f, true); // Enable access order
    accessOrderMap.put(1, "Dog");
    accessOrderMap.put(2, "Cat");
    accessOrderMap.put(3, "Elephant");

    System.out.println("Original Map: " + accessOrderMap);

    // Access elements
    accessOrderMap.get(2); // Access "Cat"
    accessOrderMap.get(1); // Access "Dog"
    System.out.println("Map after accessing keys 2 and 1: " + accessOrderMap);

    // 3. Using LinkedHashMap for Custom Sorting (not natively supported)
    System.out.println("\nExample 4: Custom Sorting (Manual Implementation)");
    LinkedHashMap<Integer, String> customMap = new LinkedHashMap<>();
    customMap.put(10, "Ten");
    customMap.put(5, "Five");
    customMap.put(15, "Fifteen");

    System.out.println("Original Custom Map: " + customMap);

    // Sort manually (LinkedHashMap itself does not sort)
    customMap.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(entry -> System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue()));
  }
}
