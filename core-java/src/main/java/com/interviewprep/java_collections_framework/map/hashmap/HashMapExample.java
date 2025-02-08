package com.interviewprep.java_collections_framework.map.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
  public static void main(String[] args) {
    // 1. Basic Usage of HashMap
    System.out.println("Example 1: Basic Usage");
    HashMap<Integer, String> map = new HashMap<>();
    map.put(1, "Apple");
    map.put(2, "Banana");
    map.put(3, "Cherry");

    // Retrieve and print values
    System.out.println("Value for key 2: " + map.get(2));
    System.out.println("Complete Map: " + map);

    // 2. Handling Null Keys and Values
    System.out.println("\nExample 2: Handling Null Keys and Values");
    map.put(null, "NullKey");
    map.put(4, null);

    System.out.println("Map after adding null key and value: " + map);

    // 3. Iterating Over HashMap
    System.out.println("\nExample 3: Iterating Over HashMap");
    for (Map.Entry<Integer, String> entry : map.entrySet()) {
      System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
    }

    // 4. Overwriting an Existing Key
    System.out.println("\nExample 4: Overwriting an Existing Key");
    map.put(2, "Blueberry");
    System.out.println("Map after updating key 2: " + map);

    // 5. Checking for Existence
    System.out.println("\nExample 5: Checking for Key and Value Existence");
    System.out.println("Contains key 3: " + map.containsKey(3));
    System.out.println("Contains value 'Cherry': " + map.containsValue("Cherry"));

    // 6. Removing Elements
    System.out.println("\nExample 6: Removing Elements");
    map.remove(3);
    System.out.println("Map after removing key 3: " + map);

    // 7. Handling Collisions (Demonstration via Custom HashCode)
    System.out.println("\nExample 7: Handling Collisions");
    Map<CustomKey, String> collisionMap = new HashMap<>();

    collisionMap.put(new CustomKey(1), "Value1");
    collisionMap.put(new CustomKey(2), "Value2");
    collisionMap.put(new CustomKey(1), "OverwrittenValue");

    for (Map.Entry<CustomKey, String> entry : collisionMap.entrySet()) {
      System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
    }
  }
}

// Custom Key Class to Demonstrate Collision Handling
class CustomKey {
  private final int id;

  public CustomKey(int id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CustomKey customKey = (CustomKey) o;
    return id == customKey.id;
  }

  @Override
  public int hashCode() {
    return id % 2; // Intentionally returning the same hash for collision demonstration
  }

  @Override
  public String toString() {
    return "CustomKey{" +
            "id=" + id +
            '}';
  }
}